package BOJ.algorithm.sort;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ2750 {
	/*
	 * BOJ NO.2750 : 수 정렬하기
	 * 
	 * 오름차순 정렬 
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 삽입 정렬
		for(int i = 1; i < N; i++) {
			int key = arr[i]; // 정렬할 요소 선택
			
			int j = i - 1;
			
			// 선택한 요소를 정렬된 부분과 비교하여 적절한 위치에 삽입
			// 키가 이전 원소보다 크기 전까지 반복
			while(j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j]; // 요소를 한 칸씩 뒤로 이동
				j--;
			}
			
			// arr[j] 보다 크기 전까지 반복했으니 j번째 원소 뒤에 삽입
			arr[j + 1] = key; // 뒤로 이동 시키고 남은 자리에 선택한 요소 삽입
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int num : arr) {
			sb.append(num).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		sc.close();
	}
}
