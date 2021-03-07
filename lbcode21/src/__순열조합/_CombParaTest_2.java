package __순열조합;

import java.util.Arrays;
import java.util.Scanner;

public class _CombParaTest_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
//		int R = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solution(arr));

		sc.close();
	}

	public static int solution(int[] nums) {
		Arrays.sort(nums);
		int length = nums.length;
		int maxSum = nums[length - 1] + nums[length - 2] + nums[length - 3];
		boolean[] notPrime = getNotPrimeArr(maxSum);
		int[] selectedNum = new int[3];
		int res = dfs(0, notPrime, nums, selectedNum, 0, 0);
		return res;
	}

	private static int dfs(int depth, boolean[] notPrime, int[] nums, int[] selectedNum, int index, int ans) {
		int res = 0;
		if (depth == 3) {
			int sum = 0;
			for (int n : selectedNum)
				sum += n;
			if (!notPrime[sum]) {
				System.out.println("최종 return ans + 1;");
				return ans + 1;
			}
			System.out.println("최종 return ans;");
			return ans;
		}

		for (int i = index; i < nums.length; ++i) {
			selectedNum[depth] = nums[i];
			int temp = dfs(depth + 1, notPrime, nums, selectedNum, i + 1, ans);
			res = res < temp ? temp : res;
			ans = ans < temp ? temp : ans;
		}
		System.out.println("맨마지막 return res;");
		return res;
	}

	private static boolean[] getNotPrimeArr(int maxSum) {
		boolean[] res = new boolean[maxSum + 1];

		for (int i = 2; i <= maxSum; ++i) {
			int mul = 2;
			for (int j = i * mul; j <= maxSum; j = (++mul) * i) {
				res[j] = true;
			}
		}
		return res;
	}
}
