class Point {
	private int x, y;
	
	//������
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
	
	//������
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
		
		//Circle ��ü �����ϰ� �ʱ�ȭ
		Point p = new Point(25, 78);
		Circle c = new Circle(p, 10);

		c.print();
	}

}
