package type_simulation_5_격자안에서여러객체를이동;

import java.util.Scanner;

public class _1_숫자가가장큰인접한곳으로동시에이동_1st_2차원배열로구슬목록관리하여_시뮬 {
	
	static class Pair{
		public int row;
		public int col;
		
		public Pair() {
			super();
		}

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static final int MAX_N = 20;
	static final int DIR_NUM = 4;
	// 전역 변수 선언:
	static int t, n, m;
	static int[][] a, count, next_count;
	
	// 범위가 격자 안에 들어가는지 확인합니다.
	static boolean InRange(int x, int y) {
	    return 1 <= x && x <= n && 1 <= y && y <= n;
	} 
	// 인접한 곳들 중 가장 값이 큰 위치를 반환합니다.
	static Pair GetMaxNeighborPos(int curr_x, int curr_y) {
	    // 코딩의 간결함을 위해 
	    // 문제 조건에 맞게 상하좌우 순서로
	    // 방향을 정의합니다.
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};

	    int max_num = 0;
	    Pair max_pos = new Pair();
	    
	    // 각각의 방향에 대해 나아갈 수 있는 곳이 있는지 확인합니다.
	    for(int i = 0; i < DIR_NUM; i++) {
	        int next_x = curr_x + dx[i];
	        int next_y = curr_y + dy[i];
	        
	        // 범위안에 들어오는 격자 중 최댓값을 갱신합니다.
	        if(InRange(next_x, next_y) && a[next_x][next_y] > max_num) {
	            max_num = a[next_x][next_y];
	            //max_pos = new Pair(next_x, next_y);
	            max_pos.row = next_x;
	            max_pos.col = next_y;
	        }
	    }
	    
	    return max_pos;
	}
	
	// (x, y) 위치에 있는 구슬을 움직입니다.
	static void Move(int x, int y) {
	    // 인접한 곳들 중 가장 값이 큰 위치를 계산합니다.
		Pair next_pos = GetMaxNeighborPos(x, y);
	    int next_x = next_pos.row, next_y = next_pos.col;
	    
	    // 그 다음 위치에 구슬의 개수를 1만큼 추가해줍니다.
	    next_count[next_x][next_y]++;
	}
	
	// 구슬을 전부 한 번씩 움직여 봅니다.
	static void MoveAll() {
	    // 그 다음 각 위치에서의 구슬 개수를 전부 초기화해놓습니다.
	    for(int i = 1; i <= n; i++)
	        for(int j = 1; j <= n; j++)
	            next_count[i][j] = 0;
	    
	    // (i, j) 위치에 구슬이 있는경우 
	    // 움직임을 시도해보고, 그 결과를 전부 next_count에 기록합니다.
	    for(int i = 1; i <= n; i++)
	        for(int j = 1; j <= n; j++)
	            if(count[i][j] == 1)
	                Move(i, j);
	    
	    // next_count 값을 count에 복사합니다.
	    for(int i = 1; i <= n; i++)
	        for(int j = 1; j <= n; j++)
	            count[i][j] = next_count[i][j];
	}
	
	// 충돌이 일어나는 구슬은 전부 지워줍니다.
	static void RemoveDuplicateMarbles() {
	    // 충돌이 일어난 구슬들이 있는 위치만 빈 곳으로 설정하면 됩니다.
	    for(int i = 1; i <= n; i++)
	        for(int j = 1; j <= n; j++)
	            if(count[i][j] >= 2)
	                count[i][j] = 0;
	}
	
	// 조건에 맞춰 시뮬레이션을 진행합니다.
	static void Simulate() {
	    // Step1
	    // 구슬을 전부 한 번씩 움직여 봅니다.
	    MoveAll();
	    
	    // Step2
	    // 움직임 이후에 충돌이 일어나는 구슬들을 골라 목록에서 지워줍니다.
	    RemoveDuplicateMarbles();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int a[MAX_N + 1][MAX_N + 1];
		//int count[MAX_N + 1][MAX_N + 1];
		//int next_count[MAX_N + 1][MAX_N + 1];
		// 입력:
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		
		a = new int[n+1][n+1];
		count = new int[n+1][n+1];
		next_count = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				a[i][j] = sc.nextInt();
		
		// 초기 count 배열을 설정합니다.
	    // 구슬이 있는 곳에 1을 표시합니다.
	    for(int i = 1; i <= m; i++) {
	        int x = sc.nextInt();
	        int y = sc.nextInt();

	        count[x][y] = 1;
	    }
	    
	    // t초 동안 시뮬레이션을 진행합니다.
	    while(t-- > 0)
	        Simulate();
	    
	    // 출력:
		int ans = 0;
		
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				ans += count[i][j];
		
		System.out.println(ans);
		sc.close();
	}
}









































































