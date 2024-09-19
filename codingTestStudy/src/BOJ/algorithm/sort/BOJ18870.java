package BOJ.algorithm.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class BOJ18870 {
	/*
	 * BOJ NO.18870 : 좌표 압축
	 * 
	 * Set으로 중복 제거한 뒤 List 로 변한 후 Collections.sort로 정렬 후 인덱스값으로 좌표 압축 가능
	 * => 시간 초과
	 * 
	 * 병합 정렬로 좌표 정렬 후 Map<좌표, 좌표의 순위값> 으로 좌표 압축
	 * => 성공
	 * => Arrays.sort() 보다 더 효율적
	 */
	private static int[] temp;
	
	public static void mergeSort(int[] a, int left, int right) {
		if(left >= right) return;
		
		int mid = (left + right) / 2;
		
		// 왼쪽과 오른쪽 부분리스트로 분할
		mergeSort(a, left, mid);
		mergeSort(a, mid + 1, right);
		
		// 병합
		merge(a, left, mid, right);
	}
	
	public static void merge(int[] a, int left, int mid, int right) {
		int l = left; // 왼쪽 부분리스트의 시작점
		int r = mid + 1; // 오른쪽 부분리스트의 시작점
		int idx = left; // 인덱스
		
		while(l <= mid && r <= right) { // 왼쪽 부분리스트의 인덱스는 mid + 1보다 작야아 함 , 오른쪽도 ~
			if(a[l] > a[r]) { // 두 부분리스트 중 더 작은 값을 temp에 먼저 넣기
				temp[idx] = a[r];
				r++;
				idx++;
			} else {
				temp[idx] = a[l];
				l++;
				idx++;
			}
		}
		
		if(l > mid) { // 왼쪽 부분리스트가 다 temp에 넣어졌을 때
			// 오른쪽 부분리스트의 남은 값들을 temp 에 넣기
			while(r <= right) {
				temp[idx] = a[r];
				r++;
				idx++;
			}
		} else {
			while(l <= mid) {
				temp[idx] = a[l];
				l++;
				idx++;
			}
		}
		
		 // 정렬된 새 배열을 기존의 배열에 복사하여 옮겨주기
		for(int i = left; i <= right; i++) {
			a[i] = temp[i];
		}
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] input = new int[N];
        
        int[] sorted = new int[N];
        
        temp = new int[N];
        
        String[] arr = br.readLine().split(" ");
        
        // 입력 받기
        for(int i = 0; i < N; i++) {
        	int num = Integer.parseInt(arr[i]);
        	input[i] = num;
        	sorted[i] = num; // 정렬한 결과를 저장하기 위한 복사본 생성
        }
        
        // 병합 정렬(오름차순)
        mergeSort(sorted, 0, N-  1);
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        
        // 중복을 제거하면서 좌표 압축을 위한 순위 매핑
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int num: sorted) {
        	if(!map.containsKey(num)) {
        		map.put(num, rank++);
        	}
        }
        
        // 좌표의 순위값 출력
        for(int num : input) {
        	sb.append(map.get(num)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
