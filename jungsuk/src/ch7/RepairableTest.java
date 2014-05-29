/*package ch7;

public class RepairableTest {

	public static void main(String[] args) {
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		Marine marine= new Marine();
		SCV scv= new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
		scv.repair(marine);

	}
}

interface Repairable {
}

// 그룹유닛
class GroundUnit extends Unit {
	GroundUnit(int hp) {
		super(hp);
	}
}

// 에어유닛
class AirUnit extends Unit {
	AirUnit(int hp) {
		super(hp);
	}
}

// 유닛 hp
class Unit {
	int hitPoint;
	final int MAX_HP;
	
	Unit(int hp) {
		MAX_HP = hp;
	}
}

// 탱크는 그룹 유닛 상속 받는다.
class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Tank";
	}
}

// 드랍쉽은 공중유닛 상속 받는다.
class Dropship extends AirUnit implements Repairable {
	Dropship() {
		super(125);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Dropship";
	}

}
// 마린은 그룹유닛 상속 받는다.
class Marine extends GroundUnit {

	Marine() {
		super(40);
		hitPoint = MAX_HP;
	}
}

// scv는 그룹 유닛
class SCV extends GroundUnit implements Repairable {

	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}
	
	//리페어 메소드 
	void repair(Repairable r) {
		if (r instanceof Unit) {
			Unit u = (Unit) r; // 다운 캐스팅
			while(u.hitPoint != u.MAX_HP){
				u.hitPoint++;
			}
			System.out.println(u.toString()+"의 수리가 끝났습니다.");
		}

	}
}*/