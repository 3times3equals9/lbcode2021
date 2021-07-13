package type_simulation_2_격자안에서밀고당기기;

import java.util.Scanner;

public class _2_삼각형컨베이어벨트_1st_시뮬레이션_순서바꿔서 {
	
	// 전역 변수 선언:
	static int n, t;
	static int[] l, r, d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		t = sc.nextInt();
		
		l = new int[n];
		r = new int[n];
		d = new int[n];
		
		for(int i = 0; i < n; i++)
	        l[i] = sc.nextInt();
	    
		for(int i = 0; i < n; i++)
	        r[i] = sc.nextInt();
		
	    for(int i = 0; i < n; i++)
	        d[i] = sc.nextInt();
		
	    while(t-- > 0) {
	    	// Step 1
	        // 왼쪽에서 가장 오른쪽에 있는 숫자를 따로 temp값에 저장해놓습니다.
	        int temp = l[n - 1];
	        
	        // Step 2
	        // 왼쪽에 있는 숫자들을 완성합니다. 
	        // 벨트를 기준으로 오른쪽에서부터 채워넣어야 하며, 
	        // 맨 왼쪽 숫자는 아래에서 가져와야함에 유의합니다.
	        for(int i = n - 1; i >= 1; i--)
				l[i] = l[i - 1];
			l[0] = d[n - 1];
	        
	        // Step 3
	        for(int i = n - 1; i >= 1; i--)
				d[i] = d[i - 1];
	        d[0] = r[n - 1];
	        
	        // Step 4
	        for(int i = n - 1; i >= 1; i--)
				r[i] = r[i - 1];
			r[0] = temp;
	    }
		
	    // 출력:
	    for(int i = 0; i < n; i++)
	    	System.out.print(l[i] + " ");
	    System.out.println();
	    
	    for(int i = 0; i < n; i++)
	    	System.out.print(r[i] + " ");
	    System.out.println();
	    
		for(int i = 0; i < n; i++)
			System.out.print(d[i] + " ");
		
		sc.close();
	}
}









































































