package study_week_4th;

import java.util.Scanner;

public class _2차원테트리스 {
	static int k, score, remain;
	static int[][] block;
	static int[][] mapyel, mapred;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		block = new int[k][3];
		for(int i=0; i<k; i++) {
			block[i][0] = sc.nextInt();//type
			block[i][1] = sc.nextInt();
			block[i][2] = sc.nextInt();
		}
		mapyel = new int[6][4];
		mapred = new int[6][4];
		
		score = 0;
		remain = 0;
		
		for(int i=0; i<k; i++) {
			int type = block[i][0];
			int row = block[i][1];
			int col = block[i][2];
			
			blockdown_yel(row, col, type);
			blockdown_red(row, col, type);
			
			checkbomb_yel();
			checkbomb_red();
			
			checktop_yel();
			checktop_red();
		}

		countremain();
		
		System.out.println(score);
		System.out.println(remain);
		sc.close();
	}
	
	public static void countremain() {
		for(int r=0; r<6; r++) {
			for(int c=0; c<4; c++) {
				if(mapyel[r][c] != 0) {
					remain++;
				}
				if(mapred[r][c] != 0) {
					remain++;
				}
			}
		}
	}
	
	public static void blockdown_yel(int r, int c, int t) {
		if(t == 1) {
			int dest = -1;
			for(int i = 0; i<6; i++) {
				if(mapyel[dest+1][c] == 0) {
					dest++;
				}else {
					break;
				}
			}
			mapyel[dest][c] = 1;
		}else if(t == 2) {
			int dest = -1;
			for(int i = 0; i<6; i++) {
				if(mapyel[dest+1][c] == 0 && mapyel[dest+1][c+1] == 0) {
					dest++;
				}else {
					break;
				}
			}
			mapyel[dest][c] = 2;
			mapyel[dest][c+1] = 2;
		}else if(t == 3) {
			int dest = -1;
			for(int i = 0; i<5; i++) {
				if(mapyel[dest+1][c] == 0 && mapyel[dest+2][c] == 0) {
					dest++;
				}else {
					break;
				}
			}
			mapyel[dest][c] = 3;
			mapyel[dest+1][c] = 3;
		}
	}
	
	public static void cascade_yel(int h) {
		for(int r=h; r>=1; r--) {
			for(int c=0; c<4; c++) {
				mapyel[r][c] = mapyel[r-1][c];
			}
		}
		//한줄 터진거니깐 맨 위에 0으로 채워주면 됨
		for(int c=0; c<4; c++) {
			mapyel[0][c] = 0;
		}
	}
	
	public static void checkbomb_yel() {
		for(int i=5; i>=0; i--) {
			if(mapyel[i][0] != 0 && mapyel[i][1] != 0 && mapyel[i][2] != 0 && mapyel[i][3] != 0) {
				score++;
				cascade_yel(i);
				//i번째 줄이 터져서 i번째까지 내려야 함... i번째부터 다시 확인
				i++;
			}
		}
	}
	
	public static void checktop_yel() {
		if(mapyel[0][0] != 0 || mapyel[0][1] != 0 || mapyel[0][2] != 0 || mapyel[0][3] != 0) {
			//두줄내리기
			for(int r=5; r>=2; r--) {
				for(int c=0; c<4; c++) {
					mapyel[r][c] = mapyel[r-2][c];
				}
			}
			for(int r=0; r<=1; r++) {
				for(int c=0; c<4; c++) {
					mapyel[r][c] = 0;
				}
			}
		}else if((mapyel[0][0] == 0 && mapyel[0][1] == 0 && mapyel[0][2] == 0 && mapyel[0][3] == 0)
				&& (mapyel[1][0] != 0 || mapyel[1][1] != 0 || mapyel[1][2] != 0 || mapyel[1][3] != 0)) {
			//한줄내리기
			for(int r=5; r>=1; r--) {
				for(int c=0; c<4; c++) {
					mapyel[r][c] = mapyel[r-1][c];
				}
			}
			for(int c=0; c<4; c++) {
				mapyel[1][c] = 0;
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	public static void blockdown_red(int r, int c, int t) {
		if(t == 1) {
			int dest = -1;
			for(int i = 0; i<6; i++) {
				if(mapred[dest+1][r] == 0) {
					dest++;
				}else {
					break;
				}
			}
			mapred[dest][r] = 1;
		}else if(t == 2) {
			int dest = -1;
			for(int i = 0; i<5; i++) {
				if(mapred[dest+1][r] == 0 && mapred[dest+2][r] == 0) {
					dest++;
				}else {
					break;
				}
			}
			mapred[dest][r] = 2;
			mapred[dest+1][r] = 2;
		}else if(t == 3) {
			int dest = -1;
			for(int i = 0; i<6; i++) {
				if(mapred[dest+1][r] == 0 && mapred[dest+1][r+1] == 0) {
					dest++;
				}else {
					break;
				}
			}
			mapred[dest][r] = 3;
			mapred[dest][r+1] = 3;
		}
	}
	
	public static void cascade_red(int h) {
		for(int r=h; r>=1; r--) {
			for(int c=0; c<4; c++) {
				mapred[r][c] = mapred[r-1][c];
			}
		}
		//한줄 터진거니깐 맨 위에 0으로 채워주면 됨
		for(int c=0; c<4; c++) {
			mapred[0][c] = 0;
		}
	}
	
	public static void checkbomb_red() {
		for(int i=5; i>=0; i--) {
			if(mapred[i][0] != 0 && mapred[i][1] != 0 && mapred[i][2] != 0 && mapred[i][3] != 0) {
				score++;
				cascade_red(i);
				//i번째 줄이 터져서 i번째까지 내려야 함... i번째부터 다시 확인
				i++;
			}
		}
	}
	
	public static void checktop_red() {
		if(mapred[0][0] != 0 || mapred[0][1] != 0 || mapred[0][2] != 0 || mapred[0][3] != 0) {
			//두줄내리기
			for(int r=5; r>=2; r--) {
				for(int c=0; c<4; c++) {
					mapred[r][c] = mapred[r-2][c];
				}
			}
			for(int r=0; r<=1; r++) {
				for(int c=0; c<4; c++) {
					mapred[r][c] = 0;
				}
			}
		}else if((mapred[0][0] == 0 && mapred[0][1] == 0 && mapred[0][2] == 0 && mapred[0][3] == 0)
				&& (mapred[1][0] != 0 || mapred[1][1] != 0 || mapred[1][2] != 0 || mapred[1][3] != 0)) {
			//한줄내리기
			for(int r=5; r>=1; r--) {
				for(int c=0; c<4; c++) {
					mapred[r][c] = mapred[r-1][c];
				}
			}
			for(int c=0; c<4; c++) {
				mapred[1][c] = 0;
			}
		}
	}
}

























































