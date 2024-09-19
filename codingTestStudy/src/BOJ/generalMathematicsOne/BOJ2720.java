package BOJ.generalMathematicsOne;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ2720 {
	/*
	 * BOJ NO.2720 : 세탁소 사장 동혁
	 * 
	 * 1. 테스트 케이스의 갯수, 각 테스트 케이스별 거스름돈 입력 받기
	 * 
	 * 2. 거스름돈에 필요한 쿼터, 다임, 니켈, 페니의 갯수 구하기
	 * 	- 동전의 갯수는 최소
	 * 	 => 높은 액면가의 동전들을 우선적으로 할당해야 함
	 *   => 나눗셈과 나머지 연산으로 구할 수 있음
	 * 
	 * 3. 출력하기
	 */
	
	public static void main(String[] args) throws IOException {
		// 스트림 열기
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		int[] coins = {25, 10, 5, 1}; // 각 동전의 종류를 배열로 생성
		
		while ( T-- > 0 ) {
			int C = sc.nextInt();
			
			int[] counts = new int[4]; // 각 동전의 갯수를 저장하기 위한 배열
			
			// 쿼터부터 차례대로 나눗셈 및 나머지 연산 진행하여 필요 동전 갯수 계산
			for ( int i = 0; i < counts.length; i++ ) {
				counts[i] = C / coins[i]; // 갯수 구하기
				C %= coins[i]; // 나머지 액수에 대한 필요 동전 계산하기 위한 나머지 연산
			}
			
			
			sb.append(counts[0]).append(" ")
			  .append(counts[1]).append(" ")
			  .append(counts[2]).append(" ")
			  .append(counts[3]).append("\n");
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		sc.close();
	}
	
}
