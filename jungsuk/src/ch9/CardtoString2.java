package ch9;

public class CardtoString2 {

	public static void main(String[] args) {
		Card001 c = new Card001("HEART",1);
		
		System.out.println(c.toString());

	}

}

class Card001 {
	String kind;
	int number;

	Card001() {
		this("SPADE", 1);
	}

	Card001(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	public String toString() {
		return "kind :" + kind + ", number :" + number;
	}
}