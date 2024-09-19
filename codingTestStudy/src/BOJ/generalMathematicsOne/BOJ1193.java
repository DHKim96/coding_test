package BOJ.generalMathematicsOne;

import java.util.Scanner;

public class BOJ1193 {
	/*
	 * BOJ NO.1193 : 분수찾기
	 * 
	 * 
	 * 1. 방문하는 순서를 피라미드 형태로 새로 만듦
	 * 2. X번째에 해당하는 level를 산출(2292번 참고)
	 * 3. 해당 level의 홀수/짝수에 따라 분자 분모 형태가 달라짐
	 * => 해당 층 내에서의 순서를 구하면
	 * 	3.1. 홀수일경우 분자는 depth - (순서-1) / 분모는 순서
	 * 	3.2. 짝수일 경우는 홀수일 경우의 반대
	 * 
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		
		int level = 1;
		int levelEndNum = 1;
		
		// 계층 구하기
		while( X > levelEndNum ) {
			level++;
			levelEndNum += level;
		}
		
		int sequence = X - (levelEndNum - level); // 해당 레벨 내에서 몇 번째 위치인지 계산

		int numerator = 0; // 분자
		int denominator = 0; // 분모
		
		if ( level % 2 == 1 ) {
			numerator = level - ( sequence - 1 );
			denominator = sequence;
		} else {
			numerator = sequence;
			denominator = level - ( sequence - 1 );
		}
		
		System.out.println(numerator + "/" + denominator);
		
		sc.close();
	}
}
