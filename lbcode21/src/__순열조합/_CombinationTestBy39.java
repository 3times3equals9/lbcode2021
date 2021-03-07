package __순열조합;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//nCr
public class _CombinationTestBy39 {

    static int N, R, numbers[];
    static boolean[] selected;
    static int[] arr;

    public static void main(String[] args) throws FileNotFoundException {

        //System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();
        arr = new int[N];
        selected = new boolean[N];

        //N 개의 자연수 받기
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        //입력받은 자연수 배열 정렬...
        Arrays.sort(arr);
        //permutation 함수 때문에, static 변수 배열 numbers 는 정렬되어서 저장.
        combination(0, 0);

    }//메인 끝

    private static void combination(int index, int count) {
        if (count == R) {
        	numbers = new int[R];
        	int idx = 0;
        	for(int i=0; i<N; i++) {
        		if(selected[i]) {
        			numbers[idx] = arr[i];
        			idx++;
        		}
        	}
            System.out.println(Arrays.toString(numbers));
            return;
        }

        //0부터 N-1까지 인덱스로 시도...
        for (int k = index; k < N; k++) {
        	if(!selected[k]) {
        		selected[k] = true;
	            combination(k+1, count+1);
	            selected[k] = false;
        	}
        }
    }
}

