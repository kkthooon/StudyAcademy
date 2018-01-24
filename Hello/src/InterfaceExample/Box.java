package InterfaceExample;

public class Box implements Comparable{
	private double volume = 0;

	public Box(double v) {
		volume = v;
	}
	//��üȭ �� �޼ҵ�
	public int compareTo(Object otherObject) {
		Box other = (Box) otherObject; //otherObject�� type�� Object, ������ (Box)�� ����Ͽ� ��������ȯ
		if(this.volume < other.volume) //other.volume�� ���� ���� volume, this.volume�� ���� Ŭ���� ���� volume
			return -1;
		else if(this.volume > other.volume)
			return 1;
		else
			return 0;
	}
	public static void main(String[] args) {
		Box b1 = new Box(100); //volume 100�� Box ����, this
		Box b2 = new Box(85.0); //volume 85�� Box ����, other
		if(b1.compareTo(b2) > 0)
			System.out.println("b1�� b2���� �� ũ��");
		else
			System.out.println("b1�� b2�� ���ų� �۴�");
	}
}
