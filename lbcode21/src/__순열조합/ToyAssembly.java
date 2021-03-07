package __순열조합;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//미완성...

public class ToyAssembly {

    static int[] basicPart;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int partNum = sc.nextInt();
        boolean[] partCheck = new boolean[partNum + 1];//전부 false 로 초기화. false 인건 기본부품.
        int part[][] = new int[partNum + 1][partNum];

        int lineNum = sc.nextInt();

        for (int i = 1; i <= lineNum; i++) {

            int midOrCompletePartNum = sc.nextInt();
            int subPartNum = sc.nextInt();
            int count = sc.nextInt();

            partCheck[midOrCompletePartNum] = true;//완제품 or 중간부품임을 체크
            part[midOrCompletePartNum][subPartNum] = count;

        }

        int completeNum = partNum;//완제품 넘버

    }

// 굳이 재귀함수 안써도 된대 by 웅이형
/*

    public static void recur(int[] arr, boolean[] check, int size) {
        for (int i = 1; i <= size - 1; i++) {

        }
    }
*/

}
