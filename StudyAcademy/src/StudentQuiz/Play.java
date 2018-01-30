package StudentQuiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Play {

	private int result = 0; //맞은개수 저장.
	private String menuString; //메뉴항목
	private int qTotalOuput; //출력 퀴즈수
	private QuizDataDAO quizData; //문제들을 저장하는 ArrayList

	//생성자
	public Play() {
		this(6); //퀴즈 출력개수는 디폴트 6개
	}   

	public Play(int size) {
		quizData = new QuizDataDAO();           
		qTotalOuput = size;
	}
	
	/**메뉴 보여주기*/
	public void showMenu(){
		Scanner scan = new Scanner(System.in);
		String[] menuStringList =new String[]{"시사","상식","스포츠","난센스"};
		boolean[] finishedList = new boolean[4];
		while (true) {
			System.out.println();
			System.out.println("===== Mini Quiz Start====");
			for(int i=0; i<menuStringList.length; i++) {
				if(finishedList[i]== true) continue;
				System.out.println(i+1 +") " + menuStringList[i]);
			}
			System.out.println("5) 종료 ");
			System.out.print("===메뉴를 선택해주세요===\n:");

			try {
				
				int key = scan.nextInt();    //메뉴를 입력받는다.            
				switch (key) {
				case 1: case 2: case 3: case 4:

					System.out.println(key + "번 메뉴를 선택하였습니다.");
					menuString = menuStringList[key-1];
					if(quizData.loadQuiz(key)) continue;  
					//해당항목의 퀴즈파일을 로드후 Arraylist에 저장
					//파일이 없을경우 아래문장을 실행하지 않고 다시 메뉴화면으로.

					startQuiz(); //퀴즈 시작
					finishedList[key-1] = true;
					System.out.println("메뉴를 보시려면 아무키나 눌러주세요!");
					scan.nextLine();
					scan.nextLine();
					break;
					
				case 5:
					System.out.println("프로그램 종료합니다.");
					System.exit(0);
					break;

				default:            
					throw new InputMismatchException();                 
				}// switch
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.!");
				scan.nextLine();
			}
		}// while
	}//showMenu()----------
	
	/**퀴즈 시작*/
	private void startQuiz() {
		System.out.println("#퀴즈를 시작합니다!");
		Scanner scan = new Scanner(System.in);
		if(qTotalOuput>quizData.size()) qTotalOuput = quizData.size();
		for (int i = 0; i < qTotalOuput; i++) {
			QuestionDTO qDTO = quizData.get(i);
			String question = qDTO.getQuestion();
			String answer = qDTO.getAnswer();

			System.out.println((i + 1) + ") " + question);
			String user_Answer = scan.nextLine();

			if (answer.equals(user_Answer)) {
				System.out.println("#다음 문제입니다");
				result++;
			} else {
				System.out.println("#다음 문제입니다");
			}
			System.out.println();
		}//for()------
		System.out.println("#퀴즈를 다 풀었습니다.");
		
		quizData.clear(); //퀴즈데이터 초기화
//		showResult(); //결과 출력
		
	}//startQuiz()---------

	/**게임 결과 보기*/
//	public void showResult(){
//
//		System.out.println("===== Mini Quiz Result====");
//		System.out.println("종  목 : "+menuString);
//		System.out.println("문제수 : "+qTotalOuput);
//		System.out.println("정답수 : "+result);
//		System.out.printf("점  수 : %.1f 점\n",result*(100.0/qTotalOuput));
//		System.out.println("==========================");
//	}//showResult()---------
}

