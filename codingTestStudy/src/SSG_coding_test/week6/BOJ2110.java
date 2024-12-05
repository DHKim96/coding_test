package SSG_coding_test.week6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
	/*
	 * [BOJ]2110 : 공유기 설치
	 * 
	 * 이분 탐색
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 하나 "이상"의 공백을 사이에 두고 주어짐
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken()); // 집의 개수
		int C = Integer.parseInt(stk.nextToken()); // 공유기의 개수
		
		// 집의 좌표 x를 담을 정수형(x <= 10억) 배열 생성
		int[] xArr = new int[N];
		
		// 좌표 입력 받기
		for(int i = 0; i < N; i++) {
			xArr[i] = Integer.parseInt(br.readLine()); 
		}
		
		// 이분 탐색 을 위해 좌표 오름차순 정렬하기
		Arrays.sort(xArr);
		
		// 최댓값 : 가장 가까운 집에 설치, 가장 먼 집에 설치
		int right = xArr[N - 1] - xArr[0];
		
		// 최솟값 : 바로 인접한 집에 설치 시
		int left = 1;
		
		while(left <= right) {
			int mid = (right + left) / 2;
			
			
		}
		
		
		
		
		
		
	}

}
