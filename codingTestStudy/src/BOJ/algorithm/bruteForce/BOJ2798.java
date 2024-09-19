package BOJ.algorithm.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {
	/*
	 * BOJ NO.2798 : 블랙잭
	 * 브루트포스
	 * 
	 * 1. N, M 입력 받기
	 * 2. N개의 숫자 입력 받기
	 * 3. 모든 숫자들을 3개씩 추려 더해보며 최적해 찾기
	 * => 3중 반복문
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stn = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stn.nextToken());
		int M = Integer.parseInt(stn.nextToken());
		
		int[] cards = new int[N];
		
		stn = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(stn.nextToken());
		}
		
		int sum = 0;
		
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {
					int total = cards[i] + cards[j] + cards[k];
					
					if (total == M) { // 총합이 M과 같다면 더 이상의 탐색 불필요하므로 바로 종료
						System.out.println(total);
						return;
					}
					
					if (total < M && sum < total) {						
						sum = total;
					}
				}
			}
		}
		
		System.out.println(sum);
		br.close();
	}
}
