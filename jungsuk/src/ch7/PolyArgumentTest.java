package ch7;

public class PolyArgumentTest {

	public static void main(String[] args) {

		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		
		b.buy(tv);
		b.buy(com);
		
		System.out.println("�����ݾ�"+b.money);
		System.out.println("���ʽ�����Ʈ"+b.bonusPoint);

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

// Ƽ�� ��ǰ, ���ݿ� ���� Ŭ����
class Tv extends Product {
	Tv() {
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

// ��ǻ�� ��ǰ, ���ݿ� ���� Ŭ����
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
			System.out.println("�ܾ��� �����Ͽ� ������ ��� ����.");
			return;
		}

		money = money - p.price;
		bonusPoint = bonusPoint + p.bonusPoint;
		System.out.println(p + "��/�� �����߾�");
	}
}
