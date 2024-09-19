package BOJ.array.twoDimensional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2738 {
	/*
	 * BOJ NO.2738 : 행렬 덧셈
	 * 
	 * 1. 2차원 행렬 A,B 크기 입력 받기
	 * 2. 2차원 행렬 A,B의 원소 입력 받기 => A만 만들고 B의 값을 바로 A에 더하기
	 * 3. A,B 행렬의 같은 INDEX에 있는 행의 원소 더하기 => 위 방법 사용시 2,3 과정 하나로 단축 가능
	 * 4. 출력하기
	 */
	
	public static void main(String[] args) throws IOException{
		// 스트림
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 행렬 크기 입력 받기
		String[] sizes = br.readLine().split(" ");
		int N = Integer.parseInt(sizes[0]);
		int M = Integer.parseInt(sizes[1]);
		
		// 2차원 행렬 A
		int[][] A = new int[N][M];
		
		// A에 A와 B의 합을 바로 저장
		for ( int i = 0; i < N; i++ ) {
			String[] numsA = br.readLine().split(" ");
			for ( int j = 0; j < M; j++ ) {
				A[i][j] = Integer.parseInt(numsA[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
            String[] numsB = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                A[i][j] += Integer.parseInt(numsB[j]);
            }
        }
		
		// 스트림 닫기
		br.close();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
}
