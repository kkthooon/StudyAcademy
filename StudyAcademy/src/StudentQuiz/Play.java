package StudentQuiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Play {

	private int result = 0; //�������� ����.
	private String menuString; //�޴��׸�
	private int qTotalOuput; //��� �����
	private QuizDataDAO quizData; //�������� �����ϴ� ArrayList
	private ArrayList<QuizResult> resultArray = new ArrayList<>();

	//������
	public Play() {
		this(6); //���� ��°����� ����Ʈ 6��
	}   

	public Play(int size) {
		quizData = new QuizDataDAO();           
		qTotalOuput = size;
	}
	
	/**�޴� �����ֱ�*/
	public void showMenu(){
		Scanner scan = new Scanner(System.in);
		String[] menuStringList =new String[]{"�û�","���","������","������"};
		boolean[] finishedList = new boolean[4];
		while (true) {
			System.out.println();
			System.out.println("===== Mini Quiz Start====");
			for(int i=0; i<menuStringList.length; i++) {
				if(finishedList[i]== true) continue;
				System.out.println(i+1 +") " + menuStringList[i]);
			}
			System.out.println("5) ���� ");
			System.out.print("===�޴��� �������ּ���===\n:");

			try {
				
				int key = scan.nextInt();    //�޴��� �Է¹޴´�.            
				switch (key) {
				case 1: case 2: case 3: case 4:

					System.out.println(key + "�� �޴��� �����Ͽ����ϴ�.");
					menuString = menuStringList[key-1];
					if(quizData.loadQuiz(key)) continue;  
					//�ش��׸��� ���������� �ε��� Arraylist�� ����
					//������ ������� �Ʒ������� �������� �ʰ� �ٽ� �޴�ȭ������.

					startQuiz(); //���� ����
					finishedList[key-1] = true;
					System.out.println("�޴��� ���÷��� �ƹ�Ű�� �����ּ���!");
					scan.nextLine();
					scan.nextLine();
					break;
					
				case 5:
					System.out.println("���α׷� �����մϴ�.");
					System.exit(0);
					break;

				default:            
					throw new InputMismatchException();                 
				}// switch
			} catch (InputMismatchException e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.!");
				scan.nextLine();
			}
		}// while
	}//showMenu()----------
	
	/**���� ����*/
	private void startQuiz() {
		System.out.println("#��� �����մϴ�!");
		Scanner scan = new Scanner(System.in);
		if(qTotalOuput>quizData.size()) qTotalOuput = quizData.size();
		for (int i = 0; i < qTotalOuput; i++) {
			QuestionDTO qDTO = quizData.get(i);
			String question = qDTO.getQuestion();
			String answer = qDTO.getAnswer();

			System.out.println((i + 1) + ") " + question);
			String user_Answer = scan.nextLine();

			if (answer.equals(user_Answer)) {
				System.out.println("#���� �����Դϴ�");
				result++;
			} else {
				System.out.println("#���� �����Դϴ�");
			}
			System.out.println();
		}//for()------
		System.out.println("#��� �� Ǯ�����ϴ�.");
		
		quizData.clear(); //������� �ʱ�ȭ
		showResult(); //��� ���
		
	}//startQuiz()---------

	/**���� ��� ����*/
	public void showResult(){
		File outFile = new File("C:\\Users\\201-08\\eclipse-workspace\\Test", "Result.txt");
		//==========================//
		// �ؽ�Ʈ ���� ����
		//==========================//
		BufferedWriter bw = null;
		
		double score = result*(100.0/qTotalOuput);
		
		QuizResult quizResult = new QuizResult();
		quizResult.menuString = menuString;
		quizResult.qTotalOuput = qTotalOuput;
		quizResult.result = result;
		quizResult.score = score;
		
		resultArray.add(quizResult);
		
		try {
			bw = new BufferedWriter(new FileWriter(outFile));
			bw.write("===== Mini Quiz Result====");
			bw.newLine();
			bw.write("��  �� : "+menuString);
			bw.newLine();
			bw.write("������ : "+qTotalOuput);
			bw.newLine();
			bw.write("����� : "+result);
			bw.newLine();
			bw.write("��  �� : "+score);
			bw.newLine();
			bw.write("==========================");
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bw != null) try {bw.close(); } catch (IOException e) {}
		}

		System.out.println("===== Mini Quiz Result====");
		System.out.println("��  �� : "+menuString);
		System.out.println("������ : "+qTotalOuput);
		System.out.println("����� : "+result);
		System.out.printf("��  �� : %.1f ��\n",result*(100.0/qTotalOuput));
		System.out.println("==========================");
	}//showResult()---------
	
}

