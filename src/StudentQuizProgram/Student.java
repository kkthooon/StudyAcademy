package StudentQuizProgram;

public class Student {
	private String name; //�̸�
	private int age; //����
	private int phoneNum; //����ȣ
	private String password; //�н�����
	
	public Student(String idName, String isPassword) {
		this.name = idName;
		this.password = isPassword;
	}
	public Student(String name, int age, int phoneNum, String password) {
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
} 