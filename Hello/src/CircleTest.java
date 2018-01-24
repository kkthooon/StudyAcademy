class Point {
	private int x, y;
	
	//생성자
	public Point(int a, int b) {
		x = a;
		y = b;
	}
	public void print() {
		System.out.println("x= " + x + ", y= " + y);
	}
}

class Circle {
	private int radius = 0;
	private Point center;
	
	//생성자
	public Circle(Point p, int r) {
		center = p;
		radius = r;
	}
	public void print() {
		center.print();
		System.out.println("radius= " + radius);
	}
}

public class CircleTest {

	public static void main(String[] args) {
		
		//Circle 객체 생성하고 초기화
		Point p = new Point(25, 78);
		Circle c = new Circle(p, 10);

		c.print();
	}

}
