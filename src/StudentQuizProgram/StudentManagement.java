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
    
    /** 처음 화면 */
    public void MenuPrint() {
    	System.out.println("=== 퀴즈 프로그램 ===");
    	System.out.println("1) 회원가입");
    	System.out.println("2) 로그인");
    	System.out.println("3) 프로그램 종료");
    	System.out.println("==================");
    	System.out.print(": ");
    	FirstSelect(); //번호 선택
    }
    
    /** 1) 회원 가입 */ 
    public void StudentAdd() {
    	BufferedWriter bw = null;
        
    	try {
    		bw = new BufferedWriter(new FileWriter(outFile, true)); //txt파일에 저장을 위해
         
    		System.out.print("이름: ");
    		String name = scan.next();
    		bw.write(name + " ");
 
    		System.out.print("나이: ");
    		int age = scan.nextInt();
    		bw.write(age + " ");
         
    		System.out.print("폰번호: ");
    		String phoneNum = scan.next();
    		bw.write(phoneNum + " ");
         
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
    	System.out.println(">> 가입을 축하합니다!");
    	MenuPrint(); //처음 화면 실행
    	FirstSelect(); //번호 선택 실행
    }
    
    /** 2) 로그인 */
    public void Login() {
    	BufferedReader br = null;
  
    	System.out.print("이름: ");
    	String name = scan.next();
    	
    	System.out.print("패스워드: ");
    	String password = scan.next();
    	
    	try {
    		br = new BufferedReader(new FileReader(inFile));
            String line;
            
            while ((line = br.readLine()) != null) { //txt파일 한줄씩 읽기
            	StringTokenizer strToken  = new StringTokenizer(line," "); //공백 기준으로 자르기
            	ArrayList<String> tokenArray = new ArrayList<String>(); //token Arraylist 생성
            	while (strToken.hasMoreTokens()){
            		tokenArray.add(strToken.nextToken()); //다음 토큰 추가
            	}
            	String idName = tokenArray.get(0); //이름 부분
            	String isPassword = tokenArray.get(3); //비밀번호 부분
            	Student student = new Student(idName, isPassword);
            	list.add(student); //student Arraylist에 저장
            }
            boolean isFind = false; //같은 이름과 비밀번호를 찾기 전에는 false
        	for(int i = 0; i < list.size(); i++) { //student list에서 로그인시 입력한 이름과 패스워드가 일치하는지 확인
        		if(list.get(i).getName().equals(name) && list.get(i).getPassword().equals(password)) {
        			isFind = true; //같으면 true
        			loginStudent = list.get(i);
        		} 
        	}
        	if(isFind) { //이름과 비밀번호 일치하면 로그인 성공 메시지
        		System.out.println(">> " + name + " 님 로그인 성공!");
        		Play quiz = new Play(loginStudent); //퀴즈 메뉴 실행
        		quiz.showMenu();
        	} else { //아이디와 비밀번호가 일치하지 않으면 메시지 출력 후 처음 화면 실행
    			System.out.println(">> 이름/PW가 틀렸습니다");
    			MenuPrint();
    		}
    	} catch (FileNotFoundException e) {
    		System.out.println(">> 파일을 찾을 수 없습니다");
    		System.exit(0);
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
            if(br != null) try {br.close(); } catch (IOException e) {}
        }
        
    }
    
    /** 번호 선택 */
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
				System.out.println(">> 프로그램을 종료합니다");
				System.exit(0);
				break;
			default:
				throw new InputMismatchException();
			}		
		} catch (InputMismatchException e) {
			System.out.println(">> 잘못 입력하셨습니다!");
			scan.nextLine();
			MenuPrint(); //처음 화면 실행
		}
	}
}  
