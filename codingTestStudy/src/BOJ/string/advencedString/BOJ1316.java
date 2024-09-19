package BOJ.string.advencedString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316 {
	/*
	 * BOJ NO.1316 : 그룹 단어 체커
	 * 
	 * 1. 단어 입력 받기
	 * 2. 그룹 단어 조건 만족 여부 체크하기
	 * => boolean 배열 이용해서 문자의 등장 여부 체크
	 * 3. 만족할 시 갯수 +1
	 * 4. 그룹 단어 갯수 출력
	 * 
	 */
	
	/**
	 * 그룹 단어 조건 만족 여부를 체크하는 메소드
	 * @param word
	 * @return
	 */
	public static boolean isGroupWord(String word) {
		// 철자의 등장 여부를 가리는 배열
		boolean[] seen = new boolean[26];
		// 이미 지난 철자를 저장하는 변수
		char prev = ' ';
		// 반복문을 통해 단어를 철자로 쪼개기
		for ( int i = 0; i < word.length(); i++ ) {
			// 현재 철자 저장
			char curr = word.charAt(i);
			// 현재 철자가 이전 철자랑 다를 시
			if(curr != prev) {
				// 이미 등장한 철자였다면 return false
				if(seen[curr - 'a']) return false;
				// 아니라면 현재 철자가 등장했음을 저장
				seen[curr - 'a'] = true;
			}
			// prev를 현재 철자로 업데이트
			prev = curr;
		}
		// 모든 문자가 그룹 단어 조건을 만족 시 true 반환
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// 입력 스트림 열기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 그룹 단어 갯수를 저장할 변수
		int count = 0;
		// N 입력 받기
		int N = Integer.parseInt(br.readLine());
		// 테스트 케이스 실행
		while(N-- > 0) {
			// 단어 입력 받기
			String word = br.readLine();
			// 그룹 단어 조건 만족 시 count++
			if ( isGroupWord(word) ) count++;
		}
		// 출력 하기
		System.out.println(count);
		// 입력 스트림 닫기
		br.close();
	}
}
