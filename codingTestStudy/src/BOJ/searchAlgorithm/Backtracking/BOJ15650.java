package BOJ.searchAlgorithm.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ15650 {
	/*
	 * BOJ NO.15650 : N과 M (2)
	 * 백트래킹 문항
	 * 1. 1 ~ N개 자연수 중 중복 없이 M개 고른 수열 NCM
	 * 		=> n! / (n - m )! * m!
	 * 2. 고른 수열은 오름차순일 것
	 * 		=> 직전의 고른 수보다 크면 바로 가지치기
	 * 		=> 방문 배열 필요 없음
	 */
	
	private static int N; // 자연수
	private static int M; // 갯수
	private static int[] result; // 결과 담는 수열
	private static StringBuilder sb;
	
	public static void backtracking(int start, int depth) {
		if(depth == 0) {
			for(int num : result) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			result[M - depth] = i;
			
			backtracking(i + 1, depth - 1);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		
		// 자연수 N, 수열의 갯수 M 입력 받기
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		result = new int[M];
		sb = new StringBuilder();
		
		backtracking(1, M);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
}
