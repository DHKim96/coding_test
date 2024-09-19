package BOJ.string.advencedString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ3003 {
	/*
	 * BOJ NO.3003 : 킹, 퀸, 룩, 비숍, 나이트, 폰
	 * 
	 * 1. 동혁이가 찾은 흰색 킹, 퀸, 룩, 비숍, 나이트, 폰의 갯수 입력 받기
	 * 2. 완성된 흰색 세트를 만들기 위해 필요한 각 종류들의 피스 갯수 구하기
	 * 3. 출력
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 체스 세트 완성본
		int[] originPieces = {1, 1, 2, 2, 2, 8};
		// 동혁이가 찾은 체스 피스 입력 받기
		String[] dhsPieces = br.readLine().split(" ");
		// 반복문 통해 완성본 - 동혁이가 찾은 피스
		StringBuilder sb = new StringBuilder();
		int requiredPiece = 0;
		for(int i = 0; i < originPieces.length; i++) {
			requiredPiece = originPieces[i] - Integer.parseInt(dhsPieces[i]);
			sb.append(requiredPiece).append(" ");
		}
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
}
