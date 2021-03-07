package __순열조합;

import java.util.Scanner;

public class 장난감조립_태희쌤 {

    static int N;
    static int M;

    static int[][] toyInfo;
    static int[][] answer;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        toyInfo = new int[M][3];
        answer = new int[N][2];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                toyInfo[i][j] = sc.nextInt();
            }
        }

        sc.close();

        for (int i = 0; i < N; i++) {
            answer[i][0] = i + 1;
        }

        //재귀 돌림. 만들어야 하는 부품의 번호와 수량을 찾을거야.
        check(N, 1); //N : 부품 번호 인덱스, 1 : 필요 수량이 저장된 인덱스

        //답 출력
        for (int i = 0; i < N; i++) {
            if (answer[i][1] != 0) { // 기본부품만.
                System.out.println(answer[i][0] + " " + answer[i][1]);
            }
        }

    }

    //재귀 두번 안타고, 필요한 기본부품 갯수만 곱해서 업데이트 해줌
    private static void check(int no, int count) {
        boolean isBasic = true;

        for (int i = 0; i < M; i++) {
            if(toyInfo[i][0] == no){ // 기본부품이 아니면
                isBasic = false;
                check(toyInfo[i][1], count * toyInfo[i][2]);
            }
        }

        if(isBasic){ //isBasic == true, 기본부품이면
            answer[no-1][1] += count;
        }

        //굳이 return 문 쓰지 않아도, 알아서 끝남
    }

}
