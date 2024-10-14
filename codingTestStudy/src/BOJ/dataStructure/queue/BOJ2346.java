package BOJ.dataStructure.queue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ2346 {
    /*
		BOJ NO.2346 : 풍선 터뜨리기
	 */
    static class Balloon {
        int position;
        int move;

        Balloon(int position, int move) {
            this.position = position;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Balloon> balloons = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            balloons.add(new Balloon(i + 1, Integer.parseInt(input[i])));
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        Balloon current = balloons.remove(0);
        sb.append(current.position).append(" ");
        int steps = current.move;

        while (!balloons.isEmpty()) {
            index = steps > 0
                    ? (index + steps - 1) % balloons.size()
//						(index + steps + balloons.size()) % balloons.size(); => 틀림 step이 인덱스 범위가 아니기 때문
                    : (index + steps) % balloons.size();

            // 음수 인덱스를 보정하여 리스트 내의 유효한 인덱스로 변환
            if (index < 0) { // => 모듈러 연산이 음수를 반환할 때 사용가능한 안전한 방법
                index += balloons.size();
            }
            current = balloons.remove(index);
            steps = current.move;
            sb.append(current.position).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }
}
