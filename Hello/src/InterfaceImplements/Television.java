package InterfaceImplements;

public class Television implements SerialCommunication, RemoteControl, Print {
	
	//private byte[] data;
	public void turnOn() {
		System.out.println("Ƽ�� ON");
	}
	public void turnOff() {
		System.out.println("Ƽ�� OFF");
	}
	public void send(byte[] data) {
		System.out.println("data: " + data);
	}
	public byte[] receive() {
		return null;
	}
	public void print() {
		System.out.println("implements SerialCommunication, RemoteControl, Print");
	}
}
