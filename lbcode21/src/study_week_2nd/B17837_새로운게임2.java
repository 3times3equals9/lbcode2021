package study_week_2nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B17837_새로운게임2 {

	private static int N, K, color[][], horse[][];
	private static LinkedList<Integer>[][] map;
	private static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0}; // 0→, 1↓, 2←, 3↑ 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		color = new int[N][N];
		horse = new int[K][3];
		map = new LinkedList[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = new LinkedList<>();
			}
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int r, c, d;
		//행과 열의 번호는 1부터 시작하고, 이동 방향은 4보다 작거나 같은 자연수이고 1부터 순서대로 1→, 2←, 3↑, 4↓의 의미를 갖는다.
		//여기서 사용하는거로 바꾸면  0→, 2←, 3↑, 1↓
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			d = Integer.parseInt(st.nextToken());
			
			if(d==1) d=0;
			else if(d==4) d=1;
			
			horse[i][0] = r;
			horse[i][1] = c;
			horse[i][2] = d;
			
			map[r][c].add(i);
		}
		game();
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
	
	
	/**
	4. 말이 이동할 때, searchOrder에서 반환받은 높이인 num을 기준으로 말을 옮겨 준다.
	이 때, 옮기는 횟수는 칸의 총 높이(size)가 해당 말이 있는 위치(num) 보다 클 동안 반복해준다.
	D
	C
	A
	여기서 C부터 옮긴다고 가정하면, 높이는 1(맨 아래 A의 높이는 0)이 되고,
	이 높이 부터 리스트에서 remove(높이) 해서 옮겨 준다.
	만약, 반대로 쌓아야 할 경우, removeLast() 를 이용해서 옮겨준다.
	size > num 일 동안 옮겨 주기 때문에, size == num 이 되는 순간(여기서는 A만 남는 순간)
	옮기는 행위가 끝난다. 
	 */
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

//https://buddev.tistory.com/31