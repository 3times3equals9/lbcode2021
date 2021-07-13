package type_basic_4_2차원Array;

import java.util.Scanner;

public class _1_지그재그로숫자채우기_1st_시뮬레이션_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 변수 선언:
	    int n, m;
	    int[][] answer = new int[100][100];

	    // 입력:
	    n = sc.nextInt();
	    m = sc.nextInt();
	    
	    // Step 1:
	    int count = 0;
	    for(int col = 0; col < m; col++) {
	        if (col % 2 == 0){
	            // Case 1:
	            for(int row = 0; row < n; row++){
	                answer[row][col] = count;
	                count++;
	            }
	        }
	        else {
	            // Case 2:
	            for(int row = n - 1; row >= 0; row--){
	                answer[row][col] = count;
	                count++;
	            }
	        }
	    }
	    
	    // 출력:
	    for(int row = 0; row < n; row++) {
	        for(int col = 0; col < m; col++) 
	        	System.out.print(answer[row][col] +  " ");
	        System.out.println();
	    }
		
		sc.close();
	}
}

/*
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		
		int k = 0;
		for(int c=0; c<m; c++) {
			if(c%2 == 0) {
				for(int r=0; r<n; r++) {
					arr[r][c] = k;
					k++;
				}
			}else{
				for(int r=n-1; r>=0; r--) {
					arr[r][c] = k;
					k++;
				}
			}
		}
		
		for(int r = 0; r<n; r++) {
			for(int c=0; c<m; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
*/









































































