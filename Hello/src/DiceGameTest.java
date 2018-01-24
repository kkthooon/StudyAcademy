import java.util.*;

class DiceGame {
	
	int diceFace;
	int userGuess;
	
	//생성자는 만들지 않아도 됨
	
	//메소드
	private void RollDice() {
		diceFace = (int) (Math.random() * 6 ) + 1; //Math.random()은 0.0이상 1.0미만의 랜덤값
	}
	
	private int getUserInput(String prompt) {
		System.out.println(prompt);
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	
	private void checkUserGuess() {
		if(diceFace == userGuess) {
			System.out.println("맞았습니다");
		}
		else {
			System.out.println("틀렸습니다");
		}
	}
	
	public void startPlaying() {
		userGuess = getUserInput("예상값을 입력하시오: "); //숫자 입력 받아 userGuess에 저장
		RollDice(); //주사위 돌린다
		checkUserGuess(); //두 숫자를 비교
	}
}

public class DiceGameTest {

	public static void main(String[] args) {
		
		DiceGame game = new DiceGame();
		game.startPlaying();
	}

}
