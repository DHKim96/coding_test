package BOJ.string.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11718 {
	/*
	 * BOJ NO.11718 : 그대로 출력하기
	 * 
	 * 입력이 끝날 때까지 입력 받으면서 동시에 출력하기
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
