package interface2;

public interface Game {
	
	public static final int temp = 0;
	
	public void makeRandom();
	
	public String getQuizMsg();
	
	public boolean checkAnswer(int num);
	
	public default void temp() {
		System.out.println("**");
	}

}
