package CarManage;

public class Car {
	//3���� �ʵ� ����
	public int speed;
	public int gear;
	public String color;
	
	//��� ���� �޼ҵ�
	public void setGear(int newGear) {
		gear = newGear;
	}
	//�ӵ� ���� �޼ҵ�
	public void speedUp(int increment) {
		speed += increment;
	}
	//�ӵ� ���� �޼ҵ�
	public void speedDown(int decrement) {
		speed -= decrement;
	}
}

//Car�� ��� �޴´�
class SportsCar extends Car {
	boolean turbo;
	
	//�ͺ� ��� ���� �޼ҵ�
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
			System.out.println("�ͺ� O");
		} else {
			System.out.println("�ͺ� X");
		}
		System.out.println("���: " + gear);
		System.out.println("�ӵ�: " + speed);
	}
}

class SUVCar extends Car {
	boolean sunroof;
	
	public void setSunroof(boolean newValue) {
		sunroof = newValue;
	}
		
	public void print() {
		
		System.out.println("������ " + color);
		System.out.println("���: " + gear);
		System.out.println("�ӵ�: " + speed);
		if(sunroof) {
			System.out.println("������ ����: Yes");
		} else {
			System.out.println("������ ����: No");
		}
		
	}
}