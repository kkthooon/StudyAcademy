package StudentQuizProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//�������� �����ϴ� ������� ArrayList

public class QuizDataDAO extends ArrayList<QuestionDTO> {

	/**
	 * ������� �����Ҽ��ֵ��� 
	 * �ش� ������� �о�ͼ� ArrayList�� ����!
	 * Data shuffle!
	 * @param key 
	 */
	
	public boolean loadQuiz(int key) {
		//String quizDataPath = "C:\\Quiz" + key + ".dat";
		String quizDataPath = "Quiz" + key + ".dat";
		//System.out.println(quizDataPath);
		try {
			Scanner scan = new Scanner(new FileInputStream(quizDataPath));

			while (scan.hasNext()) {
				//¦���� ����, Ȧ���� ����. 
				//������ ������ �о�ͼ� Arraylist�� �߰�
				QuestionDTO qDTO = new QuestionDTO(scan.nextLine(), scan.nextLine());
				//System.out.println(qDTO);
				this.add(qDTO);
			}//while------
			System.out.println();
			Collections.shuffle(this); // ���� ���´�.
			/*
			 * for (Question q: QuizData) { System.out.println(q); }
			 */

		} catch (FileNotFoundException e) {
			System.out.println("���� : " + e);
			return true;
		}

		return false;
	}// loadQuiz()

}