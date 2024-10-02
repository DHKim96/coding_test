package BOJ.divisorMultiplePrimeNumber2;

import java.io.*;

public class BOJ13909 {
    /*
   BOJ NO.13909 : 창문 닫기
    약수의 갯수가 짝수 / 홀수 일때 최종적으로 창문이 close / open
    => 대체로 약수의 갯수는 짝수임 ex) 12 = (1, 12) (2, 6) (3, 4)
    => 허나 제곱수(어떤 정수를 제곱한 결과로 나오는 수)인 경우 약수의 갯수는 홀수
     why? (제곱근 * 제곱근) 즉, 중복된 제곱근이 약수 중 하나이기에
    => 오직 제곱수일 경우만 약수의 갯수가 홀수이므로
       본 문항은 곧 N까지의 제곱수의 갯수 구하기와 동일
  */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // N까지의 제곱수의 갯수 구하기
        int count = countSquare(N);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    //  제곱수 갯수 구하기
    public static int countSquare(int N) {
        int count = 0;

        for (int i = 1; i * i <= N; i++) { // 제곱근의 갯수와 동일
            count++;
        }

        return count;
    }
}
