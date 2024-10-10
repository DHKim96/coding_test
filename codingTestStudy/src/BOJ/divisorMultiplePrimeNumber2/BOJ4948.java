package BOJ.divisorMultiplePrimeNumber2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ4948 {
	/*
    BOJ NO.4948 : 베르트랑 공준
      자연수 n보다 크고, 2n보다 작거나 같은 소수의 갯수를 구하는 프로그램
      => 에라토스테네스의 체 이용
   */
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
              
      StringBuilder sb = new StringBuilder();
      
      // 주어진 최대 범위까지의 소수들을 미리 계산
      // => 테스트케이스마다 계산하는 경우보다 메모리, 시간 측면에서 약 30% ~ 40% 단축
      int max = 123456;
      int maxRange = max * 2;
      
     	boolean[] isPrime = new boolean[maxRange + 1];
     	
     	eratosthenes(isPrime, maxRange);
     	
      while(true) {
      	int count = 0;
      	
      	int N = Integer.parseInt(br.readLine());
      	// 0일 경우 탈출
      	if (N == 0) break;
      	
          for(int i = N + 1; i <= 2 * N; i++){
              if(isPrime[i]) count++;
          }
          // 출력
          sb.append(count).append("\n");
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
          isPrime[i] = true; // 2 ~ 2 * N 의 모든 정수를 소수로 가정
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
