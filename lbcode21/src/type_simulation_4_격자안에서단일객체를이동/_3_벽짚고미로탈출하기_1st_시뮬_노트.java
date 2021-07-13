package type_simulation_4_격자안에서단일객체를이동;

import java.util.Scanner;

public class _3_벽짚고미로탈출하기_1st_시뮬_노트 {
	
	//static final int MAX_N = 100;
	static final int DIR_NUM = 4;
	// 전역 변수 선언:
	static int n;
	static int curr_x, curr_y, curr_dir; // 현재 위치와 방향을 의미합니다.
	static char[][] a;
	
	// 미로 탈출이 불가능한지 여부를 판단하기 위해
	// 동일한 위치에 동일한 방향으로 진행했던 적이 있는지를
	// 표시해주는 배열입니다.
	static boolean[][][] visited;
	static int elapsed_time;
	
	// 범위가 격자 안에 들어가는지 확인합니다.
	static boolean InRange(int x, int y) {
	    return 1 <= x && x <= n && 1 <= y && y <= n;
	}
	
	// 해당 위치에 벽이 있으면 이동이 불가합니다.
	static boolean WallExist(int x, int y) {
	    return InRange(x, y) && a[x][y] == '#';
	}
	
	// 조건에 맞춰 움직여봅니다.
	static void Simulate() {
	    // 현재 위치에 같은 방향으로 진행한 적이 이미 있었는지 확인합니다.
	    // 이미 한 번 겪었던 상황이라면, 탈출이 불가능 하다는 의미이므로 
	    // -1을 출력하고 프로그램을 종료합니다.
	    if(visited[curr_x][curr_y][curr_dir]) {
	        System.out.println("-1");
	        System.exit(0);
	    }
	    // 현재 상황이 다시 반복되는지를 나중에 확인하기 위해
	    // 현재 상황에 해당하는 곳에 visited 값을 true로 설정합니다.
	    visited[curr_x][curr_y][curr_dir] = true;

	    int[] dx = {0, 1, 0, -1};
	    int[] dy = {1, 0, -1, 0};

	    int next_x = curr_x + dx[curr_dir];
	    int next_y = curr_y + dy[curr_dir];

	    // Step1
	    
	    // 바라보고 있는 방향으로 이동하는 것이 불가능한 경우에는
	    // 반 시계 방향으로 90' 방향을 바꿉니다.
	    if(WallExist(next_x, next_y))
	        curr_dir = (curr_dir - 1 + 4) % 4;
	    
	    // Step2
	    
	    // Case1
	    // 바라보고 있는 방향으로 이동하는 것이 가능한 경우 중 : 벽이 없다는거임, 바로 나갈 수 있는경우
	    // 바로 앞이 격자 밖이라면 탈출합니다.
	    else if(!InRange(next_x, next_y)) {
	        curr_x = next_x; curr_y = next_y;
	        elapsed_time++;
	    }

	    // Case2 & Case3
	    // 바로 앞이 격자 안에서 이동할 수 있는 곳이라면 
	    else {
	        // 그 방향으로 이동했다 가정했을 때 바로 오른쪽에 짚을 벽이 있는지 봅니다. : right의 r
	        int rx = next_x + dx[(curr_dir + 1) % 4];
	        int ry = next_y + dy[(curr_dir + 1) % 4];

	        // Case2
	        // 그대로 이동해도 바로 오른쪽에 짚을 벽이 있다면 
	        // 해당 방향으로 한 칸 이동합니다.
	        if(WallExist(rx, ry)) {
	            curr_x = next_x; curr_y = next_y;
	            elapsed_time++;
	        }

	        // Case3
	        // 그렇지 않다면 2칸 이동후 방향을 시계방향으로 90' 방향을 바꿉니다.
	        else {
	            curr_x = rx; curr_y = ry;
	            curr_dir = (curr_dir + 1) % 4;
	            elapsed_time += 2;
	        }
	    }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		curr_x = sc.nextInt();
		curr_y = sc.nextInt();
		
		// 처음에는 우측 방향을 바라보고 시작합니다.
	    curr_dir = 0;
	    
	    elapsed_time = 0;
	    //boolean visited[MAX_N + 1][MAX_N + 1][DIR_NUM];
	    visited = new boolean[n+1][n+1][DIR_NUM];
		//char a[MAX_N + 1][MAX_N + 1];
	    a = new char[n+1][n+1];
	    String tmp;
	    for(int i = 1; i <= n; i++) {
	    	tmp = sc.next();
	        for(int j = 1; j <= n; j++) {
	        	a[i][j] = tmp.charAt(j-1);
	        }
	    }
		
	    do {
	        // 조건에 맞춰 움직여봅니다.
	        Simulate();
	    
	    // 격자를 빠져나오기 전까지 계속 반복합니다.
	    } while(InRange(curr_x, curr_y)); 
	    
	    // 출력:
	    System.out.println(elapsed_time);
		sc.close();
	}
}

/*
1. 반 시계 방향으로 90' 방향을 바꾸는 코드를 다음과 같이 써도 될까요?

curr_dir = (curr_dir - 1) % 4;
언어마다 결과가 다른 경우도 있지만, C++의 경우를 예로 보면 -1 % 4의 결과는 3이 아닌 -1이 나오게 됩니다. 즉, 음수의 경우 나머지 연산이 항상 양수 값을 결과로 갖는다고 확신할 수 없습니다. 따라서 % 연산을 써서 항상 양수값의 나머지를 얻고 싶은 경우에는 꼭 나머지를 구하려는 값을 양수로 만든 뒤 % 연산을 이용해야 합니다.

2. 시뮬레이션 도중 (같은 위치, 같은 방향) 으로 이전에 왔던 적이 있는지를 보지 않고, 아예 시작위치, 시작 방향으로 되돌아오는지를 탈출이 불가능하다는 조건으로 잡으면 안되나요?

됩니다. visited 배열을 이용하여 다시 돌아오는지 체크하는 방식은 일반적으로 Cycle이 발생하는지를 판단하기 위해 쓰이는 방법입니다. 이 문제의 경우 Cycle이 발생하는 경우 항상 시작 위치로 다시 돌아올 수 밖에 없기 때문에 다시 시작 위치로 돌아오는지만 확인해도 충분합니다.

3. 혹시 탈출이 불가능 하다는 조건으로 방향을 제외하고 동일한 위치로 되돌아 오는지만 체크해보는 건 안되나요?

이 문제에서는 그래도 됩니다. 그 이유는 문제의 특성상, 같은 위치로 되돌아오기 위해서는 다음과 같은 모양이어야만 하기 때문입니다.



즉 이 문제에서는 동일한 위치에 다른 방향으로 들어왔다고 하더라도 조금 후에 다시 동일한 위치에 기존과 동일한 방향으로 들어 올 수 밖에 없으므로 탈출이 불가능해집니다.



위치만 동일한지를 고려해도 답은 올바르게 나오게 되지만, 이건 이 문제의 특성 때문이기 때문에 더 확실한 조건을 걸어주는 것이 더 좋습니다.
*/





































































