package study_week_6th;

public class _종전 {
	
	static int n;
	
	public static void main(String[] args) {
		
	}
	
	static boolean isout(int row, int col) {
		if(row < 0 || n <= row || col < 0 || n <= col) {
			return true;
		}
		return false;
	}
	
}
