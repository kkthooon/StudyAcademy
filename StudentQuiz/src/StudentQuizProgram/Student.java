package StudentQuizProgram;

public class Student {
	private String name; //이름
	private int age; //나이
	private String phoneNum; //폰번호
	private String password; //패스워드
	
	public Student() {

	}
	public Student(String idName, String isPassword) {
		this.name = idName;
		this.password = isPassword;
	}
	public Student(String name, int age, String phoneNum, String password) {
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
	public String getphoneNum() {
		return phoneNum;
	}
	public void setphoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
