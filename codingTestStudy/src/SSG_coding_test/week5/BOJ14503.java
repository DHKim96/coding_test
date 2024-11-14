package SSG_coding_test.week5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14503 {
	/*
	 * [BOJ]14503 : 로봇 청소기 => dfs
	 */
	private static final int[] dRow = { -1, 0, 1, 0 }; // 북 동 남 서
	private static final int[] dCol = { 0, 1, 0, -1 }; // 북 동 남 서

	private static int[][] room;
	private static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // row N
        int M = Integer.parseInt(st.nextToken()); // col M

        room = new int[N][M];
        count = 0;

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()); // 로봇 청소기가 위치한 행
        int c = Integer.parseInt(st.nextToken()); // 로봇 청소기가 위치한 열
        int d = Integer.parseInt(st.nextToken()); // 로봇 청소기의 방향

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++){
                room[i][j] = Integer.parseInt(st.nextToken()); // 0 : 미청소 / 1 : 벽
                // 방의 가장 북쪽, 가장 남쪽, 가장 서쪽, 가장 동쪽 줄 중 하나 이상에 위치한 모든 칸에는 벽
            }
        }

		dfs(r, c, d);

		// 작동을 멈출 때까지 청소하는 칸의 갯수 출력
		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int r, int c, int d) {
		// 현재 위치 청소
		if (canClean(r, c)) {
			count++;
			room[r][c] = 2; // 청소 반영
		}
			

		// 4방향을 돌며 청소할 수 있는 칸을 찾음
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4; // 반시계 방향으로 회전
			int nextRow = r + dRow[d];
			int nextCol = c + dCol[d];

			// 청소할 수 있는 칸이 발견되면 이동 후 dfs 재귀 호출
			if (canClean(nextRow, nextCol)) {
				dfs(nextRow, nextCol, d);
				return; // 탐색 후 종료 (재귀에서 되돌아오므로)
			}
		}

		// 후진할 경우
		int backRow = r + dRow[(d + 2) % 4];
		int backCol = c + dCol[(d + 2) % 4];

		if (canMove(backRow, backCol)) {
			dfs(backRow, backCol, d); // 후진하고 같은 방향 유지
		}
	}

	// 주변에 청소 가능 칸 존재 여부
	public static boolean canClean(int r, int c) {
		return r < room.length && r >= 0 && c < room[r].length && c >= 0 && room[r][c] == 0;
	}

	// 이동 가능 여부
	public static boolean canMove(int r, int c) {
		return r < room.length && r >= 0 && c < room[r].length && c >= 0 && room[r][c] != 1;
	}
}
