package StudentQuizProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//문제들을 저장하는 저장공간 ArrayList
public class QuizDataDAO extends ArrayList<QuestionDTO> {

	public boolean loadQuiz(int key) {
		String quizDataPath = "Quiz" + key + ".dat";
		
		try {
			Scanner scan = new Scanner(new FileInputStream(quizDataPath));

			while (scan.hasNext()) {
				QuestionDTO qDTO = new QuestionDTO(scan.nextLine(), scan.nextLine()); //홀수줄 문제, 짝수줄 정답
				this.add(qDTO); //문제와 정답을 읽어와서 Arraylist에 추가
			}
			System.out.println();
			Collections.shuffle(this); //문제 섞는다
		} catch (FileNotFoundException e) {
			System.out.println(">> 문제 파일이 없습니다");
			return true;
		}
		return false;
	}
} 