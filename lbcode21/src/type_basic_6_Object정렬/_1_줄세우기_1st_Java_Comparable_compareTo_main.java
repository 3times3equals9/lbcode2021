package type_basic_6_Object정렬;


/*
키가 더 큰 학생이 앞에 와야 합니다.

키가 동일하다면, 몸무게가 더 큰 학생이 앞에 와야 합니다.

키와 몸무게가 동일하다면, 번호가 작은 학생이 앞에 와야 합니다.
*/

import java.util.Arrays;
import java.util.Scanner;

public class _1_줄세우기_1st_Java_Comparable_compareTo_main {
	
	// 학생들의 정보를 나타내는 클래스 선언
	static class Student implements Comparable<Student>{
		public int height;
		public int weight;
		public int number;
		
		public Student(int height, int weight, int number) {
			this.height = height;
			this.weight = weight;
			this.number = number;
		}

		// Comparable, compareTo
		// 기본은 적은 순서대로 오름차순, 
		// 순서 바꿔서 빼면 내림차순
		// 음수, 0 : 그대로 / 양수 : 자리바꾸기
		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			if(this.height != o.height) {
				// 키가 크면 정렬 했을 때 앞에 와야 합니다.
				return -(this.height-o.height);
			} else {
				if(this.weight != o.weight) {
					// 몸무게가 크면 정렬 했을 때 앞에 와야합니다.
					return -(this.weight-o.weight);
				} else {
					// 번호가 작으면 앞에 와야 합니다.
					return (this.number - o.number);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Student[] students = new Student[n];
		
		for(int i=0; i<n; i++) {
			int height = sc.nextInt();
			int weight = sc.nextInt();
			// Student 객체를 생성해 벡터에 추가합니다.
			students[i] = new Student(height, weight, i+1);
		}
		
	    // Arrays.sort 를 활용한 정렬 (얘는 퀵소트인감)
		Arrays.sort(students);
		
		// 결과를 출력합니다.
	    for (int i = 0; i < n; i++){
	    	System.out.print(students[i].height + " ");
	    	System.out.print(students[i].weight + " ");
	    	System.out.println(students[i].number);
	    }
		
		sc.close();
	}
}









































































