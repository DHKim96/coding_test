package cjOliveNetworks;

import java.io.*;

public class Question2 {
    /*
        빌딩 청소 아르바이트를 하려고 한다. 2차원 행렬의 빌딩의 각 칸은 창문을 의미하며, 각 칸의 숫자는 해당 창문 청소 시 지급받는 비용이다(청소가 필요 없는 창문일 시 0 ). 청소 시 곤돌라를 타고 창문을 이동할 수 있는데, 항상 맨 좌측 최상단에서 시작하며 곤돌라는 우측 또는 하단 방향으로만 1칸씩 이동 가능하며 이동 시에는 비용이 소모된다.
        창문 청소비가 담긴 2차원 배열 cost,  우측 한 칸 이동 시 소모 비용 xcost, 하단 한 칸 이동 시 소모 비용 ycost 가 주어질 때, 맨 좌측 최상단 창문에서 지상까지 창문을 닦으며 벌 수 있는 최대 이익을 구하시오(단,  이익이 없거나 손해일 시 0을 반환할 것)
        조건은 다음과 같다.
        1<= cost 행, 열 <= 1000
        1<= cost의 원소 <= 1000
        0<= xcost <= 1000
        0<= ycost <= 1000
     */
    private static int[] dx = {0, 1}; // 우측, 하단
    private static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] dimensions = br.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] cost = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                cost[i][j] = Integer.parseInt(row[j]);
            }
        }

        String[] costs = br.readLine().split(" ");
        int xcost = Integer.parseInt(costs[0]);
        int ycost = Integer.parseInt(costs[1]);

        int maxProfit = solution(cost, xcost, ycost);

        bw.write(String.valueOf(maxProfit));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solution(int[][] cost, int xcost, int ycost) {
        // TODO: 최대 이익 계산 로직 구현

        // Dp

        int row = cost.length;

        int[][] dp = new int[row][]; // 이익 저장할 배열

        for (int i = 0; i < row; i++) {
            dp[i] = new int[cost[i].length];
        }




//        int totalCost = cost[0][0];
//
//        // 그리디? 당장 최선의 이익의 합이 최대 이익?
//
//        int currRow = 0;
//        int currCol = 0;
//
//        while (currRow < cost.length && currCol < cost[0].length) {
//            int rightCost = 0;
//            int downCost = 0;
//
//            for (int i = 0; i < 2; i++){
//                int nextRow = currRow + dx[i];
//                int nextCol = currCol + dy[i];
//
//                if (nextRow < cost.length && nextCol < cost[nextRow].length) {
//                    if(i == 0) rightCost = cost[nextRow][nextCol] - xcost;// 우측 이동
//                    else downCost = cost[nextRow][nextCol] - ycost; // 하단 이동
//                }
//            }
//
//
//            if (rightCost >= downCost) { // 우측 이동 시 이익이 크다면 우측 이동
//                currRow += dx[0];
//                currCol += dy[0];
//                totalCost += rightCost;
//                System.out.println("right" + totalCost);
//            } else { // 하단 이동 시 이익이 더 크다면 하단 이동
//                currRow += dx[1];
//                currCol += dy[1];
//                totalCost += downCost;
//                System.out.println("down" + totalCost);
//            }
//
//
//            while(currRow == cost.length - 1 && currCol < cost[currRow].length - 1) { // 지상층 도착 시
//                int nextRow = currRow + dx[0];
//                int nextCol = currCol + dy[0];
//
//                rightCost = cost[nextRow][nextCol] - xcost;
//
//                if (rightCost >= 0) {
//                   currRow += dx[0];
//                   currCol += dy[0];
//
//                   totalCost += rightCost;
//                   System.out.println("right" + totalCost);
//               }
//            }
//        }
//
//        if (totalCost <= 0 ) totalCost = 0;
//
//        return totalCost;
    }

}
