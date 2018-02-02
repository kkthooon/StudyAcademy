package StudentQuizProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class StudentManagement{
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> list = new ArrayList<Student>();
	File inFile = new File("C:\\Users\\green201-11\\Desktop\\StudentQuiz", "Management.txt");
    File outFile = new File("C:\\Users\\green201-11\\Desktop\\StudentQuiz", "Management.txt");
    Student loginStudent;
    
    public StudentManagement() {

    }
    
    /** ó�� ȭ�� */
    public void MenuPrint() {
    	System.out.println("=== ���� ���α׷� ===");
    	System.out.println("1) ȸ������");
    	System.out.println("2) �α���");
    	System.out.println("3) ���α׷� ����");
    	System.out.println("==================");
    	System.out.print(": ");
    	FirstSelect(); //��ȣ ����
    }
    
    /** 1) ȸ�� ���� */ 
    public void StudentAdd() {
    	BufferedWriter bw = null;
        
    	try {
    		bw = new BufferedWriter(new FileWriter(outFile, true)); //txt���Ͽ� ������ ����
         
    		System.out.print("�̸�: ");
    		String name = scan.next();
    		bw.write(name + " ");
 
    		System.out.print("����: ");
    		int age = scan.nextInt();
    		bw.write(age + " ");
         
    		System.out.print("����ȣ: ");
    		String phoneNum = scan.next();
    		bw.write(phoneNum + " ");
         
    		System.out.print("�н�����: ");
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
    	System.out.println(">> ������ �����մϴ�!");
    	MenuPrint(); //ó�� ȭ�� ����
    	FirstSelect(); //��ȣ ���� ����
    }
    
    /** 2) �α��� */
    public void Login() {
    	BufferedReader br = null;
  
    	System.out.print("�̸�: ");
    	String name = scan.next();
    	
    	System.out.print("�н�����: ");
    	String password = scan.next();
    	
    	try {
    		br = new BufferedReader(new FileReader(inFile));
            String line;
            
            while ((line = br.readLine()) != null) { //txt���� ���پ� �б�
            	StringTokenizer strToken  = new StringTokenizer(line," "); //���� �������� �ڸ���
            	ArrayList<String> tokenArray = new ArrayList<String>(); //token Arraylist ����
            	while (strToken.hasMoreTokens()){
            		tokenArray.add(strToken.nextToken()); //���� ��ū �߰�
            	}
            	String idName = tokenArray.get(0); //�̸� �κ�
            	String isPassword = tokenArray.get(3); //��й�ȣ �κ�
            	Student student = new Student(idName, isPassword);
            	list.add(student); //student Arraylist�� ����
            }
            boolean isFind = false; //���� �̸��� ��й�ȣ�� ã�� ������ false
        	for(int i = 0; i < list.size(); i++) { //student list���� �α��ν� �Է��� �̸��� �н����尡 ��ġ�ϴ��� Ȯ��
        		if(list.get(i).getName().equals(name) && list.get(i).getPassword().equals(password)) {
        			isFind = true; //������ true
        			loginStudent = list.get(i);
        		} 
        	}
        	if(isFind) { //�̸��� ��й�ȣ ��ġ�ϸ� �α��� ���� �޽���
        		System.out.println(">> " + name + " �� �α��� ����!");
        		Play quiz = new Play(loginStudent); //���� �޴� ����
        		quiz.showMenu();
        	} else { //���̵�� ��й�ȣ�� ��ġ���� ������ �޽��� ��� �� ó�� ȭ�� ����
    			System.out.println(">> �̸�/PW�� Ʋ�Ƚ��ϴ�");
    			MenuPrint();
    		}
    	} catch (FileNotFoundException e) {
    		System.out.println(">> ������ ã�� �� �����ϴ�");
    		System.exit(0);
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
            if(br != null) try {br.close(); } catch (IOException e) {}
        }
        
    }
    
    /** ��ȣ ���� */
	public void FirstSelect() {			
		try {
			int inputNum = scan.nextInt();
				
			switch(inputNum) {
			case 1:
				StudentAdd();
				break;
			case 2:
				Login();
				break;
			case 3:
				System.out.println(">> ���α׷��� �����մϴ�");
				System.exit(0);
				break;
			default:
				throw new InputMismatchException();
			}		
		} catch (InputMismatchException e) {
			System.out.println(">> �߸� �Է��ϼ̽��ϴ�!");
			scan.nextLine();
			MenuPrint(); //ó�� ȭ�� ����
		}
	}
}  
