package __순열조합;

import java.util.Arrays;
import java.util.Scanner;

public class _CombParameter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int R = sc.nextInt();
		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input);
		
		int[] selected = new int[R];
		
		doCombination(N,R,selected,0,input,0);
		
		sc.close();
	}

	//cursor, pointer, target ....
	private static void doCombination(int n, int r, int[] selected, int index, int[] input, int target) {
		// 여기서는 고를 때 마다 r이 1씩 감소되는 방식으로...
		if (r == 0) {
			System.out.println(Arrays.toString(selected));
			return;
		} else if (target == n) {
			return;
		} else {
			selected[index] = input[target];
			// 고른거.
			doCombination(n, r - 1, selected, index + 1, input, target + 1);
			// 안고른거.
			doCombination(n, r, selected, index, input, target + 1);
		}

	}

}
