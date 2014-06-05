package com.calculato;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class A {
	protected Scanner scanner; // Scanner 준비
	protected ArrayList<Member1> list = new ArrayList<Member1>(); // Member
																	// ArrayList
																	// 생성
	private int no; // 클래스 내부에서 사용할 번호 미리 준비

	public A() { // 생성자에 추가할 값 준비
		scanner = new Scanner(System.in);
		/* * 다음처럼 매번 경로와 ';'를 입력하지 않고 연결해서 한 번에 값을 입력받을 수 있습니다. */
		list.add(new Member1().setName("홍길동").setPhone("111-2222")
				.setEmail("hong@test.com").setBlog("hong.blogspot.com")
				.setAge(20).setRegDate(new Date()));
		list.add(new Member1().setName("임꺽정").setPhone("111-3333")
				.setEmail("leem@test.com").setBlog("leem.blogspot.com")
				.setAge(30).setRegDate(new Date()));
		list.add(new Member1().setName("일지매").setPhone("111-4444")
				.setEmail("ill@test.com").setBlog("ill.blogspot.com")
				.setAge(40).setRegDate(new Date()));

	}

	private void add() { // 값을 더하는 인스턴스 메서드
		Member1 m = new Member1(); // Member 객체를 생성합니다.

		System.out.print("이름 : "); // 출력문
		m.setName(scanner.nextLine()); // 입력받은 값을 Member클래스의 name영역에 세팅합니다.

		System.out.print("전화번호 : "); // 출력문
		m.setPhone(scanner.nextLine()); // 입력받은 값을 Member클래스의 phone영역에 세팅합니다.

		System.out.print("이메일 : "); // 출력문
		m.setEmail(scanner.nextLine()); // 입력받은 값을 Member클래스의 email영역에 세팅합니다.

		System.out.print("블로그 : "); // 출력문
		m.setBlog(scanner.nextLine()); // 입력받은 값을 Member클래스의 blog영역에 세팅합니다.

		System.out.print("나이 : "); // 출력문
		m.setAge(Integer.parseInt(scanner.nextLine())); // 나이는 int값을 전달해야하기 때문에
														// 입력받은 문자를 int로 형변환.

		System.out.print("등록하시겠습니까?(y/n)");
		if (scanner.nextLine().toLowerCase().equals("y")) { // (입력받은 값이 소문자로
															// 인식됩니다. 그 값이
															// "y")이면
			m.setRegDate(new Date()); // 지금 날짜, 시간을 Member 클래스의 RegDate에 세팅
			list.add(m); // 배열에 m의 데이터 추가
			System.out.println("등록되었습니다!"); // 출력문
		} else {
			System.out.println("등록 취소하였습니다!"); // 출력문
		}
	}

	private void list() { // list 인스턴스 메서드 생성
		System.out.printf("%1$3s %2$10s %3$15s %4$30s\n", "번호", "이름", "전화",
				"이메일"); // printf에서 %s = 문자형

		for (int i = 0; i < list.size(); i++) {
			Member1 m = list.get(i);
		} // 위의 for문 보다 간결한 표현식
		int no = 1;
		for (Member1 m : list) {
			System.out.printf("%1$3d %2$10s %3$15s %4$30s\n", no++,
					m.getName(), m.getPhone(), m.getEmail()); // %d = 정수형, no로
																// 1씩 증가
		}
	}

	public void execute() { // 메인에서 호출하는 인스턴스 메서드
		while (true) { // while문을 사용해서 원하는 조건이 될 때 까지 반복하도록 합니다.
			System.out.print("명령>");
			String command = scanner.nextLine(); // command에 입력받은 값을 저장합니다.

			if (command.equals("add")) { // command값이 "add"와 같으면
				no = 0;
				add();
			} else if (command.equals("list")) { // 또는, command값이 "list"와 같으면
				no = 0;
				list();
			} else if (command.startsWith("view")) { // 또는, command값이 "view"와
														// 같으면
				String[] values = command.split(" ");
				no = Integer.parseInt(values[1]);
				view(no);
			} else if (command.equals("update")) { // 또는, command값이 "update"와
													// 같으면
				if (no > 0) {
					update();
				} else {
					System.out.println("먼저 멤버를 조회하세요!");
				}
			} else if (command.equals("delete")) { // 또는, command값이 "delete"와
													// 같으면
				if (no > 0) {
					detele();
				} else {
					System.out.println("먼저 멤버를 조회하세요!");
				}
			} else if (command.equals("quit")) { // 또는, command값이 "quit"와 같으면
				System.out.println("안녕!"); // "안녕!"을 출력하고
				break; // break로 while문을 빠져나와 프로그램을 종료
			}
		}
	}

	private void detele() {
		list.remove(no - 1);
		no = 0;
		System.out.println("삭제되었습니다!");
	}

	private void update() { // 업데이트 인스턴스 메서드 생성
		Member1 m = list.get(no - 1); // 인덱스번호는 0부터 시작되기 때문에 전달받은 no보다 1작은수입니다.
										// 그 인덱스 번호의 list정보를 Member에 준비합니다.
		Member1 copy = m.clone(); // Member의 clone을 copy합니다. clone은 Member클래스에
									// 존재합니다.
		System.out.printf("번호(%1$d):", no); // 해당 번호를 출력합니다.
		System.out.printf("이름(%1$s):", m.getName()); // 해당 이름을 출력합니다.

		String value = scanner.nextLine(); // 입력받은 값을 value에 저장합니다.
		if (value.length() > 0) { // value의 길이가 0보다 크면 명령문 실행. value에 값이 없으면 조건에
									// 만족하지 못해 명령문을 건너뜁니다.
			copy.setName(value); // 입력받은 값을 copy의 name영역에 저장합니다.
		}
		System.out.printf("전화(%1$s):", m.getPhone()); // 해당 전화번호를 출력합니다.
		value = scanner.nextLine(); // 입력받은 값을 value에 저장합니다.
		if (value.length() > 0) { // value의 길이가 0보다 크면 명령문 실행. value에 값이 없으면 조건에
									// 만족하지 못해 명령문을 건너뜁니다.
			copy.setPhone(value); // 입력받은 값을 copy의 phone영역에 저장합니다.
		}
		System.out.printf("이메일(%1$s):", m.getEmail()); // 해당 이메일을 출력합니다.
		value = scanner.nextLine(); // 입력받은 값을 value에 저장합니다.
		if (value.length() > 0) { // value의 길이가 0보다 크면 명령문 실행. value에 값이 없으면 조건에
									// 만족하지 못해 명령문을 건너뜁니다.
			copy.setEmail(value);
		}
		System.out.printf("블로그(%1$s):", m.getBlog()); // 해당 블로그를 출력합니다.
		value = scanner.nextLine(); // 입력받은 값을 value에 저장합니다.
		if (value.length() > 0) { // value의 길이가 0보다 크면 명령문 실행. value에 값이 없으면 조건에
									// 만족하지 못해 명령문을 건너뜁니다.
			copy.setBlog(value); // 입력받은 값을 copy의 blog영역에 저장합니다.
		}
		System.out.printf("나이(%1$d):", m.getAge()); // 해당 나이를 출력합니다.
		value = scanner.nextLine(); // 입력받은 값을 value에 저장합니다.
		if (value.length() > 0) { // value의 길이가 0보다 크면 명령문 실행. value에 값이 없으면 조건에
									// 만족하지 못해 명령문을 건너뜁니다.
			copy.setAge(Integer.parseInt(value)); // 입력받은 값을 copy의 age영역에 저장합니다.
		}

		System.out.print("변경하시겠습니까?(y/n)"); // 출력문
		if (scanner.nextLine().toLowerCase().equals("y")) { // 입력한 값은 무조건 소문자로
															// 인식(toLowerCase()),
															// 입력한 값이 "y"와 같으면
															// 조건
															// 성립(equals("y"))
			copy.setRegDate(new Date()); // 현재 시간, 날짜정보를 copy의 RegDate에 반영합니다.
			list.set(no - 1, copy); // no보다 1 작은수의 인덱스에 copy의 값을 list에 재정의합니다.
			System.out.println("변경되었습니다!"); // 출력문
		} else { // 위의 조건이 성립하지 않으면 실행
			System.out.println("변경 취소하였습니다!"); // 출력문
		}
	}

	private void view(int no) { // 정수값을 한 개 전달받는다. 받은 값을 로컬변수 int no에 저장한다.
		// 일부 정보를 보여주는 인스턴스 메서드
		if (no > 0 && no <= list.size()) { // 전달받은 no가 0보다 크거나, 리스트길이보다 작으면
			Member1 m = list.get(no - 1); // 인덱스번호는 0부터 시작하므로 -1
			System.out.println("번호:" + no);
			System.out.println("이름:" + m.getName());
			System.out.println("전화:" + m.getPhone());
			System.out.println("이메일:" + m.getEmail());
			System.out.println("블로그:" + m.getBlog());
			System.out.println("나이:" + m.getAge());
			System.out.printf("등록일:%1$tY-%1$tm-%1$td \n", m.getRegDate()); // printf를
																			// 사용해
																			// 한국식으로
																			// 날짜
																			// 표기를
																			// 쉽게
																			// 할
																			// 수
																			// 있습니다.
																			// 출력예)
																			// 1989-12-18
		} else {
			System.out.println("존재하지 않는 멤버의 번호입니다."); // 출력문
		}
	}

	public static void main(String[] args) { // 메인 메서드
		A app = new A(); // 해당 클래스의 객체를 만듭니다.
		app.execute(); // 해당 클래스의 execute메서드를 호출
	}
}

class Member1 {

	private String name;
	private String phone;
	private String email;
	private String blog;
	private int age;
	private Date regDate;

	// 해당 클래스의 영역에서 사용할 변수를 각 데이터타입을 명시하여 생성. Date는 import java.util.Date;를 해야
	// 사용할 수 있는 타입입니다.
	// * 소스 입력창에서 마우스 오른쪽을 클릭하여
	// [Source] - [Generate Getters and Setters]로 들어가 get, set을 원하는 변수명을 선택하면
	// 아래와 같은 결과를 얻을 수 있습니다.
	public String getName() {
		return name;
	}

	public Member1 setName(String name) {
		this.name = name;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Member1 setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Member1 setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getBlog() {
		return blog;
	}

	public Member1 setBlog(String blog) {
		this.blog = blog;
		return this;
	}

	public int getAge() {
		return age;
	}

	public Member1 setAge(int age) { // Member를 메서드의 데이터 타입으로 설정해 생성자를 만드는데 도움을
										// 줍니다.
		if (age > 0 && age < 120) { // 나이는 어느 정도의 제한이 있고, 병원처럼 회원의 나이에 영향을 미치는곳이
									// 많아 예민한 부분이기 때문에 값의 오류를 덜기 위해 범위를 지정하였습니다.
			this.age = age; // 전달받은 age값을 해당 클래스의 age변수에 대입합니다.
		}
		return this; // 값을 리턴합니다.
	}

	public Date getRegDate() {
		return regDate;
	}

	public Member1 setRegDate(Date regDate) {
		this.regDate = regDate;
		return this;
	}

	public Member1 clone() { // clone메서드를 Member 타입으로 설정합니다.
		Member1 m = new Member1();
		m.name = this.name; // 전달받은 값의 name을 m.name에 저장합니다.
		m.phone = this.phone;
		m.email = this.email;
		m.blog = this.blog;
		m.age = this.age;
		m.regDate = this.regDate;

		return m; // m값을 리턴합니다.
	}
}
