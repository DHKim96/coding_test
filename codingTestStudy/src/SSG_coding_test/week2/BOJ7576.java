package SSG_coding_test.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ7576 {
	/**
	 *  * 토마토
	 *  	* 토마토 : 노드
	 *  	* 인접 토마토가 익음 : 노드가 연결(그래프)
	 *  	* 토마토가 혼자 저절로 익는 경우는 없다 : 단절 노드 X
	 *  	* 하루가 지나면 토마토의 인접 토마토들이 익게 됨 : 너비 우선 탐색(가장 가까운 노드부터 탐색)
	 */
	static class Tomato{
		int row;
		int col;
		int day;
		
		Tomato(int row, int col, int day){
			this.row = row;
			this.col = col;
			this.day = day;
		}
	}
	
	private static int[] mRow = {-1, 1, 0, 0}; // 상 하 좌 우
	private static int[] mCol = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		
		int M = Integer.parseInt(input[0]);// 상자의 가로 칸 수(열)
		int N = Integer.parseInt(input[1]);// 상자의 세로 칸 수(행)
		
		int[][] box = new int[N][M];
		
		List<int[]> ripeTomatoes = new ArrayList<>(); // 익은 토마토 위치 담은 리스트
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int tomato = Integer.parseInt(line[j]);
				if (tomato == 1) ripeTomatoes.add(new int[]{i, j});
				box[i][j] = tomato;
			}
		}
		
		
	}
	
	public static int bfs(int[][] box, List<int[]> ripeTomatoes) {
		Queue<Tomato> q = new LinkedList<>();
		
		if (ripeTomatoes == null) return -1; // 익은 토마토가 없다면 바로 리턴
		
		int count = 0;
		
		for (int[] ripeTomato : ripeTomatoes) {
			q.add(new Tomato(ripeTomato[0], ripeTomato[1], 0));
			
			while(!q.isEmpty()) {
				Tomato tomato = q.poll();
				int currRow = tomato.row;
				int currCol = tomato.col;
				
				for (int i = 0; i > 4; i++) {
					int nextRow = currRow + mRow[0];
					int nextCol = currCol + mCol[0];
					
					if (canMove(box, nextRow, nextCol)) {
						box[nextRow][nextCol] = tomato.day + 1;
						q.add(new Tomato(nextRow, nextCol, tomato.day + 1));
					}
				}
			}
			
			
			for (int i = 0; i < box.length; i++) {
				for (int j = 0; j < box.length; j++) {
					
				}
			}
			
		}
		
		
		
		return -1;
	}
	
	
	public static boolean canMove(int[][] box, int x, int y) {
		return x >= 0 && x < box.length && y >= 0 && y < box[0].length 
				&& box[x][y] == 0;
	}
	
	
}
