package type_basic_1_단순반복문;

public class _1_19단출력 {
	public static void main(String[] args) {
		for(int first = 1; first <= 19; first++) {
			for(int second = 1; second <= 19; second++) {
				if(second % 2 == 1) {
					//case1
					System.out.print(first + " * " + second + " = " + (first * second));
				}else {
					//case2
					System.out.println(" / " + first + " * " + second + " = " + (first * second));
				}
				
				if(second == 19) {
					System.out.println();	
				}
			}
		}
	}
}

/*
public class Main {
	public static void main(String[] args) {
		for (int r = 1; r <= 19; r++) {
			for (int c = 1; c <= 19; c++) {
				System.out.print(r + " * " + c + " = " + (r*c));
				if(c % 2 == 1 && c != 19) {
					System.out.print(" / ");
				}else if(c % 2 == 0 || c == 19) {
					System.out.println();
				}
			}
		}
	}
}
*/














