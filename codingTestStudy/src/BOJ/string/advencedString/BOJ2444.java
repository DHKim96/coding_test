package BOJ.string.advencedString;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ2444 {
	/*
	 * BOJ NO.2444 : 별 찍기 - 7
	 * 
	 * 1. N 입력 받기
	 * 2. 재귀 함수로 공백 & 별 찍기
	 *  DEPTH : N
	 *  1번째 DEPTH의 별은 1
	 *  2 : 3
	 *  3 : 5
	 *  .
	 *  .
	 *  .
	 *  N : 2N-1
	 *  
	 *  3. 별을 StringBuilder 에 append
	 *  4. 재귀함수 끝난 뒤 출력
	 */
	private static StringBuilder sb;
	
	/**
	 * 공백과 별 그리는 재귀함수
	 * @param depth : 재귀함수의 깊이
	 * @param N : 입력 받은 숫자
	 */
	public static void drawStars(int depth, int N) {
		// 탈출 조건 : 깊이가 N보다 클 때
		if(depth > N) return;
		
		// 좌측 공백 찍기
		for(int i = depth; i < N; i++) {
			sb.append(" ");
		}
		// 별 찍기
		for(int i = 0; i < (2*depth) - 1; i++) {
			sb.append("*");
		}
		sb.append("\n");
		
		//재귀함수 호출
		drawStars(depth+1, N);
		
		// 함수 탈출 이후 별 찍기
		if (depth < N) { // N번째 줄에서는 한 번만 별을 찍기 때문에 마지막 줄은 제외
			// 좌측 공백 찍기
			for(int i = depth; i < N; i++) {
				sb.append(" ");
			}
			// 별 찍기
			for(int i = 0; i < (2*depth) - 1; i++) {
				sb.append("*");
			}
			sb.append("\n");
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 입력 스트림과 출력 스트림 선언
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 1. N 입력 받기
		int N = sc.nextInt();
		// 출력 위한 스트링 빌더 선언
		sb = new StringBuilder();
		// 2. 재귀함수를 통해 공백과 별 찍기
		drawStars(1, N);
		// 3. 출력하기
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		sc.close();
	}
}
