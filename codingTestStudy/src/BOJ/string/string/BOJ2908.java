package BOJ.string.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2908 {
	/*
	 * 백준 no.2908 : 상수
	 * 
	 * 1. 상근이가 칠판에 적은 수 A, B 입력 받기
	 * 2. 각각의 수를 거꾸로 배열하기
	 * 3. 거꾸로 배열한 수의 크기를 비교하여 큰 수 출력하기
	 */
	
	/**
	 * 숫자를 뒤집는 메소드
	 * @param num
	 * @return
	 */
	public static int reverse(int num) {
		int reverse = 0;
		while(num > 0) {
			int digit = num % 10; // 10으로 나눈 나머지는 1의 자리
			reverse = reverse * 10 + digit; // 일의 자리부터 *10을 통해 한 자리씩 digit을 배치
			num /= 10; // 그 다음 자리의 값을 추출하기 위해서 /10 연산
		}
		return reverse;
	}
	
	public static void main(String[] args) throws IOException {
		// 1. 상근이가 칠판에 적은 수 A, B 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A, B, reverseA, reverseB;
		StringTokenizer st  = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		// 2. 각각의 수를 거꾸로 배열하기
		reverseA = reverse(A);
		reverseB = reverse(B);
        // 또는 Stringbuilder의 .reverse() 메서드도 이용 가능
		
		// 3.크기 비교하여 출력
		if(reverseA > reverseB) System.out.println(reverseA);
		else System.out.println(reverseB);
        // 또는 System.out.println(Math.max(reverseA,reverseB)); 도 가능
		
		br.close();
	}
}
