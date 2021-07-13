package type_backtracking_1_K개중하나를N번선택하기_Simple;

import java.util.Scanner;

public class _7_알파벳과사칙연산_chk {
	
	//static int n;
	static int max = Integer.MIN_VALUE;
	static int[] nums;
	//static boolean[] visited;
	static char[] car;
	static int car_len;
	static void dfs(int idx) {
		if(idx == 6) {
			int res = nums[car[0] - 'a'];
			for(int i=2; i<car_len; i=i+2) {
				char oper = car[i-1];
				int number = nums[car[i] - 'a'];
				
				if(oper == '+') {
					res = res + number;
				}else if(oper == '-') {
					res = res - number;
				}else if(oper == '*') {
					res = res * number;
				}
			}
			
			max = Math.max(res, max);
			return;
		}
		
		for(int k=1; k<=4; k++) {
			nums[idx] = k;
			//visited[idx] = true;
			dfs(idx+1);
			//visited[idx] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input_str = sc.next();
		car = input_str.toCharArray();
		car_len = input_str.length();
		
		nums = new int[6];
		//visited = new boolean[6];
		
		for(int k=1; k<=4; k++) {
			nums[0] = k;
			dfs(1);
		}
		
		System.out.println(max);
		sc.close();
	}
}









































































