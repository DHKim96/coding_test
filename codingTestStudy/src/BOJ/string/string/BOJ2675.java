package BOJ.string.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2675 {
	/*
	 * 백준 no.2675 : 문자열 반복
	 * 
	 *  1. 테스트케이스 갯수 입력받기
	 *  2. 테스트케이스 내 반복 횟수 R, 문자열 S 입력 받기
	 *  3. R번 만큼 StringBuilder에 S.charAt()을 append하기
	 *  4. 출력하기
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 1. 테스트케이스 갯수 입력 받기
		int T = Integer.parseInt(br.readLine());
		// 각 테스트 케이스의 결과 담을 StringBuilder 선언
		StringBuilder sb = new StringBuilder();
		
		// 2. 테스트케이스 내 반복 횟수 R, 문자열 S 입력 받기
		while(T-- > 0) {
			// 공백 기준으로 쪼개기
			String[] strs = br.readLine().split(" ");
			// 2.1. 반복 횟수 R 추출
			int R = Integer.parseInt(strs[0]);
			// 2.2. 문자열 S 추출
			String S = strs[1];
			// 3. S.charA()을 R번만큼 반복하여 StringBuilder에을 append하기
			for(int i = 0; i < S.length(); i++) {
				for(int j = 0; j < R; j++) {
					sb.append(S.charAt(i));	
				}
			}
			// S의 반복이 끝나면 줄바꿈 실시
			sb.append("\n");
		}
		
		// 결과물 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
