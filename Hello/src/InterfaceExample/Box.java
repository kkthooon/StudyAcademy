package InterfaceExample;

public class Box implements Comparable{
	private double volume = 0;

	public Box(double v) {
		volume = v;
	}
	//구체화 된 메소드
	public int compareTo(Object otherObject) {
		Box other = (Box) otherObject; //otherObject의 type은 Object, 하지만 (Box)를 사용하여 강제형변환
		if(this.volume < other.volume) //other.volume은 전달 받은 volume, this.volume은 현재 클래스 내에 volume
			return -1;
		else if(this.volume > other.volume)
			return 1;
		else
			return 0;
	}
	public static void main(String[] args) {
		Box b1 = new Box(100); //volume 100인 Box 생성, this
		Box b2 = new Box(85.0); //volume 85인 Box 생성, other
		if(b1.compareTo(b2) > 0)
			System.out.println("b1이 b2보다 더 크다");
		else
			System.out.println("b1가 b2와 같거나 작다");
	}
}
