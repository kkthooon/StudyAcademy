import java.util.*;

class DiceGame {
	
	int diceFace;
	int userGuess;
	
	//�����ڴ� ������ �ʾƵ� ��
	
	//�޼ҵ�
	private void RollDice() {
		diceFace = (int) (Math.random() * 6 ) + 1; //Math.random()�� 0.0�̻� 1.0�̸��� ������
	}
	
	private int getUserInput(String prompt) {
		System.out.println(prompt);
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	
	private void checkUserGuess() {
		if(diceFace == userGuess) {
			System.out.println("�¾ҽ��ϴ�");
		}
		else {
			System.out.println("Ʋ�Ƚ��ϴ�");
		}
	}
	
	public void startPlaying() {
		userGuess = getUserInput("������ �Է��Ͻÿ�: "); //���� �Է� �޾� userGuess�� ����
		RollDice(); //�ֻ��� ������
		checkUserGuess(); //�� ���ڸ� ��
	}
}

public class DiceGameTest {

	public static void main(String[] args) {
		
		DiceGame game = new DiceGame();
		game.startPlaying();
	}

}
