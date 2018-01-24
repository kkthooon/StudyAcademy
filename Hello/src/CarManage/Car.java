package CarManage;

public class Car {
	//3개의 필드 선언
	public int speed;
	public int gear;
	public String color;
	
	//기어 설정 메소드
	public void setGear(int newGear) {
		gear = newGear;
	}
	//속도 증가 메소드
	public void speedUp(int increment) {
		speed += increment;
	}
	//속도 감소 메소드
	public void speedDown(int decrement) {
		speed -= decrement;
	}
}

//Car를 상속 받는다
class SportsCar extends Car {
	boolean turbo;
	
	//터보 모드 설정 메소드
	public void setTurbo(boolean newValue) {
		turbo = newValue;
	}
	
	@Override
	public void setGear(int newGear) {
		gear = newGear;
	}
	
	@Override
	public void speedUp(int increment) {
		speed += 2 * increment;
	}
	
	@Override
	public void speedDown(int decrement) {
		speed -= 2 * decrement;
	}
	
	public void print() {
		if(turbo) {
			System.out.println("터보 O");
		} else {
			System.out.println("터보 X");
		}
		System.out.println("기어: " + gear);
		System.out.println("속도: " + speed);
	}
}

class SUVCar extends Car {
	boolean sunroof;
	
	public void setSunroof(boolean newValue) {
		sunroof = newValue;
	}
		
	public void print() {
		
		System.out.println("색깔은 " + color);
		System.out.println("기어: " + gear);
		System.out.println("속도: " + speed);
		if(sunroof) {
			System.out.println("선루프 장착: Yes");
		} else {
			System.out.println("선루프 장착: No");
		}
		
	}
}