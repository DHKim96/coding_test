package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	/*
	 * BOJ NO.1181 : 단어 정렬
	 * 내장 정렬 메서드 사용 & 메서드 참조 방식과 compare 사용해 조건부 정렬 구현
	 */
	public static int compareWord(String word1, String word2) {
		if(word1.length() == word2.length()) { // 길이 같을 시
			return word1.compareTo(word2);  // 사전순 비교(Java.String 은 사전순 비교를 위해 compareTo 메서드 존재)
		} else {
			return Integer.compare(word1.length(), word2.length()); // 길이 비교
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        
        //입력 받기
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();            
        }

        // Arrays.sort와 메서드 참조 방식 사용하여 정렬(람다식도 사용 가능)
        Arrays.sort(arr, Main::compareWord);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        
        sb.append(arr[0]).append("\n");
        
        for (int i = 1; i < N; i++) {
        	// 중복 단어 무시
        	if(arr[i].equals(arr[i-1])) continue;
        	
            sb.append(arr[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
