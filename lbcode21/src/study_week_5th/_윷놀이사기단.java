package study_week_5th;

import java.util.Scanner;

public class _윷놀이사기단 {
	/*

 	경로구분_모든칸은고유한인덱스를가져야함 >> 말 겹치는거 확인할라면. 말 방문체크 할라면, 칸마다 고유한 번호를 부여하는게 확인 쉬움.

	 */
	private static class Cell{
		public int index;
		public int value;
		public Cell next;
		public Cell shortcut;

		public Cell(int index, int value, Cell next, Cell shortcut) {
			this.index = index;
			this.value = value;
			this.next = next;
			this.shortcut = shortcut;
		}
		
		public Cell move(boolean isOnEdge, int count) {
			boolean checkEdge = isOnEdge;
			Cell nextCell = this;
//			int nextCellIndex = startCell.index;
//			if(nextCell.index == 32) {
//				return cell[32];
//			}
			
			for(int i=0; i<count; i++) {
				
				if(nextCell.index == 32) {
					nextCell = cell[32];
					break;
				}
				
				if(checkEdge) {
					nextCell = nextCell.shortcut;
					checkEdge = false;
				}else {
					nextCell = nextCell.next;
				}
				
			}
//			System.out.println("nextCell.index : " + nextCell.index);
			return nextCell;
		}
	}
	
	private static class Chess{
		int currentIdx;
		boolean isOnEdge;
		public Chess(int currentIdx, boolean isOnEdge) {
			this.currentIdx = currentIdx;
			this.isOnEdge = isOnEdge;
		}
	}
	
	static final int TEN = 10;
	static int[] dice, selectedChess;
	static Chess[] chess;
	static Cell[] cell;
	static int[] occupied;
	static int MAX;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dice = new int[TEN];
		for (int i = 0; i < TEN; i++) {
			dice[i] = sc.nextInt();
		}
		
		boardInit();
		
		selectedChess = new int[TEN];
		MAX = 0;
		multiPermutation(0);
		
		System.out.println(MAX);
		sc.close();
	}
	
	private static void multiPermutation(int index) {
		if(index == TEN) {
			occupied = new int[33];
			int score = gameStart();
			MAX = Math.max(MAX, score);
			return;
		}
		
		for(int k=0; k<4; k++) {
			selectedChess[index] = k;
			multiPermutation(index+1);
		}
	}
	
	private static int gameStart() {
		int sum = 0;
		
		chess = new Chess[4];
		for(int i=0; i<4; i++) {
			chess[i] = new Chess(0, false);
		}
		
		for(int i=0; i<TEN; i++) {
			int curChessNum = selectedChess[i];
			int curCount = dice[i];
			
			int curPosition = chess[curChessNum].currentIdx;
			if(curPosition == 32) {continue;}
			
			boolean isOnEdge = chess[curChessNum].isOnEdge;
			
			Cell nextCell = cell[curPosition].move(isOnEdge, curCount);
			
			int ncIndex = nextCell.index;
			int toGetScore = nextCell.value;
			
			if(ncIndex != 0 && ncIndex != 32 && occupied[ncIndex] > 0) {
				return 0;
			}else if(ncIndex != 0 && ncIndex != 32 && occupied[ncIndex] == 0) {
				sum += toGetScore;
				occupied[ncIndex]++;
				occupied[curPosition]--;
			}else if(ncIndex == 0 || ncIndex == 32) {
//				occupied[ncIndex]++;
				occupied[curPosition]--;
			}
			chess[curChessNum].currentIdx = ncIndex;
			
			if(ncIndex == 5 || ncIndex == 10 || ncIndex == 15) {
				chess[curChessNum].isOnEdge = true;
			}else {
				chess[curChessNum].isOnEdge = false;
			}
			
		}
		return sum;
	}
	
	private static void boardInit() {
		cell = new Cell[33];

		cell[32] = new Cell(32, 0, null, null);
		cell[31] = new Cell(31, 40, cell[32], null);
		cell[30] = new Cell(30, 35, cell[31], null);
		cell[29] = new Cell(29, 30, cell[30], null);
		cell[28] = new Cell(28, 25, cell[29], null);

		cell[27] = new Cell(27, 26, cell[28], null);
		cell[26] = new Cell(26, 27, cell[27], null);
		cell[25] = new Cell(25, 28, cell[26], null);

		cell[24] = new Cell(24, 24, cell[28], null);
		cell[23] = new Cell(23, 22, cell[24], null);

		cell[22] = new Cell(22, 19, cell[28], null);
		cell[21] = new Cell(21, 16, cell[22], null);
		cell[20] = new Cell(20, 13, cell[21], null);

		cell[19] = new Cell(19, 38, cell[31], null);
		cell[18] = new Cell(18, 36, cell[19], null);
		cell[17] = new Cell(17, 34, cell[18], null);
		cell[16] = new Cell(16, 32, cell[17], null);
		cell[15] = new Cell(15, 30, cell[16], cell[25]);

		cell[14] = new Cell(14, 28, cell[15], null);
		cell[13] = new Cell(13, 26, cell[14], null);
		cell[12] = new Cell(12, 24, cell[13], null);
		cell[11] = new Cell(11, 22, cell[12], null);
		cell[10] = new Cell(10, 20, cell[11], cell[23]);

		cell[9] = new Cell(9, 18, cell[10], null);
		cell[8] = new Cell(8, 16, cell[9], null);
		cell[7] = new Cell(7, 14, cell[8], null);
		cell[6] = new Cell(6, 12, cell[7], null);
		cell[5] = new Cell(5, 10, cell[6], cell[20]);

		cell[4] = new Cell(4, 8, cell[5], null);
		cell[3] = new Cell(3, 6, cell[4], null);
		cell[2] = new Cell(2, 4, cell[3], null);
		cell[1] = new Cell(1, 2, cell[2], null);
		cell[0] = new Cell(0, 0, cell[1], null);

	}

}
