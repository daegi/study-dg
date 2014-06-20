package ch7;

public class PolyArgumentTest2 {

	public static void main(String[] args) {
		Buyer2 b = new Buyer2();
		Tv2 tv = new Tv2();
		Computer2 com = new Computer2();
		Audio2 audio = new Audio2();

	/*	b.buy2(tv);
		b.buy2(com);
		b.buy2(audio);
		b.summary2();
*/
	}

}

class Product2 {
	int price;
	int bonusPoint;

	Product2(int price) {
		this.price = price;
		bonusPoint = (int) (price / 1.0);
	}

	Product2() {
		price = 0;
		bonusPoint = 0;
	}
}

class Tv2 extends Product2 {
	Tv2() {
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

class Computer2 extends Product2 {

	Computer2() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Audio2 extends Product2 {
	Audio2() {
		super(50);
	}

	public String toString() {
		return "Audio";
	}
}

class Buyer2 {
	int money = 1000;
	int bonusPoint = 0;
	Product[] item = new Product[10];
	int i = 0;

	void buy2(Product p) {

		if (money < p.price) {
			System.out.println("�ܾ׺���");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
		System.out.println(p + "���� �߾�");
	}

	void summary2() {
		int sum = 0;
		String itemList = "";

		for (int i = 0; i < item.length; i++) {
			if (item[i] == null)
				break;
			sum = +item[i].price;
			itemList += item[i] + ", ";
		}

		System.out.println("�����Ͻ� ��ǰ�� �ѱݾ��� " + sum + "�����Դϴ�.");
		System.out.println("�����Ͻ� ��ǰ�� �ѱݾ��� " + itemList + "�����Դϴ�.");

	}
}