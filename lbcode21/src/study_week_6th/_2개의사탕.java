package study_week_6th;

import java.util.Scanner;

public class _2개의사탕 {

	static class Cell{
		int rr, rc, br, bc;

		public Cell(int rr, int rc, int br, int bc) {
			this.rr = rr;
			this.rc = rc;
			this.br = br;
			this.bc = bc;
		}
	}
	
	static int R, C;
	static char[][] map, copy;
	static Cell init, moved;
	
	static final int[] dr = {-1,0,1,0};
	static final int[] dc = {0,1,0,-1};
	
	static boolean isfail;
	static int result = 11;
	static int[] order = new int[10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		copy = new char[R][C];
		
		init = new Cell(0,0,0,0);
		moved = new Cell(0,0,0,0);
		
		String tmp;
		for(int r=0; r<R; r++) {
			tmp = sc.next();
			for(int c=0; c<C; c++) {
				map[r][c] = tmp.charAt(c);
				
				if(map[r][c] == 'R') {
					init.rr = r;
					init.rc = c;
				}
				if(map[r][c] == 'B') {
					init.br = r;
					init.bc = c;
				}
			}
		}
		
		//게임풀이 시작, 이전 방향은 없으니까 -1.
		solve(0, -1);
		
		if(result == 11) {
			result = -1;
		}
		System.out.println(result);
		sc.close();
	}
	
	//초기세팅
	static void setting() {
		moved.rr = init.rr;
		moved.rc = init.rc;
		
		moved.br = init.br;
		moved.bc = init.bc;
		
		isfail = false;
		
		//맵복사
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				copy[r][c] = map[r][c];
			}
		}
	}
	
	//방향, 굴리기
	static boolean roll(int dir) {
		int rnr = moved.rr;
		int rnc = moved.rc;
		int bnr = moved.br;
		int bnc = moved.bc;
		
		//R 출구체크
		//RB 구슬따닥,Red 가 이동 중 Blue 를 만났나 체크(만난 것은 한 칸 뒤로 옮기도록)
		boolean flagR = false;
		boolean flagRB = false;
		boolean flagBR = false;
		boolean flagB = false;
		
		//빨강먼저 이동
		while(true) {
			rnr = rnr + dr[dir];
			rnc = rnc + dc[dir];
			//다음 구슬 위치가 길이 아니면
			if(copy[rnr][rnc] != '.') {
				//출구일경우
				if(copy[rnr][rnc] == 'O') {
					flagR = true;//빨강구슬나감
				}
				//파랑구슬이랑 만나면
				if(copy[rnr][rnc] == 'B') {
					flagRB = true;//Red 구르다가 Blue 만난거 체크
					continue;//아직 나가거나 벽만난거 아니니까 계속 굴림
				}
				//#벽 이거나 빨강구슬 나가는 경우임, 한칸 빠꾸
				rnr = rnr - dr[dir];
				rnc = rnc - dc[dir];
				break;
			}
		}
		//
		if(flagRB) {
			rnr = rnr - dr[dir];
			rnc = rnc - dc[dir];
		}
		
		//파랑이동
		while(true) {
			bnr = bnr + dr[dir];
			bnc = bnc + dc[dir];
			//다음 구슬 위치가 길이 아니면
			if(copy[bnr][bnc] != '.') {
				//출구일경우
				if(copy[bnr][bnc] == 'O') {
					flagB = true;
				}
				//빨강구슬이랑 만나면
				if(copy[bnr][bnc] == 'R') {
					flagBR = true;
					continue;
				}
				//#벽 이거나 파랑구슬 나가는 경우임, 한칸 빠꾸
				bnr = bnr - dr[dir];
				bnc = bnc - dc[dir];
				break;
			}
		}
		
		//빨강구슬 -> 파랑구슬 X 이고
		//파랑구슬 -> 빨강구슬 O 인경우
		if(!flagRB && flagBR) {
			bnr = bnr - dr[dir];
			bnc = bnc - dc[dir];
		}		
		
		//파랑이 빠져나가면 실패
		if(flagB) {
			isfail = true;
			//아직 겜 안끝남의 뜻 false
			return false;
		}
		
		//빨강빠져나가면 성공
		if(flagR) {
			return true;
		}
		
		//맵에서 바뀐값들 조작
		copy[moved.rr][moved.rc] = '.';
		copy[rnr][rnc] = 'R';
		copy[moved.br][moved.bc] = '.';
		copy[bnr][bnc] = 'B';
		//구슬위치정보바꿔주기
		moved.rr = rnr;
		moved.rc = rnc;
		moved.br = bnr;
		moved.bc = bnc;
		//아직 겜 안끝남의 뜻 false
		return false;
	}
	
	static void solve(int idx, int prev) {
		//10가지 방향 완성
		if(idx == 10) {
			//겜시작
			setting();
			for(int i = 0; i<10; i++) {
				if(result <= i+1) {
					//가지치기. 이미 찾은 result값이 앞으로 탐색할거보다 더 작으면 찾을 필요 없지
					return;
				}
				if(roll(order[i])) {
					//true : 빨강이만 먼저 빠져나간경우임
					result = Math.min(result,  i+1);
					return;
				}
				//게임이 실패로 끝난거면 바로 끝
				if(isfail) {
					break;
				}
			}
			return;
		}
		
		//연속으로 같은 방향으로 굴릴 필요 없다
		for(int i=0; i<4; i++) {
			if(i == prev) {
				continue;
			}
			//이건 중복으로 골라도 되므로... boolean, visited, selected없어도 됨
			order[idx] = i;
			solve(idx+1, i);
		}
	}
	
}

























