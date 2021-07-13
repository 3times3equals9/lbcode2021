package _lb_mark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _5_사다리타기_1st_백트래킹 {
	
	static class Pair implements Comparable<Pair>{
		public int first;
		public int second;
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		public Pair(Pair p) {
			this.first = p.first;
			this.second = p.second;
		}
		@Override
		public int compareTo(Pair o) {
			if(this.second != o.second) {
				return this.first - o.first;
			}else {
				return this.second - o.second;
			}
		}
	}
	
	static final int MAX_N = 11;
	static int n, m;
	static int ans = Integer.MAX_VALUE;
	static ArrayList<Pair> lines = new ArrayList<>();
	static ArrayList<Pair> selected_lines = new ArrayList<>();
	
	// 처음 상황과, 선택한 가로줄만 사용했을 때의
	// 상황을 시뮬레이션하여
	// 둘의 결과가 같은지 확인합니다.
	static boolean Possible() {
	    // Step1. 시작 숫자를 셋팅합니다.
		//int num1[MAX_N], num2[MAX_N];
		int[] num1 = new int[n];
		int[] num2 = new int[n];
		for(int i = 0; i < n; i++)
			num1[i] = num2[i] = i;
		
	    // Step2. 위에서부터 순서대로 적혀있는 
	    // 가로줄에 대해 양쪽 번호에 해당하는 숫자를 바꿔줍니다. 
		for(int i = 0; i < (int) lines.size(); i++) {
//			int idx = lines[i].second;
			int idx = lines.get(i).second;
			//swap(num1[idx], num1[idx + 1]);
			int tmp1 = num1[idx];
			num1[idx] = num1[idx + 1];
			num1[idx + 1] = tmp1;
		}
		for(int i = 0; i < (int) selected_lines.size(); i++) {
//			int idx = selected_lines[i].second;
			int idx = selected_lines.get(i).second;
			//swap(num2[idx], num2[idx + 1]);
			int tmp2 = num2[idx];
			num2[idx] = num2[idx + 1];
			num2[idx + 1] = tmp2;
		}
		
	    // Step3. 두 상황의 결과가 동일한지 확인합니다.
		for(int i = 0; i < n; i++)
			if(num1[i] != num2[i])
				return false;

		return true;
	}
	
	static void FindMinLines(int cnt) {
		if(cnt == m) {
			if(Possible())
				ans = Math.min(ans, (int) selected_lines.size());
			return;
		}
		
		//selected_lines.add(new Pair(lines.get(cnt)));
		selected_lines.add(lines.get(cnt));
		FindMinLines(cnt + 1);
		int tmp_len = selected_lines.size();
		selected_lines.remove(tmp_len-1);
		
		FindMinLines(cnt + 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0; i < m; i++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();
			lines.add(new Pair(b, a - 1));
		}
		
		Collections.sort(lines);
		FindMinLines(0);
		System.out.println(ans);
		sc.close();
	}
}

/*

Intuition
Backtracking을 이용하면 가로줄을 M개 중 사용할 가로줄 조합을 모두 만들어보는 작업을 진행할 수 있습니다. 각각의 조합에 대해 사다리 게임을 진행하여 처음과 결과가 같은지를 판단하여, 가능한 답 중 최솟값을 계산할 수 있습니다. 사다리 게임에서의 진행은 위에서부터 아래로 내려오면서 가로선이 있을 때 해당 위치에 있는 두 값을 바꾸는 것으로 비교적 쉽게 시뮬레이션이 가능합니다.

Algorithm
이 문제에서는 입력으로 주어진 M개의 가로줄 중 가능한 모든 조합을 만들어, 처음과 결과가 같은 경우들 중 최솟값을 구해볼 수 있습니다. 이는 Backtracking을 활용하면 쉽게 구현이 가능합니다.

사용할 가로줄을 정하고 나면, 각 번호에서 시작하여 처음 결과와 동일하게 내려오는지를 확인해야 합니다. 이 작업은 다음과 같이 맨 위에서 1부터 n까지 숫자를 부여한 다음 밑으로 내려오면서 먼저 나오는 가로줄에 대해 연관이 있는 두 지점의 현재 번호를 교환해주는 식으로 비교적 쉽게 구현이 가능합니다. 이 작업을 마치고 난 이후에 최종적으로 적혀있는 번호들을 확인하면, 결과가 변했는지 여부를 알 수 있습니다. 이 값들이 전부 동일한 경우 최솟값을 갱신해주면 됩니다.



*/




































































