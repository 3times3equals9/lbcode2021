package type_simulation_5_격자안에서여러객체를이동;

import java.util.ArrayList;
import java.util.Scanner;

public class _3_벽이있는충돌실험_1st_1차원배열구슬목록관리_시뮬_시간초과_고치기전_중간에_Move를안했네 {
	
	static final int MAX_N = 50;
	static final int DIR_NUM = 4;
	static final int ASCII_NUM = 128;
	
	static class Marble{
		public int row;
		public int col;
		public int dir;
		
		public Marble() {
			super();
		}
		
		public Marble(Marble m) {
			super();
			this.row = m.row;
			this.col = m.col;
			this.dir = m.dir;
		}

		public Marble(int row, int col, int dir) {
			super();
			this.row = row;
			this.col = col;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Marble [row=" + row + ", col=" + col + ", dir=" + dir + "]";
		}
	}
	
	// 전역 변수 선언:
	static int t, n, m;
	static int[] mapper = new int[ASCII_NUM];
	
	// 후에 구슬이 벽에 부딪혔을 때의 처리를 간단히 하기 위해
	// dir 기준 0, 3이 대칭 1, 2가 대칭이 되도록 설정합니다.
	static final int[] dx = {-1, 0, 0, 1};
	static final int[] dy = {0, 1, -1, 0};

	//vector<Marble> marbles;
	static ArrayList<Marble> marbles;
	
	// 해당 위치가 격자 안에 들어와 있는지 확인합니다.
	static boolean InRange(int x, int y) {
	    return 1 <= x && x <= n && 1 <= y && y <= n;
	}
	
	// 해당 구슬이 1초 후에 어떤 위치에서 어떤 방향을 보고 있는지를 구해
	// 그 상태를 반환합니다.
	static Marble Move(Marble marble) {
	    // tuple의 경우 다음과 같이 원하는 변수에 값을 뽑아줄 수 있습니다.
	    int x, y, dir;
	    //tie(x, y, dir) = marble;
	    x = marble.row;
	    y = marble.col;
	    dir = marble.dir;
	    
	    // 바로 앞에 벽이 있는지 판단합니다.
	    int nx = x + dx[dir], ny = y + dy[dir];
	    
	    Marble res = new Marble();
	    // Case 1 : 벽이 없는 경우에는 그대로 한 칸 전진합니다.
	    if(InRange(nx, ny)) {
	        //return new Marble(nx, ny, dir);
	    	res.row = nx;
	    	res.col = ny;
	    	res.dir = dir;
	    }
	    // Case 2 : 벽이 있는 경우에는 방향을 반대로 틀어줍니다.
	    // 처음에 dx, dy를 dir 기준 0, 3이 대칭 1, 2가 대칭이 되도록
	    // 설정해놨기 때문에 간단하게 처리가 가능합니다.
	    else {
	        //return new Marble(x, y, 3 - dir);
	    	res.row = x;
	    	res.col = y;
	    	res.dir = 3 - dir;
	    }
	    
	    return res;
	}
	
	// 구슬을 전부 한 번씩 움직여 봅니다.
	static void MoveAll() {
	    for(int i = 0; i < marbles.size(); i++) {
	        //marbles[i] = Move(marbles[i]);
	    	Marble tmp_marble = new Marble(marbles.get(i));
	        marbles.get(i).row = tmp_marble.row;
	        marbles.get(i).col = tmp_marble.col;
	        marbles.get(i).dir = tmp_marble.dir;
	    }
	}
	
	// 해당 구슬과 충돌이 일어나는 구슬이 있는지 확인합니다.
	// 자신을 제외한 구슬 중에 위치가 동일한 구슬이 있는지 확인하면 됩니다.
	static boolean DuplicateMarbleExist(int target_idx) {
	    int target_x, target_y;
	    //tie(target_x, target_y, ignore) = marbles[target_idx];
	    target_x = marbles.get(target_idx).row;
	    target_y = marbles.get(target_idx).col;
	    
	    for(int i = 0; i < (int) marbles.size(); i++) {
	        if(i == target_idx)
	            continue;
	        
	        int mx, my;
	        //tie(mx, my, ignore) = marbles[i];
	        mx = marbles.get(i).row;
	        my = marbles.get(i).col;
	        
	        if(target_x == mx && target_y == my)
	            return true;
	    }

	    return false;
	}
	
	// 충돌이 일어나는 구슬은 전부 지워줍니다.
	static void RemoveDuplicateMarbles() {
	    ArrayList<Marble> temp_vector = new ArrayList<>();

	    for(int i = 0; i < marbles.size(); i++)
	        if(!DuplicateMarbleExist(i))
	            temp_vector.add(new Marble(marbles.get(i)));
	    
	    marbles = temp_vector;
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
	    mapper['U'] = 0;
	    mapper['R'] = 1;
	    mapper['L'] = 2;
	    mapper['D'] = 3;
		
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 수 입력:
		t = sc.nextInt();
		
		while(t-- > 0) {
	        // 새로운 테스트 케이스가 시작될때마다 기존에 사용하던 값들을 초기화해줍니다.
	        marbles = new ArrayList<>();

	        // 입력:
	        n = sc.nextInt();
	        m = sc.nextInt();
	        for(int i = 1; i <= m; i++) {
	            int x = sc.nextInt();
	            int y = sc.nextInt();
	            char d = sc.next().charAt(0);
	            marbles.add(new Marble(x, y, mapper[d]));
	        }

	        // 2*n번 이후에는 충돌이 절대 일어날 수 없으므로
	        // 시뮬레이션을 총 2*n번 진행합니다.
	        for(int i = 1; i <= 2 * n; i++) {
	            Simulate();
	        }
	        // 출력:
	        System.out.println(marbles.size());
	        for(int i = 0; i < marbles.size(); i++) {
	        	System.out.println(marbles.get(i).toString());
	        }
	        
	    }
		
		sc.close();
	}
}

/*
각 구슬의 위치와 방향을 하나의 원소로 갖는 1차원 배열을 이용하여 아직 남아있는 구슬의 목록을 관리합니다. 
구슬이 벽에 부딪혔을 때 방향을 쉽게 바꿀 수 있도록, dx, dy 값을 정의할 때 
dir 기준 0, 3이 대칭 1, 2가 대칭이 되도록 설정하여 
항상 3에서 현재 dir를 빼면 대칭인 방향이 나오게끔 합니다. 
구슬끼리 충돌이 일어나는 경우는 위치가 겹치는 구슬이 있는지를 직접 순회하여 판단 가능합니다. 
또한, 새로운 테스트 케이스가 시작될 때마다 기존에 사용하던 변수들을 꼭 초기화해줘야 하는 경우도 있음에 유의하도록 합니다.
*/





































































