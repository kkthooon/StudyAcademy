package InterfaceImplements;

public class Television implements SerialCommunication, RemoteControl, Print {
	
	//private byte[] data;
	public void turnOn() {
		System.out.println("티비 ON");
	}
	public void turnOff() {
		System.out.println("티비 OFF");
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
