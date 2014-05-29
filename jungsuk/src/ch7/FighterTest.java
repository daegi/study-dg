package ch7;

public class FighterTest {

	public static void main(String[] args) {

	}

}

class Unit {
	int currentHP;
	int x;
	int y;
}

interface Fightable extends Movable, Attackable {

}

interface Movable {

	void move(int x, int y);

}

interface Attackable {
	void attack(Unit u);
}

/*class Fighter extends Unit implements Fightable {
	public void move(int x, int y) {

	}

	public void dattack(Unit u) {

	}
}
*/