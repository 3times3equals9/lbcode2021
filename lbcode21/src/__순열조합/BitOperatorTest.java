package __순열조합;

public class BitOperatorTest {

	public static void main(String[] args) {

		// &, |, <<,  >>, >>>, ^, ~
		int i = 1<<1;
		int j = 6;
		System.out.println(i);
		i++;
		System.err.println(Integer.toBinaryString(i));
		System.err.println(Integer.toBinaryString(j));
		System.out.println("j&i : "+(j&i));
		System.out.println("j|i : "+(j|i));
	}

}
