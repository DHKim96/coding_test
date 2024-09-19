package BOJ.divisorMultiplePrimeNumber;

import java.util.Scanner;

public class BOJ2581 {
	/*
	 * BOJ NO.2581 : 소수
	 */
	
	/**
	 * 소수 여부 판별하는 메소드
	 * @param target
	 * @return
	 */
	public static boolean isPrimeNumber(int target) {
		if (target <= 1) return false;
		for(int num = 2; num * num <= target; num++) { // 소수가 아닐 경우 약수중 하나는 무조건 target의 제곱근 이하임
			if ( target % num == 0 ) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int minPrime = Integer.MAX_VALUE; // int형의 최댓값으로 초기화
		int sumPrimes = 0;
		
		for(int i = M; i <= N; i++) {
			if(isPrimeNumber(i)) {
				minPrime = Math.min(minPrime, i);
				sumPrimes += i;
			}
		}
		
		if ( sumPrimes == 0 ) {
			System.out.println( -1 );
		} else {
			System.out.println(sumPrimes);
			System.out.println(minPrime);
		}
		
		sc.close();
	}
}
