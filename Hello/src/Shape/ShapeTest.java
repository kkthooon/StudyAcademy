package Shape;

public class ShapeTest {

	public static void main(String[] args) {
		Rectangle rtg = new Rectangle();
		rtg.draw();
		
		Circle c = new Circle();
		c.draw();
		
		rtg.move(2, 2);
		rtg.print();
		
		c.move(2, 2);
		c.print();
		
	}

}
