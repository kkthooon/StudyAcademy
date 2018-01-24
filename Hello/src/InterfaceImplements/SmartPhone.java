package InterfaceImplements;

public class SmartPhone extends Device implements RemoteControl, Print {
	public void showPrice() {
		System.out.println("99¸¸¿ø");
	}
	public void turnOn() {
		System.out.println("Device ON");
	}
	public void turnOff() {
		System.out.println("Device OFF");
	}
	public void print() {
		System.out.println("extends Device implements RemoteControl, Print");
	}

}
