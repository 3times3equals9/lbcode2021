package __순열조합;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //int[] coin = {500, 100, 50, 10};
        int[] coin = {500, 400,100, 50, 10};
        int[] result = new int[coin.length];

        int money = sc.nextInt();

        for (int i = 0; i < coin.length; i++) {
            result[i] = money / coin[i];
            money = money % coin[i];
        }
        System.out.println(Arrays.toString(result));

    }
}

