package BOJ.algorithm.bruteForce;

import java.util.Scanner;

public class BOJ2231 {
	/*
	 * BOJ NO.2231 : 분해합
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int M = 0;
		
		// 효율적인 브루트포스를 위해 탐색 시작점을 지정해줄 필요가 있음
		
		// 분해합 조건을 만족하는 생성자의 최솟값은 N - (N의 자리의 갯수 * 9)
		// 왜나하면
		// 1. 분해합 N = 생성자 M + M의 각 자릿수의 합 일때
		// 	   M = N - M의 각 자릿수의 합
		// 2. 이때 N > M을 만족하기에 숫자의 길이도 N >= M
		// 3. 또한 각 자리에 들어갈 수 있는 최대값은 9
		// 4. 따라서 M < N - (N의 자리의 갯수 * 9) 일 수 없음
		
		int min = N - (String.valueOf(N).length() * 9);
		
		for(int i = min ; i <= N; i++) { // N부터 1씩 차감하며 모든 경우의 수 탐색
			int num = i;
			int sumDigits = 0;
			
			while(num > 0) { // 각 자릿수의 합 산출
				int digit = num % 10;
				sumDigits += digit;
				num -= digit;
				num /= 10;
			}

			if( i + sumDigits == N ) { // 해당 경우의 분해합
				M = i;
				break;
			}
		}
		
		System.out.println(M);
		sc.close();
	}
}
