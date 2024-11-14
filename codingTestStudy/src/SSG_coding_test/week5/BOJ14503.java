package SSG_coding_test.week5;

<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
=======
import java.io.*;
import java.util.StringTokenizer;

public class BOJ14503 {
    /*
        * [BOJ]14503 : 로봇 청소기
           => dfs
    */
    private static final int[] dRow = {-1, 0, 1, 0}; // 북 동 남 서
    private static final int[] dCol = {0, 1, 0, -1}; // 북 동 남 서

    private static int[][] room;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // row N
        int M = Integer.parseInt(input[1]); // col M
>>>>>>> 1d8177278d2cbf3c9d2fa0bb4dfbfebe5065c2ed

        room = new int[N][M];
        count = 0;

<<<<<<< HEAD
        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()); // 로봇 청소기가 위치한 행
        int c = Integer.parseInt(st.nextToken()); // 로봇 청소기가 위치한 열
        int d = Integer.parseInt(st.nextToken()); // 로봇 청소기의 방향

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
=======
        input = br.readLine().split(" ");

        int r = Integer.parseInt(input[0]); // 로봇 청소기가 위치한 행
        int c = Integer.parseInt(input[1]); // 로봇 청소기가 위치한 열
        int d = Integer.parseInt(input[2]); // 로봇 청소기의 방향

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
>>>>>>> 1d8177278d2cbf3c9d2fa0bb4dfbfebe5065c2ed

            for (int j = 0; j < M; j++){
                room[i][j] = Integer.parseInt(st.nextToken()); // 0 : 미청소 / 1 : 벽
                // 방의 가장 북쪽, 가장 남쪽, 가장 서쪽, 가장 동쪽 줄 중 하나 이상에 위치한 모든 칸에는 벽
            }
        }

<<<<<<< HEAD
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
=======
        dfs(r, c, d);

        // 작동을 멈출 때까지 청소하는 칸의 갯수 출력
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int r, int c, int d){
        // 현재 칸이 아직 청소되지 않은 경우 현재 칸 청소
        if (canClean(r, c)) {
            count++;
            room[r][c] = 2; // 청소 처리
        }

        boolean canClean = false;

        int nextRow = -1;
        int nextCol = -1;

        // 청소 가능 여부 확인
        for (int i = 0; i < 4; i++){
            nextRow = r + dRow[i];
            nextCol = c + dCol[i];

            if (canClean(nextRow, nextCol)){
                canClean = true;
                break;
            }
        }

        // 청소되지 않은 빈 칸이 없는 경우
        if (!canClean){
            // 후진 = 반대 방향으로 이동 => (d + 2) % 4 인 인덱스
            // 후진은 곧 방향은 그대로
            nextRow = r + dRow[(d + 2) % 4];
            nextCol = c + dCol[(d + 2) % 4];
            // 후진 가능 여부 확인
            if (canMove(nextRow, nextCol)){
                dfs(nextRow, nextCol, d);
            } else {
                // 뒤쪽 칸이 벽이라 후진할 수 없다면 작동 중단
                return;
            }
        } else {
            // 청소되지 않은 빈 칸이 존재할 경우
            // 반시계 방향으로 회전
            d = ((d - 1) + 4 ) % 4;
            // 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
            nextRow = r + dRow[d];
            nextCol = c + dCol[d];

            while(!canClean(nextRow, nextCol)){
                d = ((d - 1) + 4 ) % 4;
                nextRow = r + dRow[d];
                nextCol = c + dCol[d];
            }

            // 탈출하면 곧 해당 row, col 은 청소 가능 칸
            dfs(nextRow, nextCol, d);
        }
    }

    // 주변에 청소 가능 칸 존재 여부
    public static boolean canClean(int r, int c){
        return r < room.length && r >= 0 && c < room[r].length && c >= 0 && room[r][c] == 0;
    }

    // 이동 가능 여부
    public static boolean canMove(int r, int c){
        return r < room.length && r >= 0 && c < room[r].length && c >= 0 && room[r][c] != 1;
    }
}

>>>>>>> 1d8177278d2cbf3c9d2fa0bb4dfbfebe5065c2ed
