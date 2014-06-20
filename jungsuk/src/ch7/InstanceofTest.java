package ch7;

public class InstanceofTest {

	public static void main(String[] args) {
		FireEngine fe = new FireEngine();

		if (fe instanceof Car) {
			System.out.println("This ia FireEngine instance.");
		}
		if (fe instanceof Car) {
			System.out.println("this is a Car instance.");
		}
		if (fe instanceof Object) {
			System.out.println("this is an Object instace.");
		}

	}
}

class Car2 {
}

class FireEngine2 extends Car2 {
}
