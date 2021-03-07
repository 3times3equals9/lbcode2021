package study_week_2nd;

import java.util.LinkedList;
import java.util.Scanner;

public class _이상한윷놀이 {
	
	private static int N, K, color[][], horse[][]; 
	private static LinkedList<Integer>[][] map;
	
	//회전때문에 방향을 순서대로 해야함...
	//여기 적은건
	// 0:오른쪽, 1:아래, 2:왼쪽, 3:위쪽
	private static final int[] dr = {0, +1, 0, -1};
	private static final int[] dc = {+1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		color = new int[N][N];
		horse = new int[K][3];
		map = new LinkedList[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = new LinkedList<>();
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				color[r][c] = sc.nextInt();
			}
		}
		
		int hr, hc, hd;
		for(int i=0; i<K; i++) {
			hr = sc.nextInt()-1;
			hc = sc.nextInt()-1;
			hd = sc.nextInt();
			
			//d는 1일 경우 오른쪽, 2일 경우 왼쪽, 3일 경우 윗쪽, 4일 경우 아랫쪽을
			//dr,dc 에 맞게 바꿔줘야함
			if(hd == 1) {
				hd = 0;
			}else if(hd == 4) {
				hd = 1;
			}
			
			horse[i][0] = hr;
			horse[i][1] = hc;
			horse[i][2] = hd;
			
			map[hr][hc].add(i);
		}
		
		game();
		sc.close();
	}

	private static void game() {
		for(int t=1; t<=1000; t++) {
			for(int k=0; k<K; k++) {
				int r = horse[k][0];
				int c = horse[k][1];
				int d = horse[k][2];
				//해당 칸에서 말의 높이(인덱스)
				int num = searchOrder(k,r,c);
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || color[nr][nc] == 2) {
					horse[k][2] = d = (d+2)%4;
					nr = r + dr[d];
					nc = c + dc[d];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || color[nr][nc] == 2) {
						//방향을 바꿨는데도, 벽으로 or 파란색칸으로 가게되면 그만.
						//continue는 아래꺼 실행 무시하고 다시 반복문 처음으로 돌아감
						continue;
					}
				}
				
				if(move(r,c,nr,nc,num,color[nr][nc])) {
					System.out.println(t);
					return;
				}
			}
		}
		System.out.println("-1");
	}
	
	//move함수는 말을 움직이고, 게임이 끝났는지를 리턴.
	//게임이 끝나면 true, 아니면 false를 리턴
	private static boolean move(int r, int c, int nr, int nc, int num, int order) {
		//size == num 이 되는 순간, 옮기는 행위가 끝난다. size는 1-base, 인덱스(num)은 0-base
		while(map[r][c].size() > num) {
			int temp = -1;
			if(order == 0) {
				temp = map[r][c].remove(num);
			}else {
				temp = map[r][c].removeLast();
			}
			
			horse[temp][0] = nr;
			horse[temp][1] = nc;
			map[nr][nc].add(temp);
		}
		
		if(map[nr][nc].size() >= 4) {
			return true;
		}
		
		return false;
	}
	
	//n번째 말이 어디 위치하는지 찾기위한 함수. 말이 있는 칸에서 몇번째 높이(num, 인덱스)에 있는지 반환
	private static int searchOrder(int n, int r, int c) {
		for(int i=0; i<map[r][c].size(); i++) {
			if(map[r][c].get(i) == n) {
				return i;
			}
		}
		return -1;
	}
}
