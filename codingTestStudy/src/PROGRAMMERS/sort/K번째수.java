package PROGRAMMERS.sort;

import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int idx = 0; idx < commands.length; idx++){
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];

            int capa = j - i + 1;
            int[] temp = new int[capa];

            for (int idx2 = i - 1; idx2 < j; idx2++){ // i - 1번 인덱스 ~ j - 1번 인덱스 => 인덱스 위치 유념할 것
                temp[idx2 - i + 1] = array[idx2];
            }

            Arrays.sort(temp);

            answer[idx] = temp[k - 1];
        }


        return answer;
    }
}
