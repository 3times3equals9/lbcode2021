package type_basic_4_2차원Array;

import java.util.Scanner;

public class _3_대각선으로숫자채우기_1st_시뮬레이션_main {
	
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
		
		// Step 1: 맨 윗 가로줄, 0번째 행
	    for(int start_col = 0; start_col < m; start_col++) {
	        FillDiagonal(0, start_col);
	    }
	    
	    // Step 2: 맨 오른쪽 세로줄, m-1번째 열
	    for(int start_row = 1; start_row < n; start_row++) {
	        FillDiagonal(start_row, m - 1);
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









































































