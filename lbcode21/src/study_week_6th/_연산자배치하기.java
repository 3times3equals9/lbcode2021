package study_week_6th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _연산자배치하기 {

    static int size;
    static int[] numbers;
    static int[] origin_operators;
    static int[] combined_operators;
    static int[] opNum;
    static boolean[] selected;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }
        opNum = new int[3];
        for (int i = 0; i < 3; i++) {
            opNum[i] = sc.nextInt();
        }
        origin_operators = new int[size - 1];
        // 0+, 1-, 2*
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < opNum[i]; j++) {
                origin_operators[k] = i;
                k++;
            }
        }

        selected = new boolean[size - 1];
        combined_operators = new int[size - 1];
        list = new ArrayList<>();
        permutation(0);
        Collections.sort(list);

        System.out.print(list.get(0));
        System.out.print(" ");
        System.out.println(list.get(list.size()-1));

        sc.close();
    }

    public static void permutation(int index) {
        if (index == size - 1) {
            list.add(calculate());
            return;
        }

        for (int i = 0; i < size-1; i++) {
            if (!selected[i]) {
                combined_operators[index] = origin_operators[i];
                selected[i] = true;
                permutation(index + 1);
                selected[i] = false;
            }
        }
    }

    public static int calculate() {
        int sum = numbers[0];
        int k = 1;
        for (int i = 0; i < size - 1; i++) {
            if (combined_operators[i] == 0) {
                sum = sum + numbers[k];
                k++;
            } else if (combined_operators[i] == 1) {
                sum = sum - numbers[k];
                k++;
            } else if (combined_operators[i] == 2) {
                sum = sum * numbers[k];
                k++;
            }
        }
        return sum;
    }
}

