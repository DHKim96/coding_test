package BOJ.generalMathematicsOne;

import java.util.Scanner;

public class BOJ2903 {
	/*
	 * BOJ NO.2903 : 중앙 이동 알고리즘
	 * 
	 * = 가장 큰 사각형의 점의 갯수의 제곱 값 찾기
	 * 1. 가장 큰 사각형의 점의 갯수 찾기
	 * 초기 : 2개
	 * 1번 : 3 = (2+1)개 
	 * 2번 : 5 = (2^2+1)개
	 * 3번 : 9 = (2^3+1)개
	 * 4번 : 17 = (2^4+1)개 
	 * => N번째의 가장 큰 사각형의 한 변에 있는 점의 갯수는      
	 *    따라서 N번째의 점의 총 갯수는 (2^N+1)^2개
	 * 
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int temp = 1;
		
		// 2^N 연산 위한 반목문
		for(int i = 0; i < N; i++) {
			temp *= 2;
		}
		
		int result = (temp+1)*(temp+1); // 점의 갯수
		
		System.out.println(result);
		sc.close();
	}
}
