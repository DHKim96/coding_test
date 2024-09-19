package BOJ.string.advencedString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1157 {
	/*
	 * 백준 NO.1157 : 단어 공부
	 * 
	 * 1. 단어 입력 받기
	 * 2. 각 단어의 갯수 쓰기
	 * => 철자의 순서를 인덱스로 갖는 배열 생성
	 * 	 (철자 - 'A') 인덱스에 등장 횟수 넣기
	 * 3. 등장 횟수가 가장 많은 철자 추출하기
	 * 4. 출력
	 */
	
	/**
	 * 각 철자의 순번을 인덱스로 갖고 해당 철자의 등장 횟수를 값으로 갖는 배열 반환하는 메소드
	 * @param counts
	 * @param word
	 * @return
	 */
	public static int[] countSpell(int[] counts, String word) {
		for(int i = 0; i < word.length(); i++) {
			// 단어를 철자 단위로 쪼개기
			char spell = word.charAt(i);
			// 등장 횟수 + 1
			counts[spell - 'A']++;
			// int[]는 값이 없는 자리에 기본적으로 0이 들어가기 때문에 count값 초기화 필요 없음
		}
		return counts;
	}
	
	/**
	 * 배열의 값 중 최댓값을 구하는 메소드
	 * @param counts
	 * @return
	 */
	public static int calcMax(int[] counts) {
		int max = 0;
		for(int i = 0; i < counts.length; i++) {
			max = max > counts[i] ? max : counts[i];
		}
		return max;
	}
	
	/**
	 * 최대 등장하는 철자를 구하는 메소드
	 * @param counts
	 * @param max
	 * @return
	 */
	public static char getMaxSpell(int[] counts, int max) {
		// 최대 등장 횟수가 같은 철자의 횟수 저장할 변수
		int num = 0;
		char maxSpell = ' ';
		for(int i = 0; i < counts.length; i++) {
			// 최대 등장 횟수가 같은 철자의 횟수를 구하는 변수
			if(counts[i] == max) {
				num += 1;
				// 최다 등장 철자가 2개 이상일 시 바로 메소드 종료
				if(num == 2) return '?';
				// 철자를 구하는 변수
				maxSpell = (char)('A' + i);
			}
		}
		return maxSpell;
	}
	
	public static void main(String[] args) throws IOException {
		// 입력 스트림 연결
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 단어의 갯수를 세기 위한 배열 생성
		int[] counts = new int[26];
		// 단어 입력 받기(전부 대문자로 치환)
		String word = br.readLine().toUpperCase();
		br.close();
		// 각 철자별 갯수 입력 받기
		counts = countSpell(counts, word);
		// 최대 등장 횟수 구하기
		int max = calcMax(counts);
		// 등장 횟수에 따른 결과 도출하기
		char result = getMaxSpell(counts, max);
		// 출력
		System.out.println(result);
	}
}
