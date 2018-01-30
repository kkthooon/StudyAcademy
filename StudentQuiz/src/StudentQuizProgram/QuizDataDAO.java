package StudentQuizProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//문제들을 저장하는 저장공간 ArrayList

public class QuizDataDAO extends ArrayList<QuestionDTO> {

	/**
	 * 퀴즈문제를 출제할수있도록 
	 * 해당 퀴즈데이터 읽어와서 ArrayList에 저장!
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
				//짝수줄 문제, 홀수줄 정답. 
				//문제와 정답을 읽어와서 Arraylist에 추가
				QuestionDTO qDTO = new QuestionDTO(scan.nextLine(), scan.nextLine());
				//System.out.println(qDTO);
				this.add(qDTO);
			}//while------
			System.out.println();
			Collections.shuffle(this); // 문제 섞는다.
			/*
			 * for (Question q: QuizData) { System.out.println(q); }
			 */

		} catch (FileNotFoundException e) {
			System.out.println("예외 : " + e);
			return true;
		}

		return false;
	}// loadQuiz()

}