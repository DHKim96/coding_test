package BOJ;

import javax.swing.*;
import java.io.*;

public class Main {
    /*
      BOJ NO.2485 : 가로수
      n번째 가로수와 n+1번째 가로수의 거리 차를 d(n) 라고 할 때
      d1, d2, ..., d(n) 의 최대공약수가 모든 가로수가 같은 간격이 되도록 새로 심어햐 하는 가로수의 최소 거리
      ==> 최소 거리를 통해 필요한 가로수의 갯수를 구할 수 있음
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 심어져 있는 가로수의 수
        int N = Integer.parseInt(br.readLine());

        // 심어져 있는 가로수들의 위치 담을 배열
        int[] trees = new int[N];
        
        trees[0] = Integer.parseInt(br.readLine());

        // 각 가로수의 거리차 담을 배열
        int[] distance = new int[N-1];

        for(int i = 1; i < N; i++) {
            // 가로수 위치 입력받기
            trees[i] = Integer.parseInt(br.readLine());
            // 거리차
            int minus = trees[i] - trees[i-1];
            // 배열에 저장
            distance[i-1] = minus;
        }

        // 각 거리차들의 최대공약수 구하기
        int gcd = calcGcd(distance[0], distance[1]);
        for(int i = 2; i < distance.length; i++) {
            gcd = calcGcd(gcd, distance[i]);
        }

        // 필요한 가로수 갯수
        int count = 0;
        
        // 최소 거리 더한 가로수 위치 저장할 변수
        int location = 0;

        for(int i = 0; i < trees.length - 1; i++) {
            location = trees[i] + gcd;
            while (location != trees[i + 1]){
                count++;
                location += gcd;
            }
        }
        
        // 출력
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // 유클리드 알고리즘을 활용한 최대 공약수 구하는 함수
    public static int calcGcd(int a, int b) {
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
