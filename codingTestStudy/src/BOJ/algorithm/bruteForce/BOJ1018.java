package BOJ.algorithm.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1018 {
	/*
	 * BOJ NO.1018 : 체스판 다시 칠하기
	 * 
	 * 브루트 포스 알고리즘
	 * 
	 * (조건을 만족하는 범위 내에)모든 경우의 수를 찾기
	 */
	public static void makeModelOfBoard(char[][] model) {
	    for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	            if ((i + j) % 2 == 0) {
	                model[i][j] = 'B';
	            } else {
	                model[i][j] = 'W';
	            }
	        }
	    }
	}
	
	public static void main(String[] args) throws IOException {
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		char[][] board = new char[N][M];
		
		char[][] model = new char[8][8]; // 흑으로 시작하는 체스판
		
		makeModelOfBoard(model); // 8 x 8 체스판 만들기
		
		//  M x N 보드 입력 받기
		for(int i = 0; i < N; i++) {
			String boardCol = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = boardCol.charAt(j);
			}
		}
		
		// 2. 다시 칠해야 하는 정사각형의 갯수 구하기
		// => 미리 생성한 체스판과 입력 받은 보드를 비교
		// 체스판의 크기는 8x8 이므로 비교 시작점은 반드시 (0,0) ~ ((N-8),(M-8))(탐색 범위 설정) 
		
		int min = Integer.MAX_VALUE;
		int result = min;
		
		// 4중 반복문을 통해 시작점을 하나씩 늘려가며 브루트포스 알고리즘 적용
		for(int i = 0; i <= N-8; i++) {
			for(int j = 0; j <= M-8; j++) {
				// 흑색이 먼저 등장하는 체스판를 기준으로 같은 색의 갯수와 다른 색의 갯수 산출
				// 같은 색의 갯수는 곧 백색으로 시작하는 체스판을 기준으로 할 경우 다시 칠해야하는 타일의 갯수임
				// 따라서 둘 중의 최솟값이 곧 해당 시작점으로 탐색했을 시 다시 칠해야하는 갯수의 최솟값
				int countOfSame = 0;
				int countOfDiff = 0;
				
				for(int k = 0; k < 8; k++) {
					for(int l = 0; l < 8; l++) {
						if(board[i+k][j+l] == model[k][l]) countOfSame++;
						else countOfDiff++;
					}
				}

				min = Math.min(countOfSame, countOfDiff);
				// 해당 시작점의 최솟값을 전체 최솟값과 비교하여 최종 최솟값 산출
				result = result > min ? min : result;
				// 0일 시 이보다 더 작은 최솟값 존재할 수 없기에 바로 메소드 종료
				if(result == 0) {
					System.out.println(result);
					br.close();
					return;
				}
			}
		}
		System.out.println(result);
		br.close();
	}
}
