package StudentManage;

public class Student {

	private String name;
	private int age;
	private boolean gender;
	private String residence;
	private String university;
	
	public Student() {

	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public boolean getGender() {
		return gender;
	}
	public String getResidence() {
		return residence;
	}
	public String getUniversity() {
		return university;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public void setUniversity(String university) {
		this.university = university;
	}

	void print() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);

		if(gender) {
			System.out.println("성별: 남성");
		} else {
			System.out.println("성별: 여성");
		}
		System.out.println("거주지: " + residence);
		System.out.println("학교: " + university);
	}
}