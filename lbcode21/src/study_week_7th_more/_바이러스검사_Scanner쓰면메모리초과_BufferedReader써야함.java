package study_week_7th_more;

import java.util.Scanner;

public class _바이러스검사_Scanner쓰면메모리초과_BufferedReader써야함 {

	static int N, b, c;
	static long ans;
	static int[] arr = new int[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		b = sc.nextInt();
		c = sc.nextInt();
		for (int i = 0; i < N; i++) {
			// 전위연산.
			++ans;
			arr[i] = arr[i] - b;
			if (arr[i] <= 0) {
				continue;
			}
			ans += ((arr[i] % c) == 0 ? (arr[i] / c) : (arr[i] / c) + 1);
		}
		System.out.println(ans);
		sc.close();
	}

}