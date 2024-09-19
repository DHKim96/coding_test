package BOJ.generalMathematicsOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2745 {
	/*
	 * BOJ NO.2745 : 진법 변환
	 * 
	 * 1. B진법의 수 N을 입력 받기
	 * 2. 10진법으로 변환하기
	 * 	ex) 36진법 ZZZZZ 는 Z*36^4 + Z*36^3 ... + Z*36^0(=1);
	 * 	=> 제곱연산자를 통해 10진법으로 변환 가능
	 * 3. 출력하기
	 */
	
	public static void main(String[] args) throws IOException {
		// 스트림 열기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 진법의 수
		String N;
		
		// 진법의 기반(EX. 16진법이면 16)
		int B;
		
		// 10진법으로 변환한 결과값 담을 변수
		int result = 0;
		
		// 입력 받기
		String[] input = br.readLine().split(" ");
		N = input[0];
		B = Integer.parseInt(input[1]);
		
        // 거듭제곱한 진법의 기반 저장할 변수
        int temp = 1;
        
		// 진법 변환 실시
		for ( int i = N.length() - 1; i >= 0; i-- ) { // 1의 자리부터 계산해야함
			// 알파벳을 숫자로 변환
			int num = Character.getNumericValue(N.charAt(i));
            /*
			 * Character.getNumericValue()
			 * 	: 진법과 관련한 문자들을 숫자로 변환 시 문자의 숫자적 의미를 기준으로 숫자 값을 반환
			 * 	: 'A' = 10,  'B' = 11 , ..., 'Z' = 35
			 *  : 유효하지 않은 문자일시 -1 반환
			 */
            
			// 10진법 변환
			result += num * temp;
            // 진법의 기반 거듭제곱 실시
            temp *= B;
		}
		
		// 출력
		System.out.println(result);
		
		// 스트림 닫기
		br.close();
	}
}
