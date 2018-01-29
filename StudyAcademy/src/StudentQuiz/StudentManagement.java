package StudentQuiz;

public class StudentManagement {
	
	private String name; //학생 이름
	private int age; //학생 나이
	private boolean gender; //학생 성별
	private String phone; //학생 폰번호
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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






















	public boolean isGender() {
		return gender;
	}






















	public void setGender(boolean gender) {
		this.gender = gender;
	}






















	public String getPhone() {
		return phone;
	}






















	public void setPhone(String phone) {
		this.phone = phone;
	}






















	public void FirstPrint() {
		
		System.out.println("==================");
		System.out.println("   1.회원등록");
		System.out.println("   2.로그인");
		System.out.println("   3.프로그램 종료");
		System.out.println("==================");
	}
}
