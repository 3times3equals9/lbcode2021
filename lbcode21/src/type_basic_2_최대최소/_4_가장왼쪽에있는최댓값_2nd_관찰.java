package type_basic_2_최대최소;

import java.util.ArrayList;
import java.util.Scanner;

public class _4_가장왼쪽에있는최댓값_2nd_관찰 {
	
	static final int MAX_N = 1000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n;
		int[] a = new int[MAX_N];
		
		ArrayList<Integer> indices = new ArrayList<>();
		
		n = sc.nextInt();	
		
		for(int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		
	    // 첫 번째 원소는 항상 답이 됩니다.
		indices.add(0);
	    
	    // 바로 직전에 답으로 추가한 원소보다
	    // 현재 원소가 더 큰 경우에만 답으로 추가합니다.
	    for(int i = 1; i < n; i++) {
	    	//마지막원소
	    	int arr_len = indices.size();
	        int last_idx = indices.get(arr_len-1);
	        if(a[i] > a[last_idx])
	            indices.add(i);
	    }
	    
	    for(int i = indices.size() - 1; i >= 0; i--) {
	        int idx = indices.get(i);
	        System.out.print((idx + 1) + " ");
	    }
		
		sc.close();
	}
}









































































