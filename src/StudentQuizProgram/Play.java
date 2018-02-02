package StudentQuizProgram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Play {
	private int result = 0; //�������� ����.
	private String menuString; //�޴� �׸�
	private int qTotalOuput; //��� ���� ��
	private QuizDataDAO quizData; //�������� �����ϴ� ArrayList
	private ArrayList<QuizResult> resultArray = new ArrayList<>();
	private Student currentUser; //���� �α����� �л� �̸�
	
	//������
	public Play(Student student) {
		this(6); //���� ��°����� ����Ʈ 6��
		currentUser = student; //���� �α����� �л� �̸�
	}
	public Play(int size) {
		quizData = new QuizDataDAO(); //��ü ����
		qTotalOuput = size; //���� ��� ��
	}
	
	/**�޴� �����ֱ�*/
	public void showMenu(){
		Scanner scan = new Scanner(System.in);
		String[] menuStringList = new String[]{"�û�", "���", "������", "������"}; //���� ���
		boolean[] finishedList = new boolean[4]; //Ǯ������ ���� Ȯ���� ���� ��
		
		while (true) {
			System.out.println("\n=== Mini Quiz Start ===");
			for(int i = 0; i < menuStringList.length; i++) {
				if(finishedList[i] == true)
					continue; //������ Ǯ�� �ش� ������ true���� ��� ����
				System.out.println(i + 1 + ") " + menuStringList[i]);
			}
			System.out.println("5) ���� ");
			System.out.print("=== �޴��� �������ּ��� ===\n: ");

			try {
				int key = scan.nextInt();           
				switch (key) { //�޴��� �Է¹޴´�
				case 1: case 2: case 3: case 4:
					if(finishedList[key-1] == true) //Ǯ���� ���� ���� 
						break; //�� Ǯ�� ����
					System.out.println(">> " + key + "�� �޴��� �����Ͽ����ϴ�");
					menuString = menuStringList[key-1];
					if(quizData.loadQuiz(key)) //�Է� ���� �ش�Ǵ� ����
						continue;  
					//�ش� �׸��� ���� ������ �ε��� Arraylist�� ����
					//������ ���� ��� �Ʒ� ������ �������� �ʰ� �ٽ� �޴� ȭ������
					startQuiz(); //���� ����
					finishedList[key-1] = true; //���� ������ �ش� ������ true�� �ٲ�
					System.out.println(">> �ƹ�Ű�� ������ ���� Ǯ���� " + key + "�� ������ �������� ���ÿ�");
					System.out.println(">> �޴� ������ ���� �ƹ�Ű�� �����ÿ�");
					scan.nextLine();
					scan.nextLine();
					break;
				case 5:
					StudentManagement manage = new StudentManagement();
					System.out.println(">> ó�� ȭ������ �̵��մϴ�");
					manage.MenuPrint(); //ó�� ȭ�� ���
					break;
				default:            
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println(">> �߸� �Է��ϼ̽��ϴ�");
				scan.nextLine();
			}
		}
	}
	
	/**���� ����*/
	private void startQuiz() {
		System.out.println("# ��� �����մϴ�!");
		Scanner scan = new Scanner(System.in);
		
		if(qTotalOuput > quizData.size())
			qTotalOuput = quizData.size();
		for (int i = 0; i < qTotalOuput; i++) {
			QuestionDTO qDTO = quizData.get(i); //Arraylist�� ����� ������ ������ �´�
			String question = qDTO.getQuestion(); //����
			String answer = qDTO.getAnswer(); //����

			System.out.println((i + 1) + ") " + question); //���� ���
			String user_Answer = scan.nextLine(); //�� �Է�

			if (answer.equals(user_Answer) && i != qTotalOuput - 1) { //������ ��� �л��� ���� ��ġ�� ���
				System.out.print("# ���� �����Դϴ�");
				System.out.println();
				result++;
			} else { //��ġ���� ���� ��
				if(i != qTotalOuput - 1) {
					System.out.print("# ���� �����Դϴ�");
					System.out.println();
				}		
			}
		}
		System.out.println("# ��� �� Ǯ�����ϴ�");
		quizData.clear(); //������� �ʱ�ȭ
		showResult(); //��� ���
		result = 0; //���� �� Ǯ�� ����� �ʱ�ȭ
		
	}
	
	/**���� ��� ����*/
	public void showResult(){
		File outFile = new File("C:\\Users\\green201-11\\Desktop\\StudentQuiz", "Result.txt");
		
		//==========================//
		// �ؽ�Ʈ ���� ����
		//==========================//
		BufferedWriter bw = null;
		
		double score = result*(100.0/qTotalOuput); //����
		
		QuizResult quizResult = new QuizResult();
		quizResult.menuString = menuString;
		quizResult.qTotalOuput = qTotalOuput;
		quizResult.result = result;
		quizResult.score = score;
		
		resultArray.add(quizResult);
		
		try {
			bw = new BufferedWriter(new FileWriter(outFile, true));
			bw.write(">> " + currentUser.getName() + "���� ����");
			bw.newLine();
			bw.write("=== Mini Quiz Result ===");
			bw.newLine();
			bw.write("��  �� : "+ menuString);
			bw.newLine();
			bw.write("���� �� : "+ qTotalOuput);
			bw.newLine();
			bw.write("���� �� : "+ result);
			bw.newLine();
			bw.write("��  �� : "+ score);
			bw.newLine();
			bw.write("=======================");
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) try {bw.close(); } catch (IOException e) {}
		}
		
		/** ���� Ǯ�� ��� ��� */
		System.out.println("=== Mini Quiz Result ===");
		System.out.println("��  �� : "+ menuString);
		System.out.println("���� �� : "+ qTotalOuput);
		System.out.println("���� �� : "+ result);
		System.out.printf("��  �� : %.1f ��\n", result * (100.0/qTotalOuput));
		System.out.println("========================");
	}
	
}