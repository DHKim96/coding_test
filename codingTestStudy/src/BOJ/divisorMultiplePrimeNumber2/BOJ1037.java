package BOJ.divisorMultiplePrimeNumber2;

import java.io.*;

public class BOJ1037 {
    /*
        BOJ NO.1037 : 약수
        1과 자기 자신을 제외한 약수(진짜 약수)가 주어질 때 해당 조건을 만족하는 수 찾기

        => 가장 큰 값과 가장 작은 값을 곱해 원래 수 복원
        => 왜냐? 진짜 약수들의 곱은 항상 원래 수 N으로 복원된다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 진짜 약수의 개수
        int num = Integer.parseInt(br.readLine());

        // 약수들 입력 받기
        String[] input = br.readLine().split(" ");

        long min = Long.parseLong(input[0]);
        long max = Long.parseLong(input[0]);

        for (int i = 1; i < num; i++){
            long divisor = Long.parseLong(input[i]);
            max = Math.max(max, divisor);
            min = Math.min(min, divisor);
        }

        // 최소 약수와 최대 약수를 곱한 값이 원래 수
        long result = max * min;

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
