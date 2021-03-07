package __순열조합;

import java.util.Scanner;

//끄트머리 숫자 제대로 처리 못함. 맨 오른쪽 남는 비트들.
public class Practice2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String hexStr = sc.next();

        String binStr = hexToBin(hexStr);


        for (int i = 0; i < (binStr.length() / 7); i++) {
            String result="";
            if ((i + 1) * 7 > binStr.length()) {
                for (int j = 0; j < ((i + 1) * 7 - binStr.length()); j++) {
                    result = result + "0";
                }
                String temp = binStr.substring((i * 7) + 1, (i + 1) * 7);
                result = result + temp;
                System.out.println(binToDec(result));
                break;
            }
            result = binStr.substring(i * 7, (i + 1) * 7);
            System.out.println(binToDec(result));
        }
    }

    public static String hexToBin(String str) {

        String result = "";

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '0') {
                result = result + "0000";
            } else if (str.charAt(i) == '1') {
                result = result + "0001";
            } else if (str.charAt(i) == '2') {
                result = result + "0010";
            } else if (str.charAt(i) == '3') {
                result = result + "0011";
            } else if (str.charAt(i) == '4') {
                result = result + "0100";
            } else if (str.charAt(i) == '5') {
                result = result + "0101";
            } else if (str.charAt(i) == '6') {
                result = result + "0110";
            } else if (str.charAt(i) == '7') {
                result = result + "0111";
            } else if (str.charAt(i) == '8') {
                result = result + "1000";
            } else if (str.charAt(i) == '9') {
                result = result + "1001";
            } else if (str.charAt(i) == 'A') {
                result = result + "1010";
            } else if (str.charAt(i) == 'B') {
                result = result + "1011";
            } else if (str.charAt(i) == 'C') {
                result = result + "1100";
            } else if (str.charAt(i) == 'D') {
                result = result + "1101";
            } else if (str.charAt(i) == 'E') {
                result = result + "1110";
            } else if (str.charAt(i) == 'F') {
                result = result + "1111";
            }

        }

        return result;
    }

    public static int binToDec(String str) {

        int bin = 1;
        int sum = 0;
        for (int i = 6; i >= 0; i--) {

            if (str.charAt(i) == '1') {
                sum = sum + bin;
            }
            bin = bin * 2;
        }

        return sum;
    }
}
