package study_week_3rd;

import java.util.Scanner;

public class _자율주행자동차 {
	
	//d가 0 북쪽을, 1 동쪽을, 2 남쪽을, 3 서쪽을.
	static final int[] dr = {-1, 0, +1, 0};
	static final int[] dc = {0, +1, 0, -1};

	static int ROW, COL, r, c, d;
	static int turnCount = 0; // 로봇청소기 몇번 돌았는지 적어주는거.
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ROW = sc.nextInt();
		COL = sc.nextInt();
		
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		
		//빈 칸은 0, 벽은 1로 주어진다. " 장소의 모든 외곽은 벽이다."
		//로봇 청소기가 있는 칸의 상태는 항상 빈 칸이다.
		map = new int[ROW][COL];
		for(int i=0; i<ROW; i++) {
			for(int j=0; j<COL; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		setRobot(r, c, d, 0);
		
		solve();
		
		sc.close();
	}
	
	private static void solve() {
		
		// 0 : 청소하지 않은 빈 공간.
		// 1 : 벽.
		// 2 : 청소 한 공간.
		
		while(true) {
			// 네 방향 모두 청소가 되어 있거나, 벽이면 후진 후 2번으로.
			if(turnCount == 4) {
				int backR = r - dr[d];
				int backC = c - dc[d];
				
				//벽이면 종료.
				if(map[backR][backC] == 1) {
					System.out.println(getCleanArea());
					return;
				}else {
				//벽이 아니면 후진.
					setRobot(backR, backC, d, 0);
				}
			}
			
			//1. 현재 위치 청소.
			if(map[r][c] == 0) {
				map[r][c] = 2;
			}
			
			//2. 현재 방향을 기준으로 왼쪽 방향 확인.
			int ld = (d+3) % 4;
			int nr = r+dr[ld];
			int nc = c+dc[ld];
			
			//3. 청소 공간 있음 >> 한칸 전진하고 1번으로.
			//4. 청소 공간 없음 >> 그 방향으로 회전하고, 2번으로.
			if(map[nr][nc] == 0) {
				setRobot(nr, nc, ld, 0);
			}else {
				setRobot(r, c, ld, turnCount+1);
			}
		}
	}

	// 로봇 현재 좌표, 방향, 회전횟수 설정 
	private static void setRobot(int nr, int nc, int nd, int ncount) {
		r = nr;
		c = nc;
		d = nd;
		turnCount = ncount;
	}
	
	private static int getCleanArea() {
		int result = 0;
		for(int i=0; i<ROW; i++) {
			for(int j=0; j<COL; j++) {
				if(map[i][j] == 2) {
					result++;
				}
			}
		}
		return result;
	}
}

