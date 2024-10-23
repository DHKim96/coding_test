package SSG_coding_test.week2;

import java.io.*;

public class BOJ1303 {
    /*
        * 전쟁 - 전투
        *   N명이 뭉쳐있을 때(대각선 제외) N^2의 위력
        *   => 뭉쳐있는 인원 파악 ==> dfs
     */
    static char[][] battle; // 전쟁터
    static boolean[][] visited; // 방문 배열
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 전쟁터 가로
        int M = Integer.parseInt(input[1]); // 전쟁터 세로

        battle = new char[N][M];
        visited = new boolean[N][M];

        count = 0;

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
               battle[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0);

        System.out.println(count);

        br.close();
    }

    public static void dfs(int x, int y) {
        if (!canMove(x,y)) return;

        for(int i = x; i < battle.length; i++) {
            for(int j = y; j < battle.length; j++) {
                if (visited[i][j]) continue;
                count++;

                dfs(i, j);

            }
        }
    }

    // 진행할 수 있는지 확인
    public static boolean canMove(int x, int y){
        // 상
        if (x > 0 && ( !visited[x - 1][y] || battle[x - 1][y] != 'W' )){
            return true;
        }
        // 하
        if (x < battle.length - 1 && (!visited[x + 1][y] || battle[x + 1][y] != 'W')){
            return true;
        }
        // 좌
        if (y > 0 && (!visited[x][y - 1] || battle[x][y - 1] != 'W')){
            return true;
        }
        // 우
        if (y < battle.length - 1 && (!visited[x][y + 1] || battle[x][y + 1] != 'W')){
            return true;
        }

        return false;
    }

}
