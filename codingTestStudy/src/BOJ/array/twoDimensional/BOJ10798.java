package BOJ.array.twoDimensional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10798 {
	/*
	 *  BOJ NO.10798 : 세로읽기
	 *  
	 *  1. 글자들을 입력받기
	 *  
	 *  2. 글자들을 세로로 읽기
	 *  
	 *  3. 세로로 읽은 글자들 출력하기
	 */

	public static void main(String[] args) throws IOException {
		//  스트림 연결
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 글자 저장하기 위한 배열 생성
		String[] strs = new String[5];
		
		// 각 행의 문자열 중 최대 길이 저장하기 위한 변수 생성
		int maxLength = 0;
		
		// 글자 입력 받기 및 최대 길이 계산
		for ( int i = 0; i < 5; i++ ) {
			strs[i] = br.readLine();
			// 최대 길이값 계산
			maxLength = maxLength > strs[i].length() ? maxLength : strs[i].length(); 
		}
		
		// 글자 저장할 빌더
		StringBuilder sb = new StringBuilder();
		
		// 세로로 읽기
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < strs[j].length()) { // 공백 고려
                    sb.append(strs[j].charAt(i));
                }
            }
        }
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
