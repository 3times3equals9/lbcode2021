package type_simulation_2_격자안에서밀고당기기;

import java.util.Scanner;

public class _3_1차원바람_1st_simulation {
	
	static final int SHIFT_RIGHT = 0;
	static final int SHIFT_LEFT = 1;
	
	static int n, m, q;
	static int[][] a;
	
	// row 줄의 원소들을 dir 방향에 따라 한 칸 밀어줍니다.
	// dir이 0인 경우 오른쪽으로
	// dir이 1인 경우 왼쪽으로 밀어야 합니다.
	static void Shift(int row, int dir) {
	    // 오른쪽으로 밀어야 하는 경우
	    if(dir == SHIFT_RIGHT) {
	        int temp = a[row][m];
	        for(int col = m; col >= 2; col--)
	            a[row][col] = a[row][col - 1];
	        a[row][1] = temp;
	    }
	    // 왼쪽으로 밀어야 하는 경우
	    else {
	        int temp = a[row][1];
	        for(int col = 1; col <= m - 1; col++)
	            a[row][col] = a[row][col + 1];
	        a[row][m] = temp;
	    }
	}
	
	// row1, row2 행에 대해 같은 열에 같은 숫자를 갖는 경우가
	// 있는지를 찾아줍니다.
	static boolean HasSameNumber(int row1, int row2) {
	    for(int col = 1; col <= m; col++)
	        if(a[row1][col] == a[row2][col])
	            return true;
	    
	    return false;
	}
	
	// 주어진 방향으로부터 반대 방향의 값을 반환합니다.
	static int Flip(int dir) {
	    return (dir == SHIFT_LEFT) ? SHIFT_RIGHT : SHIFT_LEFT;
	}
	
	// 조건에 맞춰 움직여봅니다.
	// dir이 SHIFT_RIGHT 인 경우 오른쪽으로
	// dir이 SHIFT_LEFT 인 경우 왼쪽으로 밀어야 합니다.
	static void Simulate(int start_row, int start_dir) {
	    // Step1
	    // 바람이 처음으로 불어 온 행의 숫자들을 해당 방향으로 밀어줍니다.
	    Shift(start_row, start_dir);

	    // 그 이후부터는 반전된 방향에 영향을 받으므로, 방향을 미리 반전 시켜줍니다.
	    start_dir = Flip(start_dir);

	    // Step2
	    // 위 방향으로 전파를 계속 시도해봅니다.
	    for(int row = start_row, dir = start_dir; row >= 2; row--) {
	        // 인접한 행끼리 같은 숫자를 가지고 있다면
	        // 위의 행을 한 칸 shift하고
	        // 방향을 반대로 바꿔 계속 전파를 진행합니다.
	        if(HasSameNumber(row, row - 1)) {
	            Shift(row - 1, dir);
	            dir = Flip(dir);
	        }
	        // 같은 숫자가 없다면 전파를 멈춥니다.
	        else
	            break;
	    }

	    // Step3
	    // 아래 방향으로 전파를 계속 시도해봅니다.
	    for(int row = start_row, dir = start_dir; row <= n - 1; row++) {
	        // 인접한 행끼리 같은 숫자를 가지고 있다면
	        // 아래 행을 한 칸 shift하고
	        // 방향을 반대로 바꿔 계속 전파를 진행합니다.
	        if(HasSameNumber(row, row + 1)) {
	            Shift(row + 1, dir);
	            dir = Flip(dir);
	        }
	        // 같은 숫자가 없다면 전파를 멈춥니다.
	        else
	            break;
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n+1][m+1];
		
		q = sc.nextInt();
		
		for(int row = 1; row <= n; row++)
	        for(int col = 1; col <= m; col++)
	            a[row][col] = sc.nextInt();
		
		while(q-- > 0) {
	        int r; 
	        char d;
	        
	        r = sc.nextInt();
	        d = sc.next().charAt(0);

	        // 조건에 맞춰 움직여봅니다.
	        Simulate(r, d == 'L' ? SHIFT_RIGHT : SHIFT_LEFT);
	    }
		
		// 출력:
	    for(int row = 1; row <= n; row++) {
	        for(int col = 1; col <= m; col++)
	        	System.out.print(a[row][col] + " ");
	        System.out.println();
	    }
		sc.close();
	}
}









































































