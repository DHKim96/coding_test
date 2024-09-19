package BOJ.divisorMultiplePrimeNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1978 {
	/*
	 * BOJ NO.1978 : 소수 찾기
	 * n의 소수 여부를 가리기 위한 나머지 연산은 n의 제곱근까지만 확인하면 됨
	 * => n 이 소수가 아니라는 가정 하에 n = a * b 일때
	 * a || b <= n의 제곱근 을 만족하기 때문
	 * 즉 소수가 아니라면 약수 중 하나는 무조건 n의 제곱근 이하임
	 */
	
	/**
	 * @return 소수인지 여부
	 */
	public static boolean checkPrimeNumber(int num) {
		if (num == 1) return false;
		for(int i = 2; i * i <= num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		String[] strInputs = br.readLine().split(" ");

		int count = 0;
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(strInputs[i]);
			if (checkPrimeNumber(num)) count++;
		}
		
		System.out.println(count);
		br.close();
	}
}
