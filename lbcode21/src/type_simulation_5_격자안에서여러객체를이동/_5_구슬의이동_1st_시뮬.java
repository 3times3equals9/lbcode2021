package type_simulation_5_격자안에서여러객체를이동;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _5_구슬의이동_1st_시뮬 {
	
	static class Tuple implements Comparable<Tuple>{
		public int aa;
		public int bb;
		public int cc;
		public Tuple() {
			super();
		}
		public Tuple(int aa, int bb, int cc) {
			super();
			this.aa = aa;
			this.bb = bb;
			this.cc = cc;
		}
		//v, num, next_dir
		//우선순위가 높다는 말은, 구슬의 속도가 더 빠르거나 구슬의 속도가 일치하더라도 구슬의 번호가 더 큰 경우를 뜻합니다.
		@Override
		public int compareTo(Tuple o) {
			if(this.aa != o.aa) {
				return -(this.aa - o.aa);
			} else {
				//if(this.bb != o.bb) {
				return -(this.bb - o.bb);
				//} 
			}
		}
		@Override
		public String toString() {
			return "Tuple [v=" + aa + ", num=" + bb + ", dir=" + cc + "]";
		}
		
	}
	
	static final int MAX_N = 50;
	static final int ASCII_NUM = 128;
	static final int DIR_NUM = 4;
	
	static int n, m, t, k;
	static ArrayList<Tuple>[][] grid;
	static ArrayList<Tuple>[][] next_grid;
	
	static boolean InRange(int x, int y) {
	    return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	static Tuple NextPos(int x, int y, int vnum, int move_dir) {
		int[] dx = {-1, 0, 0, 1};
		int[] dy = {0, 1, -1, 0};
	    
	    // vnum 횟수만큼 이동한 이후의 위치를 반환합니다.
	    while(vnum-- > 0) {
	        int nx = x + dx[move_dir], ny = y + dy[move_dir];
	        // 벽에 부딪히면
	        // 방향을 바꾼 뒤 이동합니다.
	        if(!InRange(nx, ny)) {
	            move_dir = 3 - move_dir;
	            nx = x + dx[move_dir]; ny = y + dy[move_dir];
	        }
	        x = nx; y = ny;
	    }
	    return new Tuple(x, y, move_dir);
	}
	
	static void MoveAll() {
	    for(int x = 0; x < n; x++)
	        for(int y = 0; y < n; y++)
	            for(int i = 0; i < grid[x][y].size(); i++) {
	                int v, num, move_dir;
	                //tie(v, num, move_dir) = grid[x][y][i];
	                v = grid[x][y].get(i).aa;
	                num = grid[x][y].get(i).bb;
	                move_dir = grid[x][y].get(i).cc;
	                		
	                int next_x, next_y, next_dir;
	                // v값이 음수이므로, -를 붙여 넘겨줍니다. : C++ 한정
	                //tie(next_x, next_y, next_dir) = NextPos(x, y, -v, move_dir);
	                Tuple tmp_tp = NextPos(x, y, v, move_dir);
	                next_x = tmp_tp.aa;
	                next_y = tmp_tp.bb;
	                next_dir = tmp_tp.cc;
	                
	                next_grid[next_x][next_y].add(
	                    new Tuple(v, num, next_dir)
	                );
	            }
	}
	
	static void SelectMarbles() {
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++) 
	            if( next_grid[i][j].size() >= k) {
	                // 우선순위가 높은 k개만 남겨줍니다.
	                //sort(next_grid[i][j].begin(), next_grid[i][j].end());
	            	Collections.sort(next_grid[i][j]);
	                while(next_grid[i][j].size() > k) {
	                	int list_size = next_grid[i][j].size();
	                    next_grid[i][j].remove(list_size-1);
	                }
	            }
	}

	static void Simulate() {
	    // Step1. next_grid를 초기화합니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            next_grid[i][j] = new ArrayList<>();

	    /**
	    	next_grid[i][j].clear();
	    	 하니까 밑에서 
	    	 grid[i][j] = next_grid[i][j];
	    	 한거때문에
	    	 grid도 다 날라감... 씨팔...
	    */
	    
	    System.out.println("MoveAll 전 =======");
	    for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(grid[i][j].size() + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j].size() > 0) {
					System.out.println("row : " + (i+1) + " / col : " + (j+1));
					for(int q=0; q<grid[i][j].size(); q++) {
						System.out.println(grid[i][j].get(q).toString());
					}
				}
			}
		}
		System.out.println("===============");
	    
		
	    // Step2. 구슬들을 전부 움직입니다.
	    MoveAll();
	    
	    
	    System.out.println("MoveAll 하고나서 ==");
	    for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(next_grid[i][j].size() + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(next_grid[i][j].size() > 0) {
					System.out.println("row : " + (i+1) + " / col : " + (j+1));
					for(int q=0; q<next_grid[i][j].size(); q++) {
						System.out.println(next_grid[i][j].get(q).toString());
					}
				}
			}
		}
		System.out.println("===============");
	    
	    
	    // Step3. 각 칸마다 구슬이 최대 k개만 있도록 조정합니다.
	    SelectMarbles();
	    
	    
	    System.out.println("SelectMarbles 하고나서 ==");
	    for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(next_grid[i][j].size() + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(next_grid[i][j].size() > 0) {
					System.out.println("row : " + (i+1) + " / col : " + (j+1));
					for(int q=0; q<next_grid[i][j].size(); q++) {
						System.out.println(next_grid[i][j].get(q).toString());
					}
				}
			}
		}
		System.out.println("===============");
		
		
	    // Step4. next_grid 값을 grid로 옮겨줍니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            grid[i][j] = next_grid[i][j];
	    
	    
	    System.out.println("grid로 값 옮김 =====");
	    for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(grid[i][j].size() + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j].size() > 0) {
					System.out.println("row : " + (i+1) + " / col : " + (j+1));
					for(int q=0; q<grid[i][j].size(); q++) {
						System.out.println(grid[i][j].get(q).toString());
					}
				}
			}
		}
		System.out.println("===============");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//vector<tuple<int, int, int> > grid[MAX_N][MAX_N];
		//vector<tuple<int, int, int> > next_grid[MAX_N][MAX_N];
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		k = sc.nextInt();
		
		grid = new ArrayList[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				grid[r][c] = new ArrayList<>();
			}
		}
		next_grid = new ArrayList[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				next_grid[r][c] = new ArrayList<>();
			}
		}
		
		int[] dir_mapper = new int[ASCII_NUM];
		dir_mapper['U'] = 0;
		dir_mapper['R'] = 1;
		dir_mapper['L'] = 2;
		dir_mapper['D'] = 3;
		
		for(int i = 0; i < m; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			char d = sc.next().charAt(0);
			int v = sc.nextInt();
	        // 살아남는 구슬의 우선순위가 더 빠른 속도, 더 큰 번호 이므로
	        // 정렬시 속도가 먼저 내림차순, 그 다음에는 번호가 내림차순으로 오도록
	        // (-속도, -번호, 방향) 순서를 유지합니다.
			//make_tuple(-v, -(i + 1), dir_mapper[d]) : 이건 C++한정 
			//자바는 그냥 집어넣으면 됨
			grid[r - 1][c - 1].add(
				new Tuple(v, (i + 1), dir_mapper[d])
	        );
		}
		
		/*
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(grid[i][j].size() + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j].size() > 0) {
					System.out.println("row : " + (i+1) + " / col : " + (j+1));
					for(int q=0; q<grid[i][j].size(); q++) {
						System.out.println(grid[i][j].get(q).toString());
					}
				}
			}
		}
		System.out.println("===============");
		*/
		
		// t초에 걸쳐 시뮬레이션을 반복합니다.
		while(t-- > 0) {
			Simulate();
		}
		int ans = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				ans += grid[i][j].size();
		
		System.out.println(ans);
		sc.close();
	}
}

/*
Intuition
살아남는 구슬의 우선순위가 속도, 번호 순이므로 구슬의 상태를 표현할 때 속도, 번호, 방향 순으로 관리하는 것이 좋습니다. 한 칸에 k개 이하의 구슬을 쉽게 유지하기 위해서는 구슬의 목록을 격자를 이용해 관리하는 것이 용이합니다.

Algorithm
이 문제에서는 구슬 목록을 하나의 리스트로 관리하지 않고, 각 격자 칸마다 놓여있는 구슬 목록을 들고 있는 것이 구현상 더 편리합니다. 격자내 칸 마다 리스트를 만들어 관리하면, 구슬을 k개 이하로 유지하는 처리를 비교적 간결하게 할 수 있기 때문입니다.

각 칸마다 우선순위가 높은 최대 k개의 구슬만 유지하기 위해, 우선순위에 따라 정렬을 한 뒤 앞에 있는 k개의 구슬만 유지하는 식으로 진행해볼 수 있습니다. 이때 살아남는 구슬의 우선순위가 속도, 번호 순이므로 구슬의 상태를 표현할 때 속도, 번호, 방향 순으로 적어주어 우선순위가 높은 구슬이 먼저 나오도록 하면 살아남을 구슬의 목록을 찾기가 용이해집니다.
*/





































































