package type_basic_6_Object정렬;

import java.util.Scanner;

public class _0_기본_Comparable_Comparator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sc.close();
	}
}

/**
	# public int compareTo : 기본이 오름차순
	# return 값이 0 이나 음수 : 자리 바꿈 하지 않음
	# return 값이 양수 : 자리 바꿈
	# 이게 제일 명쾌하군
	# return (id<anotherStudent.id)?-1:((id==anotherStudent.id)?0:1);
	
	1) this.id < anotherStudent.id : -1, 그대로(오름차순)
	2) this.id = anotherStudent.id : 0, 그대로(오름차순)
	3) this.id > anotherStudent.id : 1, 자리 바꿈(이거도 오름차순)
	
	@Override
	public int compareTo(Student anotherStudent){
		//이건 'score'에 대해 오름차순(큰게 오른쪽으로 감)
		return this.score - anotherStudent.score;
		// 1) this.score < anotherStudent.score : -1, 그대로(오름차순)
		// 2) this.score = anotherStudent.score : 0, 그대로
		// 3) this.score > anotherStudent.score : 1, 자리 바꿈(큰게 오른쪽으로 감) 
		
		//이건 'score'에 대해 내림차순(큰게 왼쪽으로 옴)
		return anotherStudent.score - this.score;
		return -1*(this.score - anotherStudent.score);
		// 1) this.score < anotherStudent.score : 1, 자리 바꿈(내림차순)
		// 2) this.score = anotherStudent.score : 0, 그대로
		// 3) this.score > anotherStudent.score : -1, 그대로(큰게 왼쪽) 
		
		
		//이게 제일 명쾌하군
		return (id<anotherStudent.id)?-1:((id==anotherStudent.id)?0:1);
	}
	
*/

/**
import java.lang.Comparable; //패키지 import

class Student implements Comparable<Student> { //제너릭스 주의!
	String name; //이름
	int id; //학번
	double score; //학점
	public Student(String name, int id, double score){
		this.name = name;
		this.id = id;
		this.score = score;
	}
	public String toString(){ //출력용 toString오버라이드
		return "이름: "+name+", 학번: "+id+", 학점: "+score;
	}
	@Override
	public int compareTo(Student anotherStudent) { //오버라이딩
		// TODO Auto-generated method stub
		return (id<anotherStudent.id)?-1:((id==anotherStudent.id)?0:1);
	}
}
*/



/*
이 int compare 메서드를 간단히 설명하자면, 정렬이 진행될 때 자리바꿈(=정렬) 여부를 결정하는 값을 넘겨주는 역할을 한다.
만약 return값이 0이나 음수이면 자리바꿈을 하지 않고, 양수이면 자리바꿈을 수행한다.
만약 오름차순이 아니라 내림차순으로 정렬하고 싶다면 매개변수의 순서를 바꿔주면 된다.
*/

/*
1) Comparable 인터페이스
    - 정의: 정렬 수행시 기본적으로 적용되는 정렬 기준이 되는 메서드를 정의해 놓는 인터페이스이다.
    - 사용법: Comparable 인터페이스를 implements 한 뒤, 내부에 있는 compareTo 메서드를 원하는 정렬 기준대로 구현하여 사용할 수 있다.
    - 패키지: java.lang.Comparable
    - 자바에서 제공되는 정렬이 가능한 클래스들은 모두 Comparable 인터페이스를 구현하고 있으며, 정렬시에 Comparable의 구현 내용에 맞춰 정렬이 수행된다.
예를들어 Integer, Double 등의 클래스의 경우 비 내림차순(오름차순과 유사), String 클래스의 경우 사전순으로 정렬되게 구현되어 있다.

  2) Comparator 클래스
    - 정의: 정렬 가능한 클래스(=Comparable이 구현된 클래스)들의 기본 정렬 기준과는 다른 방식으로 정렬하고 싶을 때 사용하는 클래스이다.
    - 사용법: Comparator 클래스를 생성하여, 내부에 compare메서드를 원하는 정렬 기준대로 구현하여 사용할 수 있다.
    - 패키지: java.util.Comparator
    - 주로 익명클래스(new Comparator(){ ... })로 사용되며, 기본적으로 오름차순이 정렬 기준인 것을 내림차순으로 정렬하는 등의 용도로 사용된다.

[정렬] Comparable과 Comparator
https://m.blog.naver.com/occidere/220918234464
*/

/*
자바 Comparable Comparator
https://www.google.com/search?q=%EC%9E%90%EB%B0%94+Comparable+Comparator&sxsrf=ALeKk03160k4TWTA1soLbzUoKsJwQD0qVw%3A1618942455463&ei=9xl_YP_vG87X-QbWgLyIDw&oq=%EC%9E%90%EB%B0%94+Comparable+Comparator&gs_lcp=Cgdnd3Mtd2l6EAMyAggAMgIIADoHCCMQsAMQJzoFCAAQsAM6BwgAELADEB46CQghEAoQoAEQKjoFCAAQzQJQ-xBY0R1g3yBoAXAAeACAAbQBiAHFBJIBAzAuNJgBAKABAqABAaoBB2d3cy13aXrIAQrAAQE&sclient=gws-wiz&ved=0ahUKEwi_x-DPto3wAhXOa94KHVYAD_EQ4dUDCA4&uact=5

[Java] Comparable와 Comparator의 차이와 사용법
https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html

[정렬] Comparable과 Comparator
https://m.blog.naver.com/occidere/220918234464

[Java] 객체 정렬하기 1부 - Comparable vs Comparator
https://www.daleseo.com/java-comparable-comparator/
 */







































































