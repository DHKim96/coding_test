package BOJ.divisorMultiplePrimeNumber;

import java.util.Scanner;

public class BOJ11653 {
	/*
	 * BOJ NO.11653 : 소인수분해
	 */
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);		
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int factor = 2; factor * factor <= N; factor++) {
			while(N % factor == 0) { // 2로 소인수분해될 때까지 분해 그 다음 3으로 분해 ... 하는 방식이 효율적
				sb.append(factor).append("\n");
				N /= factor;
			}
		}
		
		// 마지막으로 남은 수가 1보다 크다면 해당 수도 소수
		if(N > 1) sb.append(N);
	
		System.out.println(sb.toString());
		sc.close();
	}
}
