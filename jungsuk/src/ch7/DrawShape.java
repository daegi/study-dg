package ch7;

public class DrawShape {

	public static void main(String[] args) {

	}

}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Point() {
		this(0, 0);
	}
}

class Circle {
	Point center; // 원점 좌표
	int r; // 반지름

	Circle() {
		this(new Point(0, 0), 100); //
	}

	Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
}

class Triangle {
	Point[] p = new Point[3];

	Triangle(Point[] p) {
		this.p = p;
	}

	Triangle(Point p1, Point p2, Point p3) {
		p[0] = p1;
		p[1] = p2;
		p[2] = p3;
	}
}