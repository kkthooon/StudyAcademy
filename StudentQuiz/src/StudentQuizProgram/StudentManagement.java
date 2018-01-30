package StudentQuizProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> list = new ArrayList<Student>();
	File inFile = new File("C:\\Users\\green201-11\\eclipse-workspace\\StudentQuiz", "management.txt");
    File outFile = new File("C:\\Users\\green201-11\\eclipse-workspace\\StudentQuiz", "management.txt");
	
	public void MenuPrint() {
		System.out.println("=== 퀴즈 프로그램 ===");
		System.out.println("   1. 회원가입");
		System.out.println("   2. 로그인");
		System.out.println("   3. 프로그램 종료");
		System.out.println("==================");
		System.out.print(": ");
		FirstSelect();
	}

	public void StudentAdd() {        
        BufferedWriter bw = null;
        
        try {
        	bw = new BufferedWriter(new FileWriter(outFile, true));
        	
        	System.out.print("이름: ");
        	String name = scan.next();
        	bw.write(name + "/");
        	
        	System.out.print("나이: ");
        	int age = scan.nextInt();
        	bw.write(age + "/");
        	
        	System.out.print("폰번호: ");
    		String phoneNum = scan.next();
    		bw.write(phoneNum + "/");
        	
    		System.out.print("패스워드: ");
    		String password = scan.next();
    		bw.write(password);
    		bw.newLine();
            bw.flush();
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
            if(bw != null)
            	try {bw.close();}
            catch (IOException e) {}
        }

		System.out.println("가입을 축하합니다!");
		MenuPrint();
		FirstSelect();
	}
	
	public void Login() {

		System.out.print("이름: ");
		String name = scan.next();
		
		System.out.print("패스워드: ");
		String password = scan.next();

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(name) && list.get(i).getPassword().equals(password)) {
				System.out.println(list.get(i).getName() + " 님 로그인 성공!");
				new Play().showMenu();
			} else {
				System.out.println("다시 확인해주세요");
				Login();
				break;
			}
		}
	}

	public void FirstSelect() {
		int inputNum = scan.nextInt();

		switch(inputNum) {

		case 1:
			StudentAdd();
			break;
		case 2:
			Login();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
			break;
		default:
			break;
		}
	}
} 
