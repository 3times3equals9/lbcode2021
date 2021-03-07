package __순열조합;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String temp = sc.next();

        for (int i = 0; i < 10; i++) {
            String temp2 = temp.substring(i * 7, (i+1) * 7);
            System.out.println(binToDec(temp2));
        }
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
