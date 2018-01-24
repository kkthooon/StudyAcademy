package StudentManage;
import java.util.Scanner;

public class StudentManager {
	static final int MAX_PEOPLE = 20;
	private Student[] studentArray;
	private int currentNumber;
	
	public StudentManager() {
		studentArray = new Student[MAX_PEOPLE];
		currentNumber = 0;
	}

	public StudentManager(int size) {
		studentArray = new Student[size];
		currentNumber = 0;
	}

	public void addStudent() {

		if(studentArray.length == currentNumber) {
			System.out.println("더 이상 입력할 수 없습니다");
			return;
		}

		System.out.println("학생 정보를 입력하시오");

		Scanner scan = new Scanner(System.in);

		//객체 생성
		Student student = new Student();

		//정보 입력
		System.out.print("이름: ");
		String name = scan.next();
		student.setName(name);
		
		System.out.print("나이: ");
		int age = scan.nextInt();
		student.setAge(age);
		
		System.out.print("성별(M or F): ");
		String gender = scan.next();
		
		if(gender.equals("M")) {
			student.setGender(true);
		} else if(gender.equals("F")) {
			student.setGender(false);
		} else {
			System.out.println("M 또는 F를 입력하시오\n------------------");
			addStudent();
			return;
		}
		
		System.out.print("거주지: ");
		String residence = scan.next();
		student.setResidence(residence);
		
		System.out.print("학교: ");
		String university = scan.next();
		student.setUniversity(university);
		
		System.out.println("입력이 완료되었습니다.");
		studentArray[currentNumber] = student;
		currentNumber++;
		System.out.printf("총 <%d>명 등록되어 있습니다.\n", currentNumber );
	}
	
	public void findAndPrint(String name) {
		for(int i = 0; i < currentNumber; i++) {
			if(name.equals(studentArray[i].getName())) {
				studentArray[i].print();
				return;
			}
		}
	}
	
	public void printAll() {
		for(int i = 0; i < currentNumber; i++) {
			System.out.println("(" + (i + 1) + ")번 학생정보");
			studentArray[i].print();
		}
	}
}
