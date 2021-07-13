package type_basic_4_2차원Array;

import java.util.Scanner;

public class _4_빙빙돌며사각형채우기_1st_시뮬레이션_main_note {
	
	// 전역 변수 선언:
	// 이미 방문한적이 있다면 true / 아니라면 false로 표시합니다.
	static boolean[][] visited = new boolean[100][100];
	
	static boolean CanGo(int n, int m, int new_x, int new_y){
	    // 나아가려는 위치가 직사각형 안에 들어 있는지 확인하고
	    // 들어있다면 아직 방문한적이 없는 곳인지 판단합니다.
	    if(0 <= new_x && new_x < n && 
	            0 <= new_y && new_y < m && 
	            visited[new_x][new_y] == false) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 변수 선언:
	    int n, m;
	    char[][] answer = new char[100][100]; // 답에 해당하는 알파벳을 적을 배열입니다.
		
	    // 입력:
	    n = sc.nextInt();
	    m = sc.nextInt();
	    
	    // direction에 따라 바뀌는 (x, y)의 변화량인 dx, dy를 정의합니다.
	    int[] dx = {0, 1, 0, -1};
	    int[] dy = {1, 0, -1, 0};
	    int curr_x = 0, curr_y = 0; // 시작은 (0, 0) 입니다.
	    int direction = 0; //0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
	    
	    // 처음 시작 위치에 초기값을 적습니다.
	    answer[curr_x][curr_y] = 'A';  
	    visited[curr_x][curr_y] = true;
	    
	    // n*m개의 알파벳을 적어야 합니다. 
	    for(int i = 1; i < n * m; i++) { // i번째 문자를 어디에 적을지 결정합니다.
	        while(true) { // 나아갈 수 있을때까지 방향을 바꿔가며 확인해봅니다. 
	            // 현재 방향 dir를 기준으로 그 다음 위치 값을 계산합니다.
	            int next_x = curr_x + dx[direction];
	            int next_y = curr_y + dy[direction];
				// 그 위치로 나아갈 수 있는지 확인합니다.
	            if(CanGo(n, m, next_x, next_y)) {
	                // 나아갈 수 있다면 위치를 갱신해주고 배열에 올바른 값을 채워넣습니다.
	                curr_x = next_x; 
	                curr_y = next_y;
	                visited[curr_x][curr_y] = true;
	                answer[curr_x][curr_y] = (char)(i % 26 + 'A');
	                break;
	            } else {
	                // 나아갈 수 없다면 시계방향으로 90'를 회전하여 
					// 그 다음 방향을 확인해봐야 합니다.
	                direction = (direction + 1) % 4;
	            }
	        }
	    }
	    
	    // 출력:
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < m; j++) 
	        	System.out.print(answer[i][j] + " ");
        	System.out.println();
	    }
	    
		sc.close();
	}
}

/*
Solution 1에서 canGo 함수를 아래와 같이 바꾸면 어떤 문제가 생길까요?
>> ' visited[next_x][next_y] == false ' 가 맨 앞으로 튀어나온거임 
>> "배열의 크기가 고정되어 있는 경우 해당 인덱스가 배열의 범위에 포함되는지를 먼저 확인해준 뒤 해당 배열을 접근해야만 합니다."
>> 배열 크기 미리 이빠이 크게 잡는 C++ 언어 한정인듯

bool canGo(int n, int m, int next_x, int next_y){
    if(visited[next_x][next_y] == false \
            0 <= next_x && next_x < n && \
            0 <= next_y && next_y < m}
        return true;
    }
    else {
        return false;
    }
}
next_x가 주어진 범위를 벗어난 경우 (next_x < 0 이거나, next_x > n), 혹은 next_y가 범위를 벗어난 경우 (next_y < 0 이거나, next_y > m) 에 대하여 visited[next_x][next_y]를 접근할 때 에러가 발생하거나 원하지 않는 결과를 얻게될 수 있습니다.

if (cond1 && cond2 && cond3 … && condN) 과 같이 여러개의 조건이 있는 경우, 앞에서부터 순차적으로 각각의 조건을 검사하다가 false인 경우 나머지 조건은 확인하지 않고 해당 if 문을 빠져나옵니다. 예를 들어 cond3 = false인 경우 해당 if문은 cond1~3만 검사를 하고 나머지(cond4 ~ N)은 확인을 하지 않고 빠져나옵니다.

따라서 위와 같이 배열의 크기가 고정되어 있는 경우 해당 인덱스가 배열의 범위에 포함되는지를 먼저 확인해준 뒤 해당 배열을 접근해야만 합니다.
*/





































































