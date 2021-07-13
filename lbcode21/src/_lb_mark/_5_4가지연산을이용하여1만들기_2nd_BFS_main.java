package _lb_mark;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _5_4가지연산을이용하여1만들기_2nd_BFS_main {
	
	static final int OPERATOR_NUM = 4;
	static final int MAX_N = 1000000;
	
	static final int SUBTRACT = 0;
	static final int ADD = 1;
	static final int DIV2 = 2;
	static final int DIV3 = 3;
	
	// 전역 변수 선언:
	static int n;
	
	// bfs에 필요한 변수들 입니다.
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;
	static int[] step; 
	// step[i] : 정점 n에서 시작하여 
	// 정점 i 지점에 도달하기 위한 
	// 최단거리를 기록합니다.
	static int ans;
	
	// num이라는 값에 해당 operator를
	// 사용할 수 있는지를 판단합니다.
	// 2로 나누거나 3으로 나누려는 경우
	// num이 해당 값으로 나누어 떨어질 때에만
	// 해당 연산을 사용 가능합니다.
	static boolean Possible(int num, int op) {
	    if(op == SUBTRACT || op == ADD)
	        return true;
	    else if(op == DIV2)
	        return num % 2 == 0;
	    else
	        return num % 3 == 0;
	}
	
	// num에 op 연산을 수행했을 때의
	// 결과를 반환합니다.
	static int Calculate(int num, int op) {
	    if(op == SUBTRACT)
	        return num - 1;
	    else if(op == ADD)
	        return num + 1;
	    else if(op == DIV2)
	        return num / 2;
	    else
	        return num / 3;
	}

	// 1에서 2n - 1 사이의 숫자만 이용해도
	// 올바른 답을 구할 수 있으므로 
	// 그 범위 안에 들어오는 숫자인지를 확인합니다.
	static boolean InRange(int num) {
	    return 1 <= num && num <= 2 * n - 1;
	}
	
	// 1에서 2n - 1 사이의 숫자이면서
	// 아직 방문한 적이 없다면 가야만 합니다. 
	static boolean CanGo(int num) {
	    return InRange(num) && !visited[num];
	}
	
	// queue에 새로운 위치를 추가하고
	// 방문 여부를 표시해줍니다.
	// 시작점으로 부터의 최단거리 값도 갱신해줍니다.
	static void Push(int num, int new_step) {
	    q.offer(num);
	    visited[num] = true;
	    step[num] = new_step;
	}

	// BFS를 통해 최소 연산 횟수를 구합니다.
	static void FindMin() {
	    // queue에 남은 것이 없을때까지 반복합니다.
	    while(!q.isEmpty()) {
	        // queue에서 가장 먼저 들어온 원소를 뺍니다.
	        int curr_num = q.peek();
	        q.poll();

	        // queue에서 뺀 원소의 위치를 기준으로 4가지 연산들을 적용해봅니다.
	        for(int i = 0; i < OPERATOR_NUM; i++) {
	            // 연산을 적용할 수 없는 경우라면 패스합니다.
	            if(!Possible(curr_num, i))
	                continue;
	            
	            int new_num = Calculate(curr_num, i);
	            // 아직 방문한 적이 없으면서 갈 수 있는 곳이라면
	            // 새로 queue에 넣어줍니다.
	            if(CanGo(new_num))
	                // 최단 거리는 이전 최단거리에 1이 증가하게 됩니다. 
	                Push(new_num, step[curr_num] + 1);
	        }
	    }

	    // 1번 정점까지 가는 데 필요한 최소 연산 횟수를
	    // 답으로 기록합니다.
	    ans = step[1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		bool visited[MAX_N * 2];
//		int step[MAX_N * 2]; 
		// 입력:
		n = sc.nextInt();
		visited = new boolean[n*2];
		step = new int[n*2];
		
		ans = 0;
		// BFS를 통해 최소 연산 횟수를 구합니다.
	    Push(n, 0);
	    FindMin();
	    
	    // 출력:
		System.out.println(ans);
		sc.close();
	}
}









































































