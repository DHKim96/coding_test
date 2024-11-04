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
        
        dp[0][0] = cost[0][0];
        
        // 누적 합 문제처럼 접근
        
        // 1. 첫 번째 행 초기화
        for (int i = 1; i < dp[0].length; i++) {
        	dp[0][i] = dp[0][i - 1] + cost[0][i] - xcost; 
        }
        
        // 2. 첫 번째 열 초기화
        for (int i = 1; i < row; i++) {
        	dp[i][0] = dp[i - 1][0] + cost[i][0] - ycost;
        }
        
        // 3. 누적합 채우기
        // => 위에서 하단 이동한 경우 또는 왼쪽에서 우측 이동한 경우 중 최대 이익 저장
        int rightCost = 0;
        int downCost = 0;
        
        for (int i = 1; i < row; i++) {
        	for (int j = 1; j < dp[i].length; j++) {
        		 
        		rightCost = dp[i][j - 1] + cost[i][j] - xcost;
        		downCost = dp[i - 1][j] + cost[i][j] - ycost;
        		dp[i][j] = Math.max(rightCost, downCost);
        	}
        }
        
        // 4. 최대 이익 계산
        // => 마지막 row(지상층)에서 가장 큰 값 찾기
        int answer = 0;
        
        for (int num : dp[row - 1]) {
        	answer = Math.max(answer, num);
        } // => 0보다 작은 값이 나올 경우 0이 반환이 보장됨
        
        return answer;
    }

}
