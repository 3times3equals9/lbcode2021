package __순열조합;

import java.util.Scanner;

public class Practice1_TH {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        int i = 0, count = 7, size = chars.length;

        while (i < size) {
            int number = 0;
            for (int j = 0; j < count; j++) {
                if (chars[i + j] == '0') continue;
                number += (1 << (count - 1 - j));
            }
            System.out.println(number);

            // 이부분 고쳐야 함
            i += count;
        }
    }
}
