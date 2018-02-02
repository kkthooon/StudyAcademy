package StudentQuizProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//�������� �����ϴ� ������� ArrayList
public class QuizDataDAO extends ArrayList<QuestionDTO> {

	public boolean loadQuiz(int key) {
		String quizDataPath = "Quiz" + key + ".dat";
		
		try {
			Scanner scan = new Scanner(new FileInputStream(quizDataPath));

			while (scan.hasNext()) {
				QuestionDTO qDTO = new QuestionDTO(scan.nextLine(), scan.nextLine()); //Ȧ���� ����, ¦���� ����
				this.add(qDTO); //������ ������ �о�ͼ� Arraylist�� �߰�
			}
			System.out.println();
			Collections.shuffle(this); //���� ���´�
		} catch (FileNotFoundException e) {
			System.out.println(">> ���� ������ �����ϴ�");
			return true;
		}
		return false;
	}
} 