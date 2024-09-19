package BOJ.algorithm.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10989 {
	/*
	 * BOJ NO.10989 : 수 정렬하기 3
	 *  시간복잡도가 O(n + k)인 정렬 알고리즘 사용
	 *  => 카운트 정렬
	 */
	
	private static int[] countingArr;
	private static int[] result;
	
	public static void countingSort(int[] inputArr, int max) {
		countingArr = new int[max + 1];
		result = new int[inputArr.length];
		
		// 1. 입력 배열의 값을 index 로 갖는 카운팅 배열의 값 1씩 증가
		for(int i = 0; i < inputArr.length; i++) {
			countingArr[inputArr[i]]++;
		}
		
		// 2. 카운팅 배열을 누적합 배열로 전환
		// 이전 좌표의 원소의 갯수를 더해나감
		// 누적합 배열은 곧 정렬된 배열의 앞에서부터 몇 개 자리를 차지할 것인지를 의미
		for(int i = 1; i < countingArr.length; i++) {
			countingArr[i] += countingArr[i - 1];
		}
		
		// 3. 정렬 배열 생성
		// 입력 배열의 각 원소에 대해 카운팅 배열에 조회하여 어느 좌표로 들어가야 하는지 체크한 뒤
		// 조회된 원소의 갯수를 1 감소시켜 앞의 좌표로 입력받을 수 있게 함
		for(int i = result.length - 1; i >= 0; i--) {
			int value = inputArr[i];
			countingArr[value]--; // 원소 하나를 정렬했기 때문에 누적합에서 줄여줘야 함
			result[countingArr[value]] = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] inputArr = new int[N];
		
		int max = Integer.MIN_VALUE; // 카운팅 배열 생성 위한 입력 배열의 최댓값 저장할 변수 
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			inputArr[i] = num;
			max = Math.max(max, num);
		}
		
		countingSort(inputArr, max);
		
		StringBuilder sb = new StringBuilder();
		
		for(int num : result) {
			sb.append(num).append("\n");
		}
				
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
