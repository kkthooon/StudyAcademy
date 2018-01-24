package CarManage;
public class CarProg {

	public static void main(String[] args) {
		//서브클래스 객체 생성
		SportsCar c = new SportsCar();
		
		c.color = "Red";
		c.setGear(3);
		c.speedUp(100);
		c.speedDown(20);
		c.setTurbo(true);
		c.print();
		
		
		System.out.println("--------------");
		
		SUVCar s = new SUVCar();
		
		s.color = "Red";
		s.setGear(3);
		s.speedUp(100);
		s.speedDown(20);
		s.setSunroof(true);
		s.print();

	}
}
