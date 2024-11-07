package BOJ.algorithm.greedy;

import java.io.*;
import java.util.Arrays;

public class BOJ13164 {
    // 행복 유치원

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 유치원 원생 수
        int K = Integer.parseInt(input[1]); // 나누려는 조의 개수

        int[] heights = new int[N]; // 원생들의 키를 담은 배열(오름차순 정렬)

        int[] diffs = new int[N - 1]; // 키 차이를 담은 배열

        String[] line = br.readLine().split(" ");

        for (int i = 0; i < N; i++){
            heights[i] = Integer.parseInt(line[i]);
        }

        for (int i = 0; i < N - 1; i++){
            diffs[i] = heights[i + 1] - heights[i];
        }

        int totalCost = 0;

        // => k 개의 조를 편성하기 위해서는 k - 1의 지점에 구분선을 마련(차이 제외)
        // ==> 가장 큰 k - 1 개의 차이를 제외하고 남은 차이의 합산

        // 차이 배열의 크기 N - 1개에서 가장 큰 값 K - 1 개 제외

        Arrays.sort(diffs);

        for (int i = 0; i <  (N - 1) - (K - 1); i++){
            totalCost += diffs[i];
        }

        bw.write(totalCost + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
