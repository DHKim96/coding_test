package BOJ.divisorMultiplePrimeNumber2;

import java.io.*;

public class BOJ1735 {
    /*
     BOJ NO.1735 : 분수 합
     두 분수의 합을 기약분수 형태로 만들기

     -> 분수의 합이 나온 결과의 분자, 분모의 최대공약수를 구한 뒤 해당 최대공약수로 분자, 분모 나누기
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 분수 입력
        String[] input = br.readLine().split(" ");
        int numeA = Integer.parseInt(input[0]);
        int denoA = Integer.parseInt(input[1]);

        // 두 번째 분수 입력
        input = br.readLine().split(" ");
        int numeB = Integer.parseInt(input[0]);
        int denoB = Integer.parseInt(input[1]);

        // 기약분수 계산
        int[] result = calcSumOfFractions(denoA, numeA, denoB, numeB);

        // 출력
        bw.write(result[0] + " " + result[1]);
        bw.flush();
        bw.close();
        br.close();
    }

    // 두 분수의 합을 기약분수로 계산하는 메소드
    public static int[] calcSumOfFractions(int denoA, int numeA, int denoB, int numeB) {
        // 두 분수의 합 계산
        int deno = denoA * denoB;
        int nume = ( numeA * denoB) + ( numeB * denoA );

        // 계산한 분자와 분모의 최대공약수 계산
        int gcd = calcGcd(nume, deno);

        // 기약분수로 변환
        return new int[]{nume / gcd, deno / gcd};
    }

    // 유클리드 알고리즘 이용한 최대공약수 계산하는 메소드
    public static int calcGcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    };
}
