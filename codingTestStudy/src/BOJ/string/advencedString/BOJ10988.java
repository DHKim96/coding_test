package BOJ.string.advencedString;

import java.util.Scanner;

public class BOJ10988 {
	/*
	 * BOJ NO.10988 : 팰린드롬인지 확인하기
	 * 
	 * 1. 단어 입력 받기
	 * 2. 팰린드롬인지 아닌지 확인
	 * 3. 결과 출력하기
	 */
	public static void main(String[] args) {
//		// 입력 스트림
//		Scanner sc = new Scanner(System.in);
//		// 결과값 담을 변수
//		int result = 1;
//		// 단어 입력 받기
//		String word = sc.nextLine();
//		// 팰린드롬인지 확인하기
//		// i번째 인덱스와 마지막인덱스(길이-1) - i번째 인덱스의 값이 같을 때
//		for(int i = 0; i < word.length(); i++) {
//			if(word.charAt(i) != word.charAt((word.length() - 1) - i)) {
//				result = 0;
//				break;
//			};
//		}
//		System.out.println(result);
//		sc.close();
		
		// StringBuilder 의 reverse()도 사용 가능
		// 입력 스트림
		Scanner sc = new Scanner(System.in);
		// 결과값 담을 변수
		int result = 1;
		// 단어 입력 받기
		String word = sc.nextLine();
		sc.close();
		// StringBuilder 선언
		StringBuilder sb = new StringBuilder(word);
		sb.reverse();
		
		// 팰린드롬인지 확인하기
		// i번째 인덱스와 역순한 sb 인덱스 i번째 의 값이 같을 때
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) != sb.charAt(i)) {
				result = 0;
				break;
			};
		}
		System.out.println(result);
	}
}
