package study_week_2nd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B17822_원판돌리기_제출용1 {
	//i번째 회전할때 사용하는 변수는 xi, di, ki이다.
	//번호가 xi의 배수인 원판을 di방향으로 ki칸 회전시킨다. 
	//di가 0인 경우는 시계 방향, 1인 경우는 반시계 방향이다.
	private static class Spot{
		int board;
		int piece;
		public Spot(int board, int piece) {
			this.board = board;
			this.piece = piece;
		}
	}
	// 0안, 1밖, 2좌, 3우. 
	static final int[] db = {-1,+1, 0, 0};
	static final int[] dp = { 0, 0,-1,+1};
	
	static int N,M,T;
	static int[][] map;
	static boolean[][] visited;
	static boolean isThereCloseAndSame;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		
		map = new int[N+1][M];
		//map[A][B] : A의 인덱스는 1~N 까지만 사용. B 는 0~M-1.
		for(int r=1; r<=N; r++) {
			for(int c=0; c<M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		//명령어들. Orders.
		for(int i=0; i<T; i++) {
			int tx = sc.nextInt();
			int td = sc.nextInt();
			int tk = sc.nextInt();
			
			//1)배수원판 돌리기.
			for(int unit = tx; unit <= N;  unit += tx) {
				rotateOne(map[unit], td, tk);
			}
			
			isThereCloseAndSame = removeCloseAndSame();
			
			//2-1)만약에 인접수 없으면, 원판 평균 구하고, 큰수-1, 작은수+1 해주기.
			if(!isThereCloseAndSame) {
				manipulate();
			}
		}
		
		int answer = getAnswer();
		System.out.println(answer);
		sc.close();
	}
	
	private static void rotateOne(int[] arr, int dir, int count) {
		//원판 하나 위의 숫자 갯수는 M 이라고 알려줌
		if(dir == 0) {
			//시계방향.
			for(int i=0; i<count; i++) {
				int temp = arr[M-1];
				for(int j=M-1; j>=1; j--) {
					arr[j] = arr[j-1];
				}
				arr[0] = temp;	
			}
		}else if(dir == 1) {
			//반시계방향.
			for(int i=0; i<count; i++) {
				int temp = arr[0];
				for(int j=0; j<=M-2; j++) {
					arr[j] = arr[j+1];
				}
				arr[M-1] = temp;	
			}
		}
	}
	
	private static boolean isOut(int board, int piece) {
		if (board < 1 || board > N || piece < 0 || piece >= M) {
			return true;
		}
		return false;
	}
	
	private static boolean removeCloseAndSame() {
		boolean inTotal = false;
		
		visited = new boolean[N+1][M];
		for(int r=1; r<=N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] != Integer.MAX_VALUE && !visited[r][c]) {
					int base = map[r][c];
//					boolean inPartial = false;
					
					Queue<Spot> q = new LinkedList<>();
					q.offer(new Spot(r,c));
					visited[r][c] = true;
					
					ArrayList<Spot> toRemove = new ArrayList<>();
					toRemove.add(new Spot(r,c));
					
					while(!q.isEmpty()) {
						Spot cur = q.poll();
						int cb = cur.board;
						int cp = cur.piece;
						
						for(int k=0; k<4; k++) {
							
							int nb = cb + db[k];
							int np = (cp + dp[k] + M) % M;
							
							if(isOut(nb, np)) {continue;}
							
							if(map[nb][np] == base && !visited[nb][np]) {
								q.offer(new Spot(nb, np));
								
								if(!inTotal) {
									inTotal = true;
								}
								
								toRemove.add(new Spot(nb,np));
								
								visited[nb][np] = true;
								map[nb][np] = Integer.MAX_VALUE;
							}
						}
					}
					
					if(toRemove.size()>=2) {
						for(Spot sp : toRemove) {
							map[sp.board][sp.piece] = Integer.MAX_VALUE;
						}
					}
					
				}
			}
		}
		
		return inTotal;
	}
	
	private static void manipulate() {
		int sum = 0, cnt = 0;
		double avg = 0.0;
		
		for(int r=1; r<=N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] != Integer.MAX_VALUE) {
					sum += map[r][c];
					cnt++;
				}
			}
		}
		
		if(cnt != 0) {
			avg = (double)sum/cnt;

			for(int r=1; r<=N; r++) {
				for(int c=0; c<M; c++) {
					if(map[r][c] != Integer.MAX_VALUE) {
						if((double)map[r][c] > avg) {
							map[r][c]--;
						}else if((double)map[r][c] < avg) {
							map[r][c]++;
						}
					}
				}
			}
		}
		
	}
	
	private static int getAnswer() {
		int ans = 0;
		
		for(int r=1; r<=N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] != Integer.MAX_VALUE) {
					ans += map[r][c];
				}
			}
		}
		return ans;
	}

}

























































