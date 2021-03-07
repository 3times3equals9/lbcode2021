package __순열조합;

public class PermutationTest1 {

	public static void main(String[] args) {

		//1,2,3 = 3! = 6가지
		for(int i=1; i<=3; ++i) {
			for(int j=1; j<=3; ++j) {
				if(i!=j) {
					for(int k=1; k<=3; ++k) {
						if(i!=k && j!=k) {
							System.out.println(i+" "+j+" "+k);
						}
					}
				}
			}
		}
		
	}

}
