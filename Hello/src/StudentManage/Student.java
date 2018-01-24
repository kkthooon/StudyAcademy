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
		System.out.println("�̸�: " + name);
		System.out.println("����: " + age);

		if(gender) {
			System.out.println("����: ����");
		} else {
			System.out.println("����: ����");
		}
		System.out.println("������: " + residence);
		System.out.println("�б�: " + university);
	}
}