package type_basic_2_최대최소;

import java.util.Scanner;

public class _2_n개의숫자중최대2개_note {
	/*
1. Solution1에서 다음과 같이 max2를 max1과 다른 값 중 최대를 찾는 식으로 하면 안되나요?

for(int i=0; i<n; i++) {
   if(A[i] != max1 && A[i] > max2) {
       max2 = A[i];
   }
}
다음과 같이 내림차순으로 정렬했을 때 첫 번째 원소와 두 번째 원소가 동일한 경우가 있기 때문에 위의 방식으로는 올바른 답을 구할 수 없습니다.

3
5 5 2
2. Solution1에서 max1이 뽑힌 자리인 a[max1Index]에 INT_MIN을 넣고 다시 최대를 뽑으면 되지 않나요?

A[max1index] = INT_MIN; 
for(int i=0; i<n; i++) {
   if(A[i] > max2) {
       max2 = A[i];
   }
}
INT_MIN 값이 입력으로 들어오는 숫자보다 항상 작다면 가능한 방법입니다. 하지만 입력으로 주어진 배열을 건드리게 되기 때문에 이 방법을 적용하기가 힘든 경우도 있어보입니다.

3. Solution2에서 max1, max2에 둘 다 A[0] 값을 넣고 A[1]부터 배열을 순회하면 왜 안될까요?

max1 = max2 = A[0];

// Step 2: 3번째 원소부터 보면서 max1과 max2를 갱신합니다.
for (int i = 1; i < n; i++) {
	...
}
다음과 같이 A[0]가 배열의 최댓값인 경우, 배열을 모두 순회해도 max1, max2의 값이 바뀌지 않게 되어 잘못된 답을 구하게 됩니다.

3
5 3 2
*/
}

/*
import java.util.Scanner;

public class Main {
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




























