package BOJ.dynamicProgramming;

import java.io.*;

public class BOJ9184 {
    /*
        * 신나는 함수 실행
        * => DP
     */
    static int[][][] wArr = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        initializeWArr(); // 배열 초기화
        
        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        
        while(a != -1 || b != -1 || c != -1) {

            sb.append("w(").append(a).append(", ")
                    .append(b).append(", ")
                    .append(c).append(") = ").append(w(a,b,c));
            sb.append("\n");

            input = br.readLine().split(" ");

            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int w(int a, int b, int c) {
        // 나눌 수 있는 가장 작은 부분에서 점차 큰 부분으로 확장하며
        // 이전의 값들을 재사용
        // if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns: 1
        // if a > 20 or b > 20 or c > 20, then w(a, b, c) returns: w(20, 20, 20)
        // 인덱스 20까지만 있으면 됨
        
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);  // 20을 넘는 경우 w(20, 20, 20) 반환
        }

        return wArr[a][b][c];
    }

    // 배열을 한 번만 계산하여 초기화
    static void initializeWArr() {
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        wArr[i][j][k] = 1;
                    } else if (i < j && j < k) {
                        wArr[i][j][k] = wArr[i][j][k - 1] + wArr[i][j - 1][k - 1] - wArr[i][j - 1][k];
                    } else {
                        wArr[i][j][k] = wArr[i - 1][j][k] + wArr[i - 1][j - 1][k] + wArr[i - 1][j][k - 1] - wArr[i - 1][j - 1][k - 1];
                    }
                }
            }
        }
    }
}
