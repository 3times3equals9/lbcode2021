package type_basic_1_단순반복문;

import java.util.ArrayList;
import java.util.Scanner;

public class _5_보고말하는수열 {
	
	static final int MAX_N = 20;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer>[] seq = new ArrayList[MAX_N+1];
		//N이 20까지임. 초기화해줘야함
		for(int k=0; k<=MAX_N; k++) {
			seq[k] = new ArrayList<>();
		}
		
		//첫번째 수열 첫번째 원소는 1
		seq[1].add(1);
		
		//i번째 수열이 이미 완성되어있을 때, i+1번째 수열을 구합니다.
		for(int i=1; i<n; i++) {
			int contiguous_cnt = 1;
			for(int j=1; j<=seq[i].size(); j++) {
				//끝에 다다랐거나 인접한 두 숫자가 다르다면
				//방금 전까지의 묶음에 해당하는 정보를
				//i+1번째 수열에 추가해줍니다
				if(j == seq[i].size() || seq[i].get(j) != seq[i].get(j-1)) {
					seq[i+1].add(seq[i].get(j-1));
					seq[i+1].add(contiguous_cnt);
					contiguous_cnt = 1;
				} else {
					//인접한 두 숫자가 같다면
					//지금까지 연속하여 같은 숫자가 나온 횟수를 갱신합니다
					contiguous_cnt++;
				}
			}
		}
		
		//n번째 수열을 출력합니다.
		for(int k=0; k<seq[n].size(); k++) {
			System.out.print(seq[n].get(k));
		}
		
//		for(int r=0; r<=n; r++) {
//			for(int k=0; k<seq[r].size(); k++) {
//				System.out.print(seq[r].get(k));
//			}
//			System.out.println();
//		}
		
		sc.close();
	}
}

























