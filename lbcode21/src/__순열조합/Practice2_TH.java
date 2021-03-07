package __순열조합;

import java.util.Scanner;

public class Practice2_TH {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] bits = new int[line.length() * 4];
        //int 형 배열이라서, 기본적으로 0으로 초기화 됨.
        //필요하지 않은 비트 칸들이 모두 0이 되어있어서 NO 걱정.

        char c;
        int temp, qutotient, remainder, b = 0;

        for (int i = 0; i < line.length(); i++) {

            c = line.charAt(i);
            if ('0' <= c && c <= '9') {
                temp = c - '0';
            } else {
                temp = c - 'A' + 10;
            }
            int j = 3;
            while (true) {

                qutotient = temp / 2;
                remainder = temp % 2;
                bits[b + j] = remainder;
                j--;
                temp = qutotient;
                if (temp == 0) {
                    break;
                }
            }
            b += 4;
        }

        int i = 0, count = 7;
        int size1 = (bits.length / count) * 7; //정확하게 7bit 인 갯수
        int size2 = bits.length % 7; //non-7 bit 갯수

        while (i < size1) {
            int number = 0;
            for (int j = 0; j < count; j++) {
                if (bits[i + j] == 0) continue;
                number += (1 << (count - 1 - j));
            }
            System.out.println(number);
            // 이부분 고쳐야 함
            i += count;
        }

        if(size2>0) {
            int number = 0;
            for (int j = 0; j < size2; j++) {
                if (bits[size1 + j] == 0) continue;
                number += (1 << (size2 - 1 - j));
            }
            System.out.println(number);
        }
    }

}
