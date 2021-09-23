package interface2;

public class GameDummy implements Game {

	@Override
	public void makeRandom() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getQuizMsg() {
		return "2+3=";
	}

	@Override
	public boolean checkAnswer(int num) {
		return false;
	}

}
