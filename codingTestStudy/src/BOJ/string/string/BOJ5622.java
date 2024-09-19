package BOJ.string.string;

import java.util.Scanner;

public class BOJ5622 {
	/*
	 * BOJ NO.5622 : 다이얼
	 * 
	 * 1. 단어 입력받기
	 * 2. 단어를 알파벳들로 쪼개기
	 * 3. 알파벳들을 숫자로 치환하기
	 * 4. 숫자들로 최소 시간 구하기
	 */
	public static void main(String[] args) {
		// 입력 스트림
		Scanner sc = new Scanner(System.in);
		// 시간 저장 위한 변수
		int requiredTime = 0;
		// 단어 입력받기
		String str = sc.nextLine();
		// 단어를 알파벳으로 쪼개기
		for(int i = 0; i < str.length(); i++) {
			char alphabet = str.charAt(i);
			// 알파벳을 시간(숫자+1)으로 치환하기
			if ( alphabet <= 'C' ) {
				requiredTime += 3;
			} else if ( alphabet <= 'F' ) {
				requiredTime += 4;
			} else if ( alphabet <= 'I' ) {
				requiredTime += 5;
			} else if ( alphabet <= 'L' ) {
				requiredTime += 6;
			} else if ( alphabet <= 'O' ) {
				requiredTime += 7;
			} else if ( alphabet <= 'S' ) {
				requiredTime += 8;
			} else if ( alphabet <= 'V' ) {
				requiredTime += 9;
			} else {
				requiredTime += 10;
			}
		};
		// 시간 출력
		System.out.println(requiredTime);
		// 입력 스트림 닫기
		sc.close();
		// try-with-resources 문법을 통해 close()를 대체할 수 있음
	}
}
