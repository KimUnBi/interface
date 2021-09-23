package interface2;

import java.util.Scanner;

public class ArithmeticGameMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		GameDummy p1 = new GameDummy();
		PlusGame p1 = new PlusGame();

		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			p1.makeRandom();
			for (int j = 0; j < 3; j++) {

				System.out.println(i + 1 + "번 문제 >> " + p1.getQuizMsg());
				if (p1.checkAnswer(sc.nextInt())) {
					System.out.println("정답");
					cnt++;
					break;
				} else {
					if (2 - j == 0) {
						if (i == 4) {
							System.out.println("게임 종료");
							break;
						}
						System.out.println("오답입니다..ㅜㅜ다음 문제로 넘어갑니다");
						break;
					}
					System.out.println("오답입니다. 남은 정답기회는" + (2 - j) + "번 입니다.");
				}
			}
		}

		System.out.println(cnt + "번 정답");

	}

}
