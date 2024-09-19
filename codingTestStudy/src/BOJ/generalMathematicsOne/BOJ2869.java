package BOJ.generalMathematicsOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2869 {
	/*
	 * BOJ NO.2869 : 달팽이는 올라가고 싶다.
	 * 
	 * 1. A, B, V 입력 받기
	 * 2. 반목문 통해 소요일 계산
	 * => ( V -= A ) <= 0 만족할 때 탈출
	 * => 시간 초과로 실패
	 * => 식을 만들어서 해결
	 *  (V - A) / (A - B) + 1
	 *   
	 *   도착 전 날까지 남은 거리(V - A)를 하루에 갈 수 있는 거리(A - B)로 나눈 뒤, 
	 *   올림 처리하여 필요한 전체 일수를 계산. 
	 *   마지막 날 낮에 도달하는 하루를 더하여 최종 도착일을 계산.
	 *   
	 * 3. 출력 
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
		// 스트림 열기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 받기
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int V = Integer.parseInt(input[2]);
		
		int day = (int)( Math.ceil( (double)(V-A)/(A-B) ) ) + 1; 
		
		System.out.println(day);
		br.close();
	}
}
