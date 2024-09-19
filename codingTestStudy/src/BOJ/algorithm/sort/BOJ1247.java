package BOJ.algorithm.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1247 {
	/*
	 * BOJ NO.1247 : 소트인사이드
	 *  내림차순 정렬
	 *  => 병합 정렬
	 */
	private static int[] sorted; // 합치는 과정에서 정렬하여 원소 담을 임시 배열 생성
	
	/**
	 * 병합 정렬하는 메소드
	 * @param a : 정렬할 배열
	 * @param left : 배열의 시작점
	 * @param right : 배열의 끝점
	 */
	public static void mergeSort(int a[], int left, int right) {
		// 시작점과 끝점이 같은 경우 == 부분리스트가 원소가 1개인 배열인 경우 재귀 탈출
		if(left == right) return;
		
		int mid = (left + right) / 2; // 절반 위치
		
		mergeSort(a, left, mid); // 시작점 ~ 절반까지의 부분리스트		
		mergeSort(a, mid + 1,  right); // 절반 + 1  ~ 끝점까지의 부분리스트
		
		merge(a, left, mid, right); // 병합
	}
	
	/**
	 * 병합하는 메소드
	 * @param a
	 * @param left
	 * @param mid
	 * @param right
	 */
	public static void merge(int[] a, int left, int mid, int right){
		int l = left; // 왼쪽 부분리스트의 시작점
		int r = mid + 1; // 오른쪽 부분리스트의 시작점
		int idx = left; //  채워 넣을 배열의 인덱스
		
		while(l <= mid && r <= right) {
			// 부분리스트의 각 인덱스의 크기를 비교해서 큰 값들을 임시 배열에 삽입(내림차순)
			if(a[l] >= a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;
			} else {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		
		// 배열에 채워 넣는 과정에서 한 쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 
		// 나머지 부분리스트의 원소들을 새 배열에 넣는 작업 필요
		
		// 오른쪽 부분리스트의 원소가 남았을 시 나머지 원소들을 배열에 넣기
		if(l > mid) {
			while(r <= right) {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		// 왼쪽 부분리스트의 원소가 남았을 시 ~
		} else {
			while(l <= mid) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
		}
		
		/*
		 * 정렬된 새 배열을 기존 배열에 복사하여 옮겨주기
		 */
		
		for(int i = left; i <= right; i++) {
			a[i] = sorted[i];
		}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int size = String.valueOf(N).length();
		
		sorted = new int[size];
		
		int[] a = new int[size];
		
		while(N > 0 && size > 0) {
			int digit = N % 10;
			N = (N-digit) / 10;
			a[size-1] = digit;
			size--;
		}
		
		mergeSort(a, 0, a.length - 1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int num : a) {
			sb.append(num);
		}
				
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
}
