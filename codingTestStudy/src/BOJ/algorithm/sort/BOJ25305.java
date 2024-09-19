package BOJ.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25305 {
	/*
	 * BOJ NO.25305 : 커트라인
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Integer[] scores = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		
		// 삽입정렬 내림차순
		for(int i = 1; i < N; i++) {
			int key = scores[i];
			int j = i - 1;
			while(j >= 0 && key > scores[j]) {
				scores[j + 1] = scores[j];
				j--;
			}
			scores[j + 1] = key;
		}
		
		System.out.println(scores[k-1]);
		
		br.close();
	}
}
