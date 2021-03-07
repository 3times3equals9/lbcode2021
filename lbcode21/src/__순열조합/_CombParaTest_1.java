package __순열조합;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _CombParaTest_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int R = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solution(arr, N, R));
		
		sc.close();
	}

	public static int solution(int[] nums, int n, int r) {

//		int n = nums.length;
//		int r = 3;
		ArrayList<int[]> combList = new ArrayList<>();
		int[] selected = new int[r];

		int limit = calculateComb(n, r);
		combination(n, r, selected, 0, nums, 0, combList, limit);

		int answer = 0;
		for (int i = 0; i < combList.size(); i++) {
			int sum = sumArray(combList.get(i));
			if (isPrime(sum)) {
				answer++;
			}
		}

		return answer;
	}

	public static ArrayList<int[]> combination(int n, int r, int[] selected, int index, int[] input, int target,
			ArrayList<int[]> combList, int limit) {
		if (combList.size() == limit) {
			System.out.println("최종으로 원하는 return combList;");
			for(int i=0; i<combList.size(); i++) {
				System.out.print(Arrays.toString(combList.get(i)) + "/");
			}
			System.out.println();
			return combList;
		}

		if (r == 0) {
			combList.add(selected.clone());
			// do nothing;
		} else if (target == n) {
			// do nothing;
		} else {
			selected[index] = input[target];
			combination(n, r - 1, selected, index + 1, input, target + 1, combList, limit);
			combination(n, r, selected, index, input, target + 1, combList, limit);
		}
		
		System.out.println("맨마지막 return combList;");
		for(int i=0; i<combList.size(); i++) {
			System.out.print(Arrays.toString(combList.get(i)) + "/");
		}
		System.out.println();
		return combList;
	}

	public static boolean isPrime(int num) {
		for (int k = 2; k <= Math.sqrt(num); k++) {
			if (num % k == 0) {
				return false;
			}
		}
		return true;
	}

	public static int sumArray(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	public static int calculateComb(int n, int r) {
		// 분자.
		int numerator = 1;
		for (int k = 1; k <= r; k++) {
			numerator *= n;
			n--;
		}
		// 분모.
		int denominator = 1;
		for (int k = 1; k <= r; k++) {
			denominator *= k;
		}
		// nCr 계산값 리턴.
		return (numerator / denominator);
	}
}
