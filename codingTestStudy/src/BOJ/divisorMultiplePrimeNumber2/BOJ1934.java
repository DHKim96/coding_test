package BOJ.divisorMultiplePrimeNumber2;

import java.io.*;

public class BOJ1934 {
    /*
      BOJ NO.1934 : 최소공배수
      ==> 유클리드 호제법 이용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            int lcm = calcLcm(A, B);
            sb.append(lcm + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     *  유클리드 호제법 활용하여 최대공약수 구하는 함수
     */
    public static int calcGcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;  // 0이 되기 전 b가 a에 대입되므로
    }

    /**
     * 최소공배수 구하는 함수
     */
    public static int calcLcm(int a, int b){
        int gcd = calcGcd(Math.max(a, b), Math.min(a, b));
        return ( a * b ) / gcd;
    }
}
