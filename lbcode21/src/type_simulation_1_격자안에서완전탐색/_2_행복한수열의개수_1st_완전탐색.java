package type_simulation_1_격자안에서완전탐색;

import java.util.Scanner;

public class _2_행복한수열의개수_1st_완전탐색 {
	
	static int n, m;
	static int[][] grid;
	static int[] seq;
	
	static boolean IsHappySequence(){
	    // 주어진 seq가 행복한 수열인지 판단하는 함수입니다.
	    int consecutive_count = 1, max_ccnt = 1;
	    for(int i = 1; i < n; i++) {
	        if (seq[i - 1] == seq[i])
	            consecutive_count++;
	        else
	            consecutive_count = 1;
	        
	        max_ccnt = Math.max(max_ccnt, consecutive_count);
	    }
	    
	    // 최대로 연속한 회수가 m이상이면 true를 반환합니다. 
	    return max_ccnt >= m;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		grid = new int[n][n];
		seq = new int[n];
		m = sc.nextInt();
		
		for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            grid[i][j] = sc.nextInt();

	    int num_happy = 0;
		
	    // 먼저 가로로 행복한 수열의 수를 셉니다.
	    for(int i = 0; i < n; i++) {
	    	//seq = new int[n];
	        for(int j = 0; j < n; j++) {
	            seq[j] = grid[i][j];
	        }
	        if(IsHappySequence())
	            num_happy++;
	    }
	    
	    // 세로로 행복한 수열의 수를 셉니다.
	    for(int j = 0; j < n; j++){
	    	//seq = new int[n];
	        // 세로로 숫자들을 모아 새로운 수열을 만듭니다.
	        for(int i = 0; i < n; i++) {
	            seq[i] = grid[i][j];
	        }
	        if(IsHappySequence())
	            num_happy++;
	    }
	    
	    System.out.println(num_happy);
		sc.close();
	}
}









































































