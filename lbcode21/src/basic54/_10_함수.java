package basic54;

/*
import java.util.Scanner;

public class _10_함수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		if(cnt == 1 || cnt == 2) {
			System.out.println(1);
		}else {
			int a = 1;
			int b = 1;
			int ans = 0;
			for(int k=2; k<cnt; k++) {
				ans = a+b;
				a = b;
				b = ans;
			}
			System.out.println(ans);
		}
		sc.close();
	}
}

import java.util.Scanner;
import java.util.LinkedList;

public class _10_함수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		while(input != 0) {
			int mod = input % 10;
			list.add(mod);
			input = input / 10;
		}
		
		int ans = 0;
		boolean isNotZero = false;
		for(int tmp : list) {
			if(!isNotZero && tmp == 0) {
				continue;
			}else if(tmp > 0){
				isNotZero = true;
				ans = (ans*10) + tmp;
			}else if(isNotZero && tmp == 0) {
				ans = (ans*10) + tmp;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
}
import java.util.Scanner;

public class _10_함수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(b > a) {
			int dum = a;
			a = b;
			b = dum;
		}
		
		while(b>0) {
			int tmp = a;
			a = b;
			b = tmp % b;
		}
		
		System.out.println(a);
		sc.close();
	}
}
*/
import java.util.Scanner;

public class _10_함수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 int q = sc.nextInt();
		 int[][] a = new int[q][2];
		 for(int i=0; i<q; i++) {
			 a[i][0] = sc.nextInt();
			 a[i][1] = sc.nextInt();
		 }
		 
		 double min = Double.MAX_VALUE;
		 for(int i=0; i<q; i++) {
			 for(int j=i+1; j<q; j++) {
				 for(int k=j+1; k<q; k++) {
					 double len1 = Math.sqrt((double)((a[i][0] - a[j][0])*(a[i][0] - a[j][0]) + (a[i][1] - a[j][1])*(a[i][1] - a[j][1])));
					 double len2 = Math.sqrt((double)((a[i][0] - a[k][0])*(a[i][0] - a[k][0]) + (a[i][1] - a[k][1])*(a[i][1] - a[k][1])));
					 double len3 = Math.sqrt((double)((a[j][0] - a[k][0])*(a[j][0] - a[k][0]) + (a[j][1] - a[k][1])*(a[j][1] - a[k][1])));
					 
					 double sum = len1 + len2 + len3;
					 if(sum < min) {
						 min = sum;
					 }
				 }
			 }
		 }
		
		System.out.printf("%.2f", min);
		sc.close();
	}
}











