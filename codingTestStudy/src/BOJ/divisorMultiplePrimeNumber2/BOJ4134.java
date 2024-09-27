package BOJ.divisorMultiplePrimeNumber2;

import java.io.*;

public class BOJ4134 {
    /*
    BOJ NO.4134 : 다음 소수
      정수N 보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램
   */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 갯수
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 정수 N
        while (T-- > 0) {
            long N = Long.parseLong(br.readLine()); // N의 범위가 int형의 범위 넘어섬
            long decimal = findNextPrime(N); // 최소 소수 찾는 메소드 호출
            sb.append(decimal).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 소수 반환하는 메소드
    public static long findNextPrime(long num){
        if(num <= 1) return 2; // 1보다 작거나 같으면 첫 번째 소수 2 반환

        while (true) { // 소수 찾을 때까지 무한 반복
            if(isPrime(num)) return num; // 소수 찾으면 반환
            num++; // 소수가 아닐 시 다음 숫자로 넘어감
        }
    }

    public static boolean isPrime(long num){
        for(long i = 2; i * i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
