package BOJ.divisorMultiplePrimeNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2501 {
	/*
	 * BOJ NO.2501 : 약수 구하기
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int num = 1;
		int count = 0;
		int divisor = 0;
		
		while ( num <= N ) {
			if ( ( N % num ) == 0 ) {
				divisor = num;
				if ( ++count == K ) break;
				else divisor = 0 ;
			}
			num++;
		}
		
		System.out.println(divisor);
		br.close();
	}
}
