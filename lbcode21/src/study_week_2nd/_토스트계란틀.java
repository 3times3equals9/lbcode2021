package study_week_2nd;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _토스트계란틀 {
	
	private static class Cell{
		int r,c;

		public Cell(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static final int[] dr = {-1,0,+1,0};
	static final int[] dc = {0,+1,0,-1};
	
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		int count = 0;
		while(true) {
			//방문 초기화.
			visited = new boolean[N][N];
			if(!not_need_to_move()) {
				//인구이동이 필요한 경우, 이동하고 횟수 증가.
				count++;
			}else {
				//인구 이동이 더이상 필요하지 않으면 끝.
				break;
			}
		}
		
		System.out.println(count);
		sc.close();
	}
	
	//인구 이동이 필요한지 전체 지도 확인.
	private static boolean not_need_to_move() {
		List<Cell> list;
		//이동이 더이상 필요하지 않을 경우 true. 이동이 필요한 경우에 false로 바꿈.
		boolean is_done = true;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				//방문하지 않은 경우.
				if(!visited[r][c]) {
					list = new LinkedList<>();
//					list = new ArrayList<>();
					list.add(new Cell(r,c));
					//sum 은 리스트에 저장된 값의 합.
					int sum = dfs(r,c,list,0);
					if(list.size() > 1) {
						//리스트의 크기가 1 이상일 경우(= 인구 이동이 필요한 데이터가 있을 경우)
						change_pop(sum, list);
						//평균값 계산해서 map 갱신.
						is_done = false;
					}
				}
			}
		}
		return is_done;
	}

	//평균값으로 map 갱신.
	private static void change_pop(int sum, List<Cell> list) {
		int avg = sum/list.size();
		for(Cell cur : list) {
			map[cur.r][cur.c] = avg;
		}
	}
	
	//재귀, dfs. 리턴값은 탐색해서 나온 연합의 인구수 합.
	private static int dfs(int r, int c, List<Cell> list, int sum) {
		//파라미터 r,c 는 이전에서 넘어올 때, 방문 가능한 경우로 받은거임.
		//같은 연합 끼리는, 이 메서드 하나로 재귀 탐.
		visited[r][c] = true;
		sum = map[r][c];
		
		for(int k=0; k<4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(0<= nr && nr<N && 0<=nc && nc<N && !visited[nr][nc]) {
				int dif = Math.abs(map[r][c] - map[nr][nc]);
				if(L<=dif && dif<=R) {
					list.add(new Cell(nr,nc));
					//재귀를 이상하게 타네...
					//합친 sum 을 갱신하고, 그 sum 을 다음 dfs 파라미터로 넘겨주는듯.
					sum += dfs(nr,nc,list,sum);
				}
			}
		}
		//더이상 근처에 연합국가 없으면, sum 리턴.
		return sum;
	}
	
}


