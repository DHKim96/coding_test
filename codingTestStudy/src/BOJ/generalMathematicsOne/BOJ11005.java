package BOJ.generalMathematicsOne;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11005 {
	/*
	 * BOJ NO.11005 : 진법 변환 2
	 * 
	 * 1. 10진법 수 N, 변환하고자 하는 진법의 BASE B 입력 받기
	 * 2. 10진법의 수를 B진법의 수로 변환
	 * => 나눗셈 연산자와 나머지 연산자를 활용 (재귀함수도 사용 가능)
	 * 3. 출력
	 * 
	 */
	
	public static char conversionNumToChar(int num) {
		return (char)(num - 10 + 'A'); // 10부터 'A' 이기 때문에
	}
	
	public static String conversion(int base, int decimal) {
		StringBuilder sb = new StringBuilder();
		
		int quotient = decimal;
		int remainder = 0;
		
		while ( quotient > 0 ) {
			remainder = quotient % base;
			quotient /= base;
			
			if ( remainder >= 10 ) sb.append(conversionNumToChar(remainder));
			else sb.append(remainder);
		}
		
		return sb.reverse().toString(); // 제일 마지막 나머지가 가장 큰 자릿수의 값이기 때문에 역순으로 진행해야함
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		
		int decimal = Integer.parseInt(input[0]); //10진법 수
		int base = Integer.parseInt(input[1]); // 변환할 진법의 base
	
		String result = conversion(base, decimal);
		
		bw.write(result);
		bw.flush();
		bw.close();
		br.close();
	}
}
