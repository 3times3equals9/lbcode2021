package __순열조합;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PermutationEx1 {

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
        numbers = new int[R];

        //N 개의 자연수 받기
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        //입력받은 자연수 배열 정렬...
        Arrays.sort(arr);
        //permutation 함수 때문에, static 변수 배열 numbers 는 정렬되어서 저장.
        permutation(0);


    }//메인 끝

    private static void permutation(int index) {
        if (index == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        //1부터 X까지 시도
        for (int i = 0; i < N; ++i) {
            // 시도하는 수가 기존자리수까지 사용되지 않았다면
            if (!selected[i]) {
                numbers[index] = arr[i];
                selected[i] = true;
                permutation(index + 1);
                selected[i] = false;
            }
        }
    }

}
