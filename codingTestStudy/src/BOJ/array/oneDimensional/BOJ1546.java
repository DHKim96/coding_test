package BOJ.array.oneDimensional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1546 {
	/*
	 * 백준 no.1546 : 평균
	 * 
	 *  1. 점수 중에 최댓값 M 고르기
	 *  2. 모든 점수를 (점수/M)*100 으로 고치기
	 *  3. 고친 점수들로 새로운 평균 구하기
	 *  4. 실제 정답과 출력값의 오차는 10^-2 이하
	 */
	// 시험 본 과목의 갯수
	private static int N;
	// 과목의 점수들을 넣을 배열
	private static double[] scores;
	// 최댓값
	private static double max;
	
	/**
	 * 최댓값 구하는 메소드
	 */
	public static void calcMax() {
		for(double score : scores) {
			max = score > max ? score : max;
		}
	}
	
	/**
	 * 모든 점수를 (점수/M)*100 으로 고치는 메소드
	 */
	public static void manipulate() {
		double temp = 0;
		for(int i = 0; i < scores.length; i++) {
			temp = scores[i] / max * 100;
			scores[i] = temp;
		}
	}
	
	public static double calcAverage() {
		double sum = 0;
		for(double manipulScore : scores) {
			sum += manipulScore;
		}
		return sum / N;
	}
	
	public static void main(String[] args) throws IOException { // 스트림 예외처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 과목의 점수들을 넣을 배열
		scores = new double[N];
		
		max = 0;
		// 과목 점수들을 입력받음
		String[] strs = br.readLine().split(" ");
		// 반복문 통해 점수 넣기
		for(int i = 0; i < scores.length; i++) {
			scores[i] = Integer.parseInt(strs[i]);
		}
		
		// 1. 최댓값 M 구하기
		calcMax();
		
		// 2. 모든 점수를 (점수/M)*100 으로 고치기
		manipulate();
		
		// 3. 고친 점수들로 새로운 평균 구하기
		double average = calcAverage();
		System.out.println(average);
		br.close();
	}
}
