package StudentQuizProgram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Play {
	private int result = 0; //맞은개수 저장.
	private String menuString; //메뉴 항목
	private int qTotalOuput; //출력 퀴즈 수
	private QuizDataDAO quizData; //문제들을 저장하는 ArrayList
	private ArrayList<QuizResult> resultArray = new ArrayList<>();
	private Student currentUser; //현재 로그인한 학생 이름
	
	//생성자
	public Play(Student student) {
		this(6); //퀴즈 출력개수는 디폴트 6개
		currentUser = student; //현재 로그인한 학생 이름
	}
	public Play(int size) {
		quizData = new QuizDataDAO(); //객체 생성
		qTotalOuput = size; //퀴즈 출력 수
	}
	
	/**메뉴 보여주기*/
	public void showMenu(){
		Scanner scan = new Scanner(System.in);
		String[] menuStringList = new String[]{"시사", "상식", "스포츠", "난센스"}; //문제 목록
		boolean[] finishedList = new boolean[4]; //풀었는지 여부 확인을 위한 것
		
		while (true) {
			System.out.println("\n=== Mini Quiz Start ===");
			for(int i = 0; i < menuStringList.length; i++) {
				if(finishedList[i] == true)
					continue; //문제를 풀면 해당 문제는 true이후 계속 진행
				System.out.println(i + 1 + ") " + menuStringList[i]);
			}
			System.out.println("5) 종료 ");
			System.out.print("=== 메뉴를 선택해주세요 ===\n: ");

			try {
				int key = scan.nextInt();           
				switch (key) { //메뉴를 입력받는다
				case 1: case 2: case 3: case 4:
					if(finishedList[key-1] == true) //풀었던 문제 제외 
						break; //다 풀면 종료
					System.out.println(">> " + key + "번 메뉴를 선택하였습니다");
					menuString = menuStringList[key-1];
					if(quizData.loadQuiz(key)) //입력 값에 해당되는 문제
						continue;  
					//해당 항목의 퀴즈 파일을 로드후 Arraylist에 저장
					//파일이 없을 경우 아래 문장을 실행하지 않고 다시 메뉴 화면으로
					startQuiz(); //퀴즈 시작
					finishedList[key-1] = true; //퀴즈 끝나면 해당 문제는 true로 바꿈
					System.out.println(">> 아무키나 누르기 전에 풀었던 " + key + "번 문제는 선택하지 마시오");
					System.out.println(">> 메뉴 선택을 위해 아무키나 누르시오");
					scan.nextLine();
					scan.nextLine();
					break;
				case 5:
					StudentManagement manage = new StudentManagement();
					System.out.println(">> 처음 화면으로 이동합니다");
					manage.MenuPrint(); //처음 화면 출력
					break;
				default:            
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println(">> 잘못 입력하셨습니다");
				scan.nextLine();
			}
		}
	}
	
	/**퀴즈 시작*/
	private void startQuiz() {
		System.out.println("# 퀴즈를 시작합니다!");
		Scanner scan = new Scanner(System.in);
		
		if(qTotalOuput > quizData.size())
			qTotalOuput = quizData.size();
		for (int i = 0; i < qTotalOuput; i++) {
			QuestionDTO qDTO = quizData.get(i); //Arraylist에 저장된 문제를 가지고 온다
			String question = qDTO.getQuestion(); //문제
			String answer = qDTO.getAnswer(); //정답

			System.out.println((i + 1) + ") " + question); //문제 출력
			String user_Answer = scan.nextLine(); //답 입력

			if (answer.equals(user_Answer) && i != qTotalOuput - 1) { //문제의 답과 학생의 답이 일치할 경우
				System.out.print("# 다음 문제입니다");
				System.out.println();
				result++;
			} else { //일치하지 않을 때
				if(i != qTotalOuput - 1) {
					System.out.print("# 다음 문제입니다");
					System.out.println();
				}		
			}
		}
		System.out.println("# 퀴즈를 다 풀었습니다");
		quizData.clear(); //퀴즈데이터 초기화
		showResult(); //결과 출력
		result = 0; //문제 다 풀면 결과값 초기화
		
	}
	
	/**게임 결과 보기*/
	public void showResult(){
		File outFile = new File("C:\\Users\\green201-11\\Desktop\\StudentQuiz", "Result.txt");
		
		//==========================//
		// 텍스트 파일 쓰기
		//==========================//
		BufferedWriter bw = null;
		
		double score = result*(100.0/qTotalOuput); //점수
		
		QuizResult quizResult = new QuizResult();
		quizResult.menuString = menuString;
		quizResult.qTotalOuput = qTotalOuput;
		quizResult.result = result;
		quizResult.score = score;
		
		resultArray.add(quizResult);
		
		try {
			bw = new BufferedWriter(new FileWriter(outFile, true));
			bw.write(">> " + currentUser.getName() + "님의 성적");
			bw.newLine();
			bw.write("=== Mini Quiz Result ===");
			bw.newLine();
			bw.write("종  목 : "+ menuString);
			bw.newLine();
			bw.write("문제 수 : "+ qTotalOuput);
			bw.newLine();
			bw.write("정답 수 : "+ result);
			bw.newLine();
			bw.write("점  수 : "+ score);
			bw.newLine();
			bw.write("=======================");
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) try {bw.close(); } catch (IOException e) {}
		}
		
		/** 문제 풀고 결과 출력 */
		System.out.println("=== Mini Quiz Result ===");
		System.out.println("종  목 : "+ menuString);
		System.out.println("문제 수 : "+ qTotalOuput);
		System.out.println("정답 수 : "+ result);
		System.out.printf("점  수 : %.1f 점\n", result * (100.0/qTotalOuput));
		System.out.println("========================");
	}
	
}