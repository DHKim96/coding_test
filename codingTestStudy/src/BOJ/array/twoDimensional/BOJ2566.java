package BOJ.array.twoDimensional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2566 {
	/*
	 * BOJ NO.2566 : 최댓값
	 * 
	 * 1. 9x9 격자판의 수 입력 받기
	 * 2. 최댓값 찾기
	 * 	2.1. 최댓값과 행,열의 수를 저장할 배열 생성
	 * 	2.2. 81개의 수를 모두 탐색하며 최댓값 찾기
	 * 	2.2. 최댓값 발견 시 최대값과, 해당 행/열의 수를 배열에 저장
	 * 3. 최대값, 행/열 출력
	 */
	
	public static void main(String[] args) throws IOException{
		// 스트림 열기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 격자판
		int[][] box = new int[9][9];
		
		// 최대값,행,열 저장할 변수 생성
		int max = -1; // 최대값이 0인 경우를 가려내기 위함
		int maxRow = 0;
        int maxCol = 0;
		
		
		// 격자판에 숫자 입력 및 최대값 찾기
		for ( int i = 0; i < box.length; i++ ) {
			String[] rows = br.readLine().split(" ");
			for (int j = 0; j < box[i].length; j++ ) {
				int num = Integer.parseInt(rows[j]);
				box[i][j] = num;
				if ( num > max ) {  
					max = num;
					maxRow = i + 1; // 1열 1행부터 시작하기에 각 행/열에 +1
					maxCol = j + 1;
				}
			}
		}
		
		
		// 최댓값 출력하기
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n");
		sb.append(maxRow).append(" ").append(maxCol);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
