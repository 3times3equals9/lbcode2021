package study_week_6th;

import java.util.Scanner;

public class B14777740_구슬탈출2 {

	private static class Spot{
		int red_row, red_col, blue_row, blue_col;

		public Spot(int red_row, int red_col, int blue_row, int blue_col) {
			super();
			this.red_row = red_row;
			this.red_col = red_col;
			this.blue_row = blue_row;
			this.blue_col = blue_col;
		}
	}
	
	static int ROW,COL;
	static char[][] init_arr, copy_arr;
	static Spot init_pos, moved_pos;
	static int[] dr = {-1,0,+1,0};
	static int[] dc = {0,+1,0,-1};
	static boolean is_failed_game_over;
	//최대 10이므로 11로 초기화.
	static int result = 11;
	//permutation 저장 위한 배열
	static int[] order = new int[10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ROW = sc.nextInt();
		COL = sc.nextInt();
		init_arr = new char[ROW][COL];
		copy_arr = new char[ROW][COL];
		init_pos = new Spot(0,0,0,0);
		moved_pos = new Spot(0,0,0,0);
		
		String temp;
		for(int r=0; r<ROW; r++) {
			temp = sc.next();
			for(int c=0; c<COL; c++) {
				init_arr[r][c] = temp.charAt(c);
				//R과 B의 위치 받기
				if(init_arr[r][c] == 'R') {
					init_pos.red_row = r;
					init_pos.red_col = c;
				}else if(init_arr[r][c] == 'B') {
					init_pos.blue_row = r;
					init_pos.blue_col = c;
				}
			}
		}
		
		//DFS 돌리기. 0번째 idx, 이전 방향은 없으니까 -1.
		solve(0, -1);
		//result 의 초기값은 11. 게임 clear 못한 경우 11로 고정. 
		if(result == 11) {
			result = -1;
		}
		System.out.println(result);
		sc.close();
	}

	// ==== 초기설정 ====
	private static void init_setting() {
		//RED 위치 초기화
		moved_pos.red_row = init_pos.red_row;
		moved_pos.red_col = init_pos.red_col;
		//BLUE 위치 초기화
		moved_pos.blue_row = init_pos.blue_row;
		moved_pos.blue_col = init_pos.blue_col;
		//게임 끝 초기화. 아직 실패 아님.
		is_failed_game_over = false;
		//맵 복사
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				copy_arr[r][c] = init_arr[r][c];
			}
		}
	}
	
	// ==== 방향에 따라 굴리기. 리턴값 true 인 경우만 성공으로 끝남. ====
	private static boolean roll(int dir) {
		int red_nr = moved_pos.red_row;
		int red_nc = moved_pos.red_col;
		int blue_nr = moved_pos.blue_row;
		int blue_nc = moved_pos.blue_col;
		
		// R : 출구 체크
		// RB : Red 가 이동 중 Blue 를 만났나 체크(만난 것은 한 칸 뒤로 옮기도록)
		boolean flag_R = false;
		boolean flag_RB = false;
		boolean flag_BR = false;
		boolean flag_B = false;
		
		//빨강 먼저 이동
		while(true) {
			red_nr = red_nr + dr[dir];
			red_nc = red_nc + dc[dir];
			
			//길 외의 것을 만난다면
			if(copy_arr[red_nr][red_nc] != '.') {
				//출구일경우
				if(copy_arr[red_nr][red_nc] == 'O') {
					flag_R = true; //Red 나감 체크
				}else if(copy_arr[red_nr][red_nc] == 'B') {
					flag_RB = true; //Red 구르다가 Blue 만난거 체크
					continue; //만난경우 일단 쭉 
				}
				//# 이므로 한 칸 뒤로 물려주기
				red_nr = red_nr - dr[dir];
				red_nc = red_nc - dc[dir];
				break;
			}
		}
		//Red 가 움직이다가 Blue 를 만났다면, Red를 한 칸 뒤로 움직여야 한다.
		if(flag_RB) {
			red_nr = red_nr - dr[dir];
			red_nc = red_nc - dc[dir];
		}
		//파랑 이동
		while(true) {
			blue_nr = blue_nr + dr[dir];
			blue_nc = blue_nc + dc[dir];
			//길 외의 것을 만난다면
			if(copy_arr[blue_nr][blue_nc] != '.') {
				//출구일경우
				if(copy_arr[blue_nr][blue_nc] == 'O') {
					flag_B = true; //Blue 나감 체크
				}else if(copy_arr[blue_nr][blue_nc] == 'R') {
					flag_BR = true; //Blue 구르다가 Red 만난거 체크
					continue; //만난경우 일단 쭉 
				}
				//# 이므로 한 칸 뒤로 물려주기
				blue_nr = blue_nr - dr[dir];
				blue_nc = blue_nc - dc[dir];
				break;
			}
		}
		//Red 가 구르다가 Blue 를 만나지 않았고, 
		//Blue 가 움직이다가 Red 를 만났다면
		if(!flag_RB && flag_BR) {
			blue_nr = blue_nr - dr[dir];
			blue_nc = blue_nc - dc[dir];
		}
		
		//Blue 가 빠져 나갔다면 false(실패로 끝)
		if(flag_B) {
			is_failed_game_over = true; //게임 끝남요... 실패! 
			return false;
		}
		//Red 가 빠져 나갔다면 true(성공으로 끝남)
		if(flag_R) {
			return true;
		}
		//바뀐 값들 맵에 넣어주기
		copy_arr[moved_pos.red_row][moved_pos.red_col] = '.';
		copy_arr[red_nr][red_nc] = 'R';
		copy_arr[moved_pos.blue_row][moved_pos.blue_col] = '.';
		copy_arr[blue_nr][blue_nc] = 'B';
		//시작 값 바꿔주기
		moved_pos.red_row = red_nr;
		moved_pos.red_col = red_nc;
		moved_pos.blue_row = blue_nr;
		moved_pos.blue_col = blue_nc;
		return false;
	}
	
	private static void solve(int idx, int prev) {
		//10가지의 방향이 모두 만들어 졌으면
		if(idx == 10) {
			//그 방향들 가지고 게임 돌려보기
			init_setting();
			for(int i=0; i<10; i++) {
				if(result <= i+1) {
					//횟수 가지치기. 최소값 찾는거니깐. 
					return;
				}
				if(roll(order[i])) {
					//true 라면 게임 끝. 여태까지의 최소 횟수 구하기.
					result = Math.min(result, i+1);
					return;
				}
				//게임이 실패로 끝난거면 바로 끝
				if(is_failed_game_over) {
					break;
				}
			}
			return;
		}
		
		//연속적으로 같은 방향으로의 동작을 할 필요는 없다.
		for(int i=0; i<4; i++) {
			if(i==prev) {
				continue;
			}
			//이건 중복으로 골라도 되니까, boolean 배열 selected 같은거 없어도 됨.
			// true -> 다음 단계 재귀 -> false 안해도 됨.
			order[idx] = i;
			solve(idx+1, i);
		}
	}
	
}
