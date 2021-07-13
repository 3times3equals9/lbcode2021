package type_simulation_1_격자안에서완전탐색;

import java.util.Scanner;

public class _4_금채굴하기_1st_모든위치확인하기_sidenote {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sc.close();
	}
}

/*
Solution에 있는 다음 코드에서 k <= n 까지만 봐도 올바른 답이 나오지 않을까요?

for(int k = 0; k < 2 * (n-1); k++) {
    // 이전 k까지 구한 금의 개수에
    // 해당 k의 모서리에 존재하는 금의 개수를 더해줍니다.
    num_of_gold += GetNumOfGoldInBorder(row, col, k);

    if(num_of_gold * m >= GetArea(k))
        max_gold = max(max_gold, num_of_gold);
}
맞습니다. 가운데 지점을 마름모의 중심으로 하여 k를 n으로 설정하면 모든 지점에서 채굴이 가능해지기 때문에, k 를 n보다 크게 설정해서 답이 더 좋아지는 경우는 없습니다.
*/





































































