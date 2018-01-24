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
			System.out.println("�� �̻� �Է��� �� �����ϴ�");
			return;
		}

		System.out.println("�л� ������ �Է��Ͻÿ�");

		Scanner scan = new Scanner(System.in);

		//��ü ����
		Student student = new Student();

		//���� �Է�
		System.out.print("�̸�: ");
		String name = scan.next();
		student.setName(name);
		
		System.out.print("����: ");
		int age = scan.nextInt();
		student.setAge(age);
		
		System.out.print("����(M or F): ");
		String gender = scan.next();
		
		if(gender.equals("M")) {
			student.setGender(true);
		} else if(gender.equals("F")) {
			student.setGender(false);
		} else {
			System.out.println("M �Ǵ� F�� �Է��Ͻÿ�\n------------------");
			addStudent();
			return;
		}
		
		System.out.print("������: ");
		String residence = scan.next();
		student.setResidence(residence);
		
		System.out.print("�б�: ");
		String university = scan.next();
		student.setUniversity(university);
		
		System.out.println("�Է��� �Ϸ�Ǿ����ϴ�.");
		studentArray[currentNumber] = student;
		currentNumber++;
		System.out.printf("�� <%d>�� ��ϵǾ� �ֽ��ϴ�.\n", currentNumber );
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
			System.out.println("(" + (i + 1) + ")�� �л�����");
			studentArray[i].print();
		}
	}
}
