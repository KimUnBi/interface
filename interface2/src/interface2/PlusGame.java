package interface2;

import java.util.Random;

public class PlusGame implements Game {

	private Random ran;
	private int num1;
	private int num2;

	public PlusGame() {

	}

	@Override
	public void makeRandom() {
		ran = new Random();
		num1 = ran.nextInt(9) + 1;
		num2 = ran.nextInt(9) + 1;
	}

	@Override
	public String getQuizMsg() {
		return num1 + " + " + num2 + " = ";
	}

	@Override
	public boolean checkAnswer(int num) {
		return num == num1 + num2;
	}

}
