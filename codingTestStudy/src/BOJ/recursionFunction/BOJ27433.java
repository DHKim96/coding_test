package BOJ.recursionFunction;

import java.util.Scanner;

public class BOJ27433 {
	
	/*
	 *	* 팩토리얼 2
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if (N > 0) {
			System.out.println(pactorial(N));			
		} else {
			System.out.println(1);
		}
		
		
		sc.close();
	}
	public static long pactorial(long num) { // 20!은 int 초과
		if (num == 1) return 1;
		return num * pactorial(num - 1);
	}
}
