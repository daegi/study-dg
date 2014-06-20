package ch7;

public class PolyArgumentTest {

	public static void main(String[] args) {

		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		
		b.buy(tv);
		b.buy(com);
		
		System.out.println("남은금액"+b.money);
		System.out.println("보너스포인트"+b.bonusPoint);

	}

}

class Product {
	int price;
	int bonusPoint;

	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
}

// 티비 제품, 가격에 대한 클래스
class Tv extends Product {
	Tv() {
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

// 컴퓨터 제품, 가격에 대한 클래스
class Computer extends Product {
	Computer() {
		super(200);
	}

	public String toStirng() {
		return "computer";
	}
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살수 없다.");
			return;
		}

		money = money - p.price;
		bonusPoint = bonusPoint + p.bonusPoint;
		System.out.println(p + "을/를 구입했엉");
	}
}
