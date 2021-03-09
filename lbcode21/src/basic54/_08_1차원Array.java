package basic54;
/*
import java.util.Scanner;

public class _08_1차원Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int k=0; k<10; k++) {
			sum += sc.nextInt();
		}
		System.out.println(sum);
		sc.close();
	}
}

import java.util.Scanner;

public class _08_1차원Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int k=0; k<n; k++) {
			arr[k] = sc.nextInt();
		}
		for(int k=0; k<n; k++) {
			System.out.print(arr[k]*arr[k] + " ");
		}
		sc.close();
	}
}

import java.util.Scanner;

public class _08_1차원Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int k=0; k<n; k++) {
			arr[k] = sc.nextInt();
		}
		for(int k=0; k<n; k++) {
			if(arr[k] % 2 == 0) {
				System.out.print(arr[k] + " ");
			}
		}
		sc.close();
	}
}
import java.util.Scanner;

public class _08_1차원Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[10];
		for(int i=0; i<n; i++) {
			arr[sc.nextInt()]++;
		}
		for(int i=1; i<=9; i++) {
			System.out.println(arr[i]);
		}
		sc.close();
	}
}

import java.util.Scanner;

public class _08_1차원Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int q = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[][] query = new int[q][3];
		for(int i=0; i<q; i++) {
			int th = sc.nextInt();
			query[i][0] = th;
			if(th == 1) {
				query[i][1] = sc.nextInt();
			}else if(th == 2){
				query[i][1] = sc.nextInt();
			}else if(th == 3){
				query[i][1] = sc.nextInt();
				query[i][2] = sc.nextInt();
			}
		}
		
		for(int i=0; i<q; i++) {
			if(query[i][0] == 1) {
				System.out.println(arr[query[i][1]-1]);
			} else if(query[i][0] == 2) {
				int index = 0;
				for(int k=0; k<n; k++) {
					if(arr[k] == query[i][1]) {
						index = k+1;
						break;
					}
				}
				System.out.println(index);
			} else if(query[i][0] == 3) {
				for(int k = query[i][1]-1; k<=query[i][2]-1; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
		
		sc.close();
	}
}

import java.util.Scanner;

public class _08_1차원Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int[] arr = new int[n];
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] < min) {
				min = arr[i];
				cnt = 1;
			}else if(arr[i] == min) {
				cnt++;
			}
		}
		
		System.out.println(min + " " + cnt);
		sc.close();
	}
}

import java.util.Scanner;

public class _08_1차원Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		int sub = Integer.MIN_VALUE;
		int maxidx = -1;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(max <= arr[i]) {
				max = arr[i];
				maxidx = i;
			}
		}
		arr[maxidx] = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			if(sub <= arr[i]) {
				sub = arr[i];
			}
		}
		System.out.println(max + " " + sub);
		sc.close();
	}
}
*/
import java.util.Scanner;

public class _08_1차원Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		int dist = n1-n2;
		boolean chk = false;
		
		if(dist >= 0) {
			int[] arr1 = new int[n1];
			int[] arr2 = new int[n2];
			for(int i=0; i<n1; i++) {
				arr1[i] = sc.nextInt();
			}
			for(int i=0; i<n2; i++) {
				arr2[i] = sc.nextInt();
			}
			for(int d=0; d<=dist; d++) {
				chk = true;
				for(int k=0; k<n2; k++) {
					if(arr2[k] != arr1[k+d]) {
						chk = false;
						break;
					}
				}
				if(chk) {
					break;
				}
			}
		}
		System.out.println(chk ? "Yes" : "No");
		sc.close();
	}
}




















