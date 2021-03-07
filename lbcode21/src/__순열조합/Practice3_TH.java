package __순열조합;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//이맨 첨 비트 두개 무조건 빼는게 아니라,
//암호에 해당하는 비트 패턴 튀어나오면 암호문 시작되는거.

public class Practice3_TH {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
////////////////////////////////////////////////////////////////

        //선생님은 암호를 map 으로 다룸. 키랑 밸류랑
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("001101",0);
        map.put("010011",1);
        map.put("111011",2);
        map.put("110001",3);
        map.put("100011",4);
        map.put("110111",5);
        map.put("001011",6);
        map.put("111101",7);
        map.put("011001",8);
        map.put("101111",9);

        String line = sc.nextLine();
        char[] bits = new char[line.length() * 4];
        Arrays.fill(bits,'0');

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
                bits[b + j] = Integer.toString(remainder).charAt(0);
                j--;
                temp = qutotient;
                if (temp == 0) {
                    break;
                }
            }
            b += 4;
        }

        System.out.println(Arrays.toString(bits));
/*
여기 채워야 함니다.
 */

    }
}
