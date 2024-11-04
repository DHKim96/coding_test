package cjOliveNetworks;

import java.io.*;

public class Question3 {
    /*
        n명의 사람들이 원형 테이블에 앉아 방을 탈출하는 눈치 게임을 진행하고자 한다. 사람들은 서로를 감시하고 있다. 각 사람들은 테이블을 바라보는 방향을 기준으로 왼쪽(시계 방향) 혹은 오른쪽(반시계 방향)으로 한 명씩 감시한다.
        각 테이블의 자리는 0번에서 (n-1)번 자리까지 있으며 화살표는 감시 방향을 의미한다. 만약 자신을 감시하는 사람이 없다면 탈출할 수 있다.
        탈출 시작 전 왼쪽을 감시하는 사람 M명이 감시하는 방향을 오른쪽으로 바꾼 뒤 탈출을 시작한다. 이때, 가장 많은 사람이 탈출할 수 있도록 방향을 전환한다면, 탈출할 수 있는 최대 인원 수를 구하시오
        주어지는 매개변수는 다음과 같다.
        (1). n명의 사람이 감시하는 방향이 담긴 정수 배열 arr
        (2). 왼쪽에서 오른쪽으로 감시 방향을 바꿔야 하는 인원 수 m
        각 조건은 다음과 같다.
        (1). 2<= arr.length = n <= 200,000
        (2). arr[i] 는 i번 자리에 앉은 사람이 감시하는 방향 담음(왼쪽 : 1, 오른쪽 : -1)
        (3). 0<= m <= arr에서 1 이 등장하는 횟수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());

        int maxEscapes = solution(arr, m);

        bw.write(String.valueOf(maxEscapes));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solution(int[] arr, int m) {
        // TODO: 최대 탈출 인원 수 계산 로직 구현
        return 0; // 임시 반환 값
    }
}
