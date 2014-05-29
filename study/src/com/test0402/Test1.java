package com.test0402;

public class Test1 {

	public static void main(String[] args) {
		// 객체생성(메모리 할당)
		// 클래스 객체명 = new 클래스();
		
		Ex1 ob=new Ex1();
		Ex1 ob1=new Ex1();
		
		//클래스이름@ 해쉬코드값
		System.out.println(ob);
		System.out.println(ob1);
		// 해쉬코드: jvm이 내부적으로검색을 위해 사용
		// 객체가 다르면 해쉬코드는 다르지만
		// 해쉬코드가 다르다고 다른 객체는 아님
		
		//private 외부에서 접근불가
		//ob.money =10; 을 쓰면 에러
		
		ob.name ="홍길동";
		//Ex1.name="테스트" -->에러
		//인스턴스변수나 인스턴스 메소드는 객체를 생성해야 접근가능함
		
		ob.saving(100);
		
		System.out.println(ob.getMoney());
		System.out.println(ob1.getMoney());
		
		

	}
}

class Ex1 {
	// 필드(인스턴수 변수) :상태 저장
	// 필드를 초기화 하지 않으면 숫자형은 0, 객체는 null로 초기화 된다.
	private int money; // 외부접근불가
	String name; // 동일 패키지만 접근 가능

	//에러:선언부로 실행문이 올수는 없다.
	//System.out.println("안되요....");
	
	
	public int getMoney(){
		return money;
	}
	
	
	
	// 인스턴스메소드(메모리 할당을..) : 행동
	public void saving(int m) {
		money += m;
		return; //void 인경우 return 생략 가능
				//return 을 만나면 실행을 멈추고 호출한곳으로
				//복귀
	}

	public int draw(int m) {
		if (m > money)
			return 0;
			money -= m;
		return m; 	//int 메소드이므로 return 생량 불가능
		// m=0; //에러. return 아래부분을 실행불가능 하므로
	}
}


/*추상화
데이터: 인원수, 성적처리용(5)
기능 입력(총점,평균), 검색, 출력


*/