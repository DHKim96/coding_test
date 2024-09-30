package BOJ.dataStructure.stack;

import java.io.*;

public class BOJ28278 {
    /*
   BOJ NO.28278 : 스택
   */
    static int[] stack;  // 스택을 저장할 배열
    static int idx;  // 스택의 현재 위치(크기)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령의 수 N 입력 받기
        int N = Integer.parseInt(br.readLine());
        stack = new int[N];  // 명령의 수에 맞는 스택 크기

        idx = 0;  // 스택의 초기 크기 0

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);

            switch (num) {
                case 1: // 정수 X를 스택에 넣는다
                    int X = Integer.parseInt(input[1]);
                    push(X);
                    break;
                case 2: // 스택에서 맨 위의 정수를 빼고 출력한다. 없다면 -1 출력
                    sb.append(pop()).append("\n");
                    break;
                case 3: // 스택에 들어있는 정수의 개수를 출력
                    sb.append(size()).append("\n");
                    break;
                case 4: // 스택이 비어있으면 1, 아니면 0을 출력
                    sb.append(empty() ? 1 : 0).append("\n");
                    break;
                case 5: // 스택의 맨 위 정수를 출력. 없다면 -1 출력
                    sb.append(peek()).append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 정수 X를 스택에 넣는 메소드
    public static void push(int item) {
        stack[idx++] = item;
    }

    // 스택의 맨 위 정수를 꺼내는 메소드 (꺼낸 후 해당 자리를 0으로 초기화)
    public static int pop() {
        if (empty()) {
            return -1;
        }
        int item = stack[--idx];  // idx 감소 후 값을 가져옴
        stack[idx] = 0;  // 해당 자리를 0으로 초기화
        return item;
    }

    // 스택의 크기 반환
    public static int size() {
        return idx;
    }

    // 스택이 비어있는지 여부 확인
    public static boolean empty() {
        return idx == 0;
    }

    // 스택의 맨 위 정수를 반환(꺼내지 않고)
    public static int peek() {
        if (empty()) {
            return -1;
        }
        return stack[idx - 1];
    }
}
