package BOJ;

import java.io.*;

public class Main {
    /*
      BOJ NO.1929 : 소수 구하기
        M 이상 N 이하의 소수 모두 출력하는 프로그램
        => 에라토스테네스의 체 이용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // M, N 입력 받기
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        // 소수 판별할 배열 생성(동적 초기화)
        boolean[] isPrime = new boolean[N + 1];
        
        // 에라토스테네스의 체 알고리즘 실행
        eratosthenes(isPrime, N);
        
        // M 이상 N 이하 소수 출력
        StringBuilder sb = new StringBuilder();
        for(int i = M; i <= N; i++){
            if(isPrime[i]) sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 에라토스테네스의 체 알고리즘 구현
    // 소수의 배수는 소수가 아니다
    public static void eratosthenes(boolean[] isPrime, int N){
        for(int i = 2; i <= N; i++){ 
            isPrime[i] = true; // 0,1 제외한 모든 정수를 소수로 가정
        }

        for(int i = 2; i * i <= N; i++){
            if(isPrime[i]){
                for(int j = i * i; j <= N; j += i){
                    // 2일 경우 4부터 시작, 3일 경우 9부터 시작(6은 2의 배수 제거시 제거) ...
                    // 따라서 i의 거듭제곱부터 제거(그 이전의 수들은 이전 수의 배수들을 제거하는 작업에서 이미 걸러짐)
                    isPrime[j] = false;
                }
            }
        }
    }
}
