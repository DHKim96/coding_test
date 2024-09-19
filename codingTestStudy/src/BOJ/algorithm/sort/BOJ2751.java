package BOJ.algorithm.sort;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ2751 {
	/*
	 * BOJ NO.2751 : 수 정렬하기 2
	 *  시간복잡도가 O(nlogn)인 정렬 알고리즘 사용
	 *  => 합병정렬, 힙 정렬
	 *  => 합병정렬 사용시 327128 / 2220
	 *  => Arrays.sort 사용시 322436 / 2504
	 */
	private static int[] sorted; // 합치는 과정에서 정렬하여 원소 담을 임시 배열
	
	/**
	 * 
	 * @param a : 정렬 대상
	 * @param left : 배열 시작점
	 * @param right : 배열 끝 점
	 */
	public static void mergeSort(int[] a, int left, int right) {
		// 시작점과 끝점이 같은 경우 즉 원소가 1개인 배열인 경우 탈출
		if(left == right) {
			return;
		}
		
		int mid = (left + right) / 2;  // 절반 위치
		
		mergeSort(a, left, mid); // 절반 중 왼쪽 부분리스트(left ~ mid)
		mergeSort(a, mid + 1, right); // 절반 중 오른쪽 부분리스트(mid + 1 ~ right)
		
		merge(a, left, mid, right); // 병합 작업
	}
	
	
	/**
	 *  병합 작업하는 매소드(a 배열의 left ~ right)
	 * @param a
	 * @param left
	 * @param mid : 배열의 중간점
	 * @param right
	 */
	public static void merge(int[] a, int left, int mid, int right) {
		int l = left; //왼쪽 부분리스트의 시작점
		int r = mid + 1; // 오른쪽 부분리스트의 시작점
		int idx = left; // 채워 넣을 배열의 인덱스
		
		while(l <= mid && r <= right) {
		
			//부분리스트들의 각 인덱스들의 크기를 비교해서 작은 값들을 임시 배열에 삽입 
			if(a[l] <= a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;
			} else {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
			
		}
		// 배열에 채워넣는 과정에서 한 쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우
		// 나머지 부분리스트의 원소들을 새 배열에 채워 넣는 작업 필요
		
		// 오른쪽 부분리스트의 원소가 남았을 경우 나머지 원소들을 배열에 채워넣기
		if(l > mid) {
			while(r <= right) {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		// 왼쪽 부분리스트의 원소가 남았을 경우 ~
		} else {
			while(l <= mid) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
		}
		
		/*
		 * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨주기
		 */
		for(int i = left; i <= right; i++) {
			a[i] = sorted[i];
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = sc.nextInt();
		
		sorted = new int[N];
		int[] a = new int[N];
		
		
		for(int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		
		mergeSort(a, 0, a.length - 1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int num : a) {
			sb.append(num).append("\n");
		}
				
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		sc.close();
		
	}
}
