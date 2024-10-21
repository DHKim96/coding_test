package BOJ.recursionFunction;

import java.util.Scanner;

public class BOJ10870 {
	/*
	 * * 피보나치 수 5
	 * 	0번째 피보나치 수 = 0
	 * 	1번째 ~ = 1
	 * 	2번째 ~ ... = 직전 두 피보나치 수의 합
	 */
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	
		
		System.out.println(fibonacciNumbers(n));
		
		sc.close();
		
	}
	
	public static int fibonacciNumbers(int depth) {
		if (depth == 1) {
			return 1;
		} else if (depth == 0) {
			return 0;
		}
		
		return fibonacciNumbers(depth - 1) + fibonacciNumbers(depth - 2); 
	}
}
