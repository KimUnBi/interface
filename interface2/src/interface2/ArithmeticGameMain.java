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

				System.out.println(i + 1 + "�� ���� >> " + p1.getQuizMsg());
				if (p1.checkAnswer(sc.nextInt())) {
					System.out.println("����");
					cnt++;
					break;
				} else {
					if (2 - j == 0) {
						if (i == 4) {
							System.out.println("���� ����");
							break;
						}
						System.out.println("�����Դϴ�..�̴̤��� ������ �Ѿ�ϴ�");
						break;
					}
					System.out.println("�����Դϴ�. ���� �����ȸ��" + (2 - j) + "�� �Դϴ�.");
				}
			}
		}

		System.out.println(cnt + "�� ����");

	}

}
