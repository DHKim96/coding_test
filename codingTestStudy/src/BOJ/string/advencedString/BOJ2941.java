package BOJ.string.advencedString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941 {
	/*
	 * BOJ NO.2941 : 크로아티아 알파벳
	 * 
	 * 1. 단어 입력 받기
	 * 2. replace() 사용해 크로아티아 알파벳들을 *로 치환
	 * 3. 해당 길이를 출려
	 */
	
	public static void main(String[] args) throws IOException{
		// 1. 단어 입력 받기
		// 1.1. 입력 스트림 열기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1.2. 입력 받기
		String word = br.readLine();
		// 1.3. 입력 스트림 닫기
		br.close();
		
		// 2. 단어에 있는 목록 내 크로아티아 알파벳들을 *로 치환하기
		// 2.1. 크로아티아 알파벳 패턴을 저장
		String[] croatianAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		// 2.2. 반복문을 통해 word 내 크로아티아 알파벳들을 *로 치환
		for (String croatianAlphabet : croatianAlphabets) {
			word = word.replace(croatianAlphabet, "*");
		}
		
		// 3. 갯수 출력하기 
		// 3.1. 크로아티아 알파벳들을 *로 치환했기에 크로아티아 철자의 갯수는 곧 word.length()
		System.out.println(word.length());
	}
}
