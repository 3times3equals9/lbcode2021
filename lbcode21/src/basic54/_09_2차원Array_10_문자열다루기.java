package basic54;
/*
import java.util.Scanner;

public class _09_2차원Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		
		int m = sc.nextInt();
		
		for(int i=0; i<m; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			arr[r][c] = i+1;
		}
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
import java.util.Scanner;

public class _09_2차원Array {
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

import java.util.Scanner;

public class _09_2차원Array_10_문자열다루기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		int[][] copy = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				copy[r][c] = arr[N-c-1][r];
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				System.out.print(copy[r][c] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
import java.util.Scanner;

public class _09_2차원Array_10_문자열다루기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		int[][] copy = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				copy[r][c] = arr[N-c-1][r];
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				System.out.print(copy[r][c] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
import java.util.Scanner;

public class _09_2차원Array_10_문자열다루기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tmp = sc.next();
		int LEN = tmp.length();
		for(int i = 0; i<LEN; i++) {
			System.out.println(tmp.charAt(i));
		}
		sc.close();
	}
}
import java.util.Scanner;

public class _09_2차원Array_10_문자열다루기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		String[] arr = tmp.split(" ");
		int LEN = arr.length;
		for(int i = 0; i<LEN; i++) {
			System.out.println(arr[i]);
		}
		sc.close();
	}
}
import java.util.Scanner;

public class _09_2차원Array_10_문자열다루기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		String pcs = sc.nextLine();
		int k = tmp.indexOf(pcs);
		System.out.println(k);
		sc.close();
	}
}
import java.util.Scanner;

public class _09_2차원Array_10_문자열다루기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int q = sc.nextInt();
		
		for(int i=0; i<q; i++) {
			int type = sc.nextInt();
			if(type == 1) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				char[] arr = s.toCharArray();
				arr[a] = s.charAt(b);
				arr[b] = s.charAt(a);
				System.out.println(arr);
			}else if(type == 2) {
				char c = sc.next().charAt(0);
				char d = sc.next().charAt(0);
				
				char[] tmp = new char[s.length()];
				s.getChars(0, s.length(), tmp, 0);
				for(int k=0; k<tmp.length; k++) {
					if (tmp[k] == c) {
						tmp[k] = d;
					}
				}
				System.out.println(tmp);
			}
		}
		
		sc.close();
	}
}

import java.util.Scanner;

public class _09_2차원Array_10_문자열다루기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int q = sc.nextInt();
		
		StringBuilder br = new StringBuilder(s);
		
		for(int i=0; i<q; i++) {
			int type = sc.nextInt();
			if(type == 1) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				char aa = s.charAt(a);
				char bb = s.charAt(b);
				br.setCharAt(a, bb);
				br.setCharAt(b, aa);
				s = br.toString();
				System.out.println(s);
			}else if(type == 2) {
				char c = sc.next().charAt(0);
				System.out.println(" c : " + c);
				System.out.println(" 'c' : " + 'c');
				System.out.println("c  : " + c);
				char d = sc.next().charAt(0);
				System.out.println("d  : " + d);
				System.out.println("바뀌기전 : " + s);
				//s.replaceAll(c+"", d+"");
				String tmp = s.replace('a', 'c');
				s = tmp;
				System.out.println(s);
			}
		}
		sc.close();
	}
	
}
import java.util.Scanner;

public class _09_2차원Array_10_문자열다루기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int q = sc.nextInt();
		
		for(int i=0; i<q; i++) {
			int type = sc.nextInt();
			if(type == 1) {
				StringBuilder br = new StringBuilder(s);
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				char aa = s.charAt(a);
				char bb = s.charAt(b);
				br.setCharAt(a, bb);
				br.setCharAt(b, aa);
				s = br.toString();
				System.out.println(s);
			}else if(type == 2) {
				char c = sc.next().charAt(0);
				char d = sc.next().charAt(0);
				String tmp = s.replace(c, d);
				s = tmp;
				System.out.println(s);
			}
		}
		sc.close();
	}
	
}
*/
import java.util.Scanner;

public class _09_2차원Array_10_문자열다루기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char[] ca  = str.toCharArray();
		int len = str.length();
		
		int q = sc.nextInt();
		int[] arr = new int[q];
		for(int i=0; i<q; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<q; i++) {
			if(arr[i] == 1) {
				char tmp = ca[0];
				for(int k=1; k<len; k++) {
					ca[k-1] = ca[k];
				}
				ca[len-1] = tmp;
				
				String prt  = new String(ca);
				System.out.println(prt);
			}else if(arr[i] == 2) {
				char tmp = ca[len-1];
				for(int k=len-1-1; k>=0; k--) {
					ca[k+1] = ca[k];
				}
				ca[0] = tmp;
				
				String prt  = new String(ca);
				System.out.println(prt);
			}else if( arr[i] == 3) {
				for(int k=0; k<(len/2); k++) {
					char tmp = ca[k];
					ca[k] = ca[len-1-k];
					ca[len-1-k] = tmp;
				}
				
				String prt  = new String(ca);
				System.out.println(prt);
			}
		}
	
		sc.close();
	}
	
}







	













