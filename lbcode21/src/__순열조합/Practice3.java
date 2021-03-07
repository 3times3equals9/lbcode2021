package __순열조합;

import java.util.Scanner;

//이거 틀린거같음... 맨 첨 비트 두개 무조건 빼는게 아니라,
//암호에 해당하는 비트 패턴 튀어나오면 암호문 시작되는거.
public class Practice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] bits = new int[line.length() * 4];

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

        int SIZE = ((line.length() * 4) - 2) / 6;
        int PWSIZE = 6;

        for (int i = 0; i < SIZE; i++) {

            String strTemp = "";
            String charTemp;

            for (int j = 0; j < PWSIZE; j++) {
                charTemp = Integer.toString(bits[2 + (6 * i) + j]);
                strTemp = strTemp + charTemp;
            }

            if (strTemp.equals("001101")) {
                System.out.print(0);
            } else if (strTemp.equals("010011")) {
                System.out.print(1);
            } else if (strTemp.equals("111011")) {
                System.out.print(2);
            } else if (strTemp.equals("110001")) {
                System.out.print(3);
            } else if (strTemp.equals("100011")) {
                System.out.print(4);
            } else if (strTemp.equals("110111")) {
                System.out.print(5);
            } else if (strTemp.equals("001011")) {
                System.out.print(6);
            } else if (strTemp.equals("111101")) {
                System.out.print(7);
            } else if (strTemp.equals("011001")) {
                System.out.print(8);
            } else if (strTemp.equals("101111")) {
                System.out.print(9);
            }


        }


    }
}
