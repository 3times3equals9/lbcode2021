package study_week_3rd;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class _전투로봇 {
	
	private static class Cell implements Comparable<Cell>{
		int row, col, dis;

		public Cell(int row, int col, int dis) {
			super();
			this.row = row;
			this.col = col;
			this.dis = dis;
		}

		@Override
		public int compareTo(Cell o) {
			if(this.dis != o.dis) {
				return Integer.compare(this.dis, o.dis);
			}else if(this.row != o.row) {
				return Integer.compare(this.row, o.row);
			}
			return Integer.compare(this.col, o.col);
		}
	}
	
	static final int[] dr = {-1,0,+1,0};
	static final int[] dc = {0,+1,0,-1};
	
	static int N, baby_size;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Cell> q;
	static PriorityQueue<Cell> fish;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		//map 에는 물고기의 크기가 적혀있다.
		map = new int[N][N];
		q = new LinkedList<>();
		//가장 처음에 아기 상어의 크기는 2
		baby_size = 2;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 9) {
					q.add(new Cell(r,c,0));
					//나중에 아기상어가 지나가야해서 0으로 바꿔줌.
					//아기상어는 빈칸이거나, 자신보다 작은 크기, 같은크기 물고기를 지나갈 수 있음.
					//근데 물고기 크기는 1~6.
					//상어 숫자 9는 애매해서 0으로 바꿔줌.
					map[r][c] = 0;
				}
			}
		}
		sc.close();
		
		int eat_count = 0;
		int time = 0;
		
		while(true) {
			visited=new boolean[N][N];
			//물고기 저장할 우선순위 큐.
			fish = new PriorityQueue<>();
			//q는 상어 위치로 부터 물고기 탐색하는 용도. BFS 를 통해서 전체 탐색.
			while(!q.isEmpty()) {
				Cell cur = q.poll();
				visited[cur.row][cur.col] = true;
				for(int k=0; k<4; k++) {
					int nr = cur.row + dr[k];
					int nc = cur.col + dc[k];
					int nd = cur.dis;
					if(0<=nr && nr<N && 0<=nc && nc<N && map[nr][nc] <= baby_size && !visited[nr][nc]) {
						//한칸 이동했으니 거리 1 증가.
						nd++;
						//먹잇감 탐색. 물고기의 크기는 1~6. (0은 빈칸)
						if(1<=map[nr][nc] && map[nr][nc] <= 6 && map[nr][nc] < baby_size) {
							// 상어크기보다 작아서 잡아먹을 수 있는 경우.
							fish.add(new Cell(nr, nc, nd));
							// 또 그 위로 지나갈수도 있음.
							q.add(new Cell(nr, nc, nd));
//							System.out.println("잡아먹을물고기집어넣음.");
							visited[nr][nc] = true;
						} else if (map[nr][nc] == 0 || map[nr][nc] == baby_size) {
							// 상어크기랑 같은 경우는 지나갈수만 있음.
							q.add(new Cell(nr, nc, nd));
//							System.out.println("잡아먹을물고기집어넣음.");
							visited[nr][nc] = true;
						}
						// 상어보다 큰 물고기는 잡아먹지도, 그 위로 지나가지도 못함.
					}
				}
			}
			
			//더이상 먹을 수 있는 물고기가 없으면 종료.
			if(fish.isEmpty()) {
				System.out.println(time);
				System.exit(0);
				//return
			}
			
			//제일 가까운 => 제일 위의 => 제일 왼쪽의 물고기 고르기.
			//우선순위 큐로 바로 뽑아낼 수 있음.(오름차순 정렬)
			Cell eating_fish = fish.poll();
			
			//시간 추가. 1칸 이동에 1초 걸림.
			time += eating_fish.dis;
			//먹은 갯수 추가.
			eat_count++;
			//그 자리 물고기 없애줌.
			map[eating_fish.row][eating_fish.col] = 0;
			//상어 크기 X만큼 물고기 X마리 잡아먹었으면 상어 크기 증가.
			if(eat_count == baby_size) {
				baby_size++;
				//잡아먹은 물고기 마리 수 초기화!!!!!
				eat_count = 0;
			}
			//물고기 잡아먹은 자리에서 다시 상어 놓고 탐색 시작.
			q.add(new Cell(eating_fish.row,eating_fish.col,0));
		}
		
	}

}

