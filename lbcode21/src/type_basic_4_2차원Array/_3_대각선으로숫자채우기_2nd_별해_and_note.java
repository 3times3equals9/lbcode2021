package type_basic_4_2차원Array;

import java.util.Scanner;

public class _3_대각선으로숫자채우기_2nd_별해_and_note {
	
	// 변수 선언:
	static int n, m;
	static int[][] answer = new int[100][100];
	static int count = 1;
		
	static void FillDiagonal(int curr_row, int curr_col) {
	    while(curr_col >= 0 && curr_row < n) {
	        // Case 1:
	        answer[curr_row][curr_col] = count;

	        // 변수 업데이트 :
	        curr_row++;
	        curr_col--;
	        count++;
	    }
	    return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력:
		n = sc.nextInt();
		m = sc.nextInt();
		
		// Step 1:
	    for(int row = 0; row < n; row++) {
	        for(int col = 0; col < m; col++) 
	            // Step 2: 행열 순서대로 탐색하다가, 
	        	// 빈칸(0)이면 시작점으로 잡고,  ↙ 좌측 하단 방향으로 써나가기
	            if(answer[row][col] == 0)
	                FillDiagonal(row, col);
	    }
		
		// 출력:
	    for(int row = 0; row < n; row++) {
	        for(int col = 0; col < m; col++)
	        	System.out.print(answer[row][col] + " ");
        	System.out.println();
	    }
		
		sc.close();
	}
}

/*
Solution2 방법의 시간복잡도는 어떻게 될까요?

// Step 1:
    for(int row = 0; row < n; row++) {
        for(int col = 0; col < m; col++) 
            // Step 2:
            if(answer[row][col] == 0)
                FillDiagonal(row, col);
    }
이중포문 때문에 O(nm)

대각선을 채우는 FillDiagonal 함수는 최대 min(n, m)개까지 적힐 수 있기 때문에 O(min(n, m))

두 코드가 겹쳐 있으므로 이 문제의 시간복잡도를 O(nm * min(n, m))라고 착각하기 쉬운데요,

실제 이 방법의 시간복잡도는 O(nm)입니다.

if(answer[row][col] == 0) 이 코드가 핵심인데요, 비어있지 않을때는 대각선 방향으로 숫자를 적는 작업을 하지 않기 때문에 섣불리 두 시간복잡도의 곱으로 표현된다는 판단을 해서는 안됩니다.

이런 문제의 경우, 코드를 멀리서 바라보면 “비어있는 곳을 찾아 그 위치에 숫자를 정확히 한 번씩만 적어 주는 코드”라 볼 수 있기 때문에 직사각형 크기에 해당하는 만큼만 유효한 코드가 수행되므로 시간복잡도는 O(nm)이 됩니다.
*/







































































