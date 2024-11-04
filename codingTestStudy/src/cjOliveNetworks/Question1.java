package cjOliveNetworks;

import java.io.*;

public class Question1 {
    /*
        매일의 주가가 담긴 배열 stock_price 가 주어질 때, 주가가 가장 오랫동안 연속 상승한 기간의 길이와 가장 오랫동안 연속 하락한 기간의 길이를 구하시오
        (만약 연속해서 증가하거나 감소하지 않을 시 정답 배열의 해당 위치에 1을 채움 == 2일 이상 지속적으로 증가하는 날과 감소하는 날이 없을 시 {1, 1} 반환)
        조건은 다음과 같다.
        (5 <= stock_price의 길이 <= 1000)
        (1 <= stock_price의 원소 <= 1000)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] stock_price = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            stock_price[i] = Integer.parseInt(input[i]);
        }

        int[] result = solution(stock_price);

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] solution(int[] stock_price) {
        int maxPlusDay = 1;
        int maxMinusDay = 1;

        int plusDay = 1; // 첫날부터 시작하므로 1로 설정
        int minusDay = 1;

        for (int i = 1; i < stock_price.length; i++) {
            if (stock_price[i] > stock_price[i - 1]) { // 증가 시
                plusDay++;
                minusDay = 1; // 하락 일수 초기화
                maxPlusDay = Math.max(maxPlusDay, plusDay);
            } else if (stock_price[i] < stock_price[i - 1]) { // 감소 시
                minusDay++;
                plusDay = 1; // 상승 일수 초기화
                maxMinusDay = Math.max(maxMinusDay, minusDay);
            } else { // 같을 경우
                plusDay = 1;
                minusDay = 1;
            }
        }

        return new int[]{maxPlusDay, maxMinusDay};
    }
}
