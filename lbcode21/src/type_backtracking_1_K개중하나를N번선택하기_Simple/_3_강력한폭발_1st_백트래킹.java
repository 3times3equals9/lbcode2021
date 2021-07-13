package type_backtracking_1_K개중하나를N번선택하기_Simple;

import java.util.ArrayList;
import java.util.Scanner;

public class _3_강력한폭발_1st_백트래킹 {
	
	static class Pair {
		int row;
		int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static final int MAX_N = 20;
	static final int BOMB_TYPE_NUM = 3;

	static int n;
	static int[][] bomb_type = new int[MAX_N][MAX_N];
	static boolean[][] bombed = new boolean[MAX_N][MAX_N];
	static int ans;
	static ArrayList<Pair> bomb_pos = new ArrayList<>();
	
	static boolean InRange(int x, int y) {
	    return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	static void Bomb(int x, int y, int b_type) {
	    // 폭탄 종류마다 터질 위치를 미리 정의합니다.
		/*
		pair<int, int> bomb_shapes[BOMB_TYPE_NUM + 1][5] = {
	        {},
	        { {-2, 0}, {-1, 0}, {0, 0},  {1, 0}, {2, 0}},
	        { {-1, 0},  {1, 0}, {0, 0}, {0, -1}, {0, 1}},
	        {{-1, -1}, {-1, 1}, {0, 0}, {1, -1}, {1, 1}}
	    };
	    */
		
		Pair[][] bomb_shapes = new Pair[BOMB_TYPE_NUM + 1][5];
		//폭탄1번
		bomb_shapes[1][0] = new Pair(-2, 0);
		bomb_shapes[1][1] = new Pair(-1, 0);
		bomb_shapes[1][2] = new Pair(0, 0);
		bomb_shapes[1][3] = new Pair(1, 0);
		bomb_shapes[1][4] = new Pair(2, 0);
		//폭탄2번
		bomb_shapes[2][0] = new Pair(-1, 0);
		bomb_shapes[2][1] = new Pair(1, 0);
		bomb_shapes[2][2] = new Pair(0, 0);
		bomb_shapes[2][3] = new Pair(0, -1);
		bomb_shapes[2][4] = new Pair(0, 1);
		//폭탄3번
		bomb_shapes[3][0] = new Pair(-1, -1);
		bomb_shapes[3][1] = new Pair(-1, 1);
		bomb_shapes[3][2] = new Pair(0, 0);
		bomb_shapes[3][3] = new Pair(1, -1);
		bomb_shapes[3][4] = new Pair(1, 1);
	    
	    // 격자 내 칸에 대해서만 영역을 표시합니다.
	    for(int i = 0; i < 5; i++) {
	        int dx, dy;
	        //tie(dx, dy) = bomb_shapes[b_type][i];
	        dx = bomb_shapes[b_type][i].row;
	        dy = bomb_shapes[b_type][i].col;
	        
	        int nx = x + dx, ny = y + dy;
	        if(InRange(nx, ny))
	            bombed[nx][ny] = true;
	    }
	}
	
	static int Calc() {
	    // Step1. 폭탄이 터진 위치를 표시하는 배열을
	    // 초기화합니다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				bombed[i][j] = false;
		
	    // Step2. 각 폭탄의 타입에 따라 
	    // 초토화 되는 영역을 표시합니다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
	            if(bomb_type[i][j] > 0)
	                Bomb(i, j, bomb_type[i][j]);
		
	    // Step3. 초토화된 영역의 수를 구합니다.
		int cnt = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
	            if(bombed[i][j])
	                cnt++;
	    
		return cnt;
	}
	
	static void FindMaxArea(int cnt) {
		if(cnt == (int) bomb_pos.size()) {
			ans = Math.max(ans, Calc());
			return;
		}
		for(int i = 1; i <= 3; i++) {
	        int x, y;
	        //tie(x, y) = bomb_pos[cnt];
	        x = bomb_pos.get(cnt).row;
	        y = bomb_pos.get(cnt).col;
	        		
			bomb_type[x][y] = i;
			FindMaxArea(cnt + 1);
			bomb_type[x][y] = 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) {
	            int bomb_place = sc.nextInt();
				if(bomb_place > 0)
					bomb_pos.add(new Pair(i, j));
			}
		
		FindMaxArea(0);
		
		System.out.println(ans);
		sc.close();
	}
}

/*
 * 
Intuition
폭탄을 놓아야 하는 위치에 놓이게 될 폭탄 종류에 대해 가능한 모든 순열을 만들어, 그 중 폭탄에 의해 초토화 되는 영역 중 최대를 구합니다. 각 폭탄 종류마다 영향을 미치는 위치들을 나타내는 배열을 하나 만들면 코딩 실수를 줄일 수 있습니다.

Algorithm
폭탄을 놓아야 할 위치의 수를 M이라 하면, 총 3^M 개의 가능한 모든 순열을 만드는 재귀를 작성해볼 수 있습니다. 각 순열에 대해 초토화 되는 영역은 dx, dy 테크닉을 활용하여 각 폭탄 종류마다 영향을 끼치는 위치에 대해 표기를 하는 식으로 진행할 수 있습니다. 이때, 배열을 만들어 위치 목록을 관리하면 코딩 실수를 줄일 수 있습니다 * 
 * 
 */







































































