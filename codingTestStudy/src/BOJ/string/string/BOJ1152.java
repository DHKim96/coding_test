package BOJ.string.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1152 {
	/*
	 * 백준 no.1152 : 단어의 개수
	 * 
	 * 공백으로 구분된 단어들로 이루어진 문자열 내 단어의 갯수를 구하는 문제
	 * 
	 * 1. 영어 대소문자와 공백으로 이루어진 문자열 입력 받기
	 * 2. trim()으로 양끝 공백 제거
	 * 3. .spilt(" ") 후 String[] 에 넣기
	 * 4. String[].length 출력
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1. 영어 대소문자와 공백으로 이루어진 문자열 입력 받기
		// 2. trim()으로 양끝 공백 제거
		String str = br.readLine().trim();
		// !! 입력이 빈 문자열인 경우에 단어 수는 0 (안해줄 경우 오답)
		if(str.isEmpty()) {
			System.out.println(0);
			br.close();
			return;
		}
		// 3. .spilt() 후 String[] 에 넣기
		String[] strSpilts = str.split(" ");
		// 4. strSpilts.length 출력
		System.out.println(strSpilts.length);
		br.close();
	}
}
