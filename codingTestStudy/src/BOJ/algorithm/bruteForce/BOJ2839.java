package BOJ.algorithm.bruteForce;

import java.util.Scanner;

public class BOJ2839 {
	/*
	 * BOJ NO.2839 : 설탕 배달
	 * 
	 * => 설탕 봉지를 정확하게 나눠야 함
	 * 따라서 무작정 5로 나누면 안됨
	 * => 브루트포스를 활용하여 3으로 뺀 나머지가 5로 나눌 수 있을 때 5로 나누고 
	 * 	  그렇지 않을 경우는 마이너스 3 연산 반복
	 * 	  뺀 나머지가 3보다 작을 경우는 나눠지지 않는 경우이므로 -1 반환 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = 0;
		
		while(N >= 3) {
			if(N % 5 == 0) {
				count += N / 5;
				N %= 5;
			} else {
				N -= 3;
				count++;
			}
		}
		
		if(N != 0) {
			System.out.println(-1);
		} else {
			System.out.println(count);
		}
				
		sc.close();
	}
}
