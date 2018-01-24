package InterfaceImplements;

public class InterfaceImp {

	public static void main(String[] args) {
		SmartPhone ph = new SmartPhone();
		ph.showPrice();
		ph.turnOn();
		ph.turnOff();
		ph.print();
		
		System.out.println("-----------------------------------------------------");
		
		Television tv = new Television();
		tv.turnOn();
		tv.turnOff();
		tv.send(null);
		tv.receive();
		tv.print();
	}

}
