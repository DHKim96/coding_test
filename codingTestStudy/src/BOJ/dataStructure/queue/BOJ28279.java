package BOJ.dataStructure.queue;

import java.io.*;
import java.util.LinkedList;

public class BOJ28279 {
    /*
BOJ NO.28279 : 덱 2
    덱의 개념을 익히고 실습하기
*/
    private static LinkedList<Integer> deque;

    public static void main(String[] args) throws IOException {
        // 링크드 리스트로 데크 구현
        deque = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령의 수 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 출력문을 한 번에 받아서 처리하기 위한 빌더
        StringBuilder sb = new StringBuilder();

        // 반복문으로 명령 입력 받기
        while(N-- > 0) {
            String[] input = br.readLine().split(" ");

            int command = Integer.parseInt(input[0]);

            switch(command) {
                case 1:
                    int num = Integer.parseInt(input[1]);
                    deque.addFirst(num);
                    break;
                case 2:
                    num = Integer.parseInt(input[1]);
                    deque.addLast(num);
                    break;
                case 3:
                    if(deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.removeFirst());
                    sb.append("\n");
                    break;
                case 4:
                    if(deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.removeLast());
                    sb.append("\n");
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if(deque.isEmpty()) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                    break;
                case 7:
                    if(!deque.isEmpty()) sb.append(deque.get(0));
                    else sb.append(-1);
                    sb.append("\n");
                    break;
                case 8 :
                    if(!deque.isEmpty()) sb.append(deque.get(deque.size() - 1));
                    else sb.append(-1);
                    sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
