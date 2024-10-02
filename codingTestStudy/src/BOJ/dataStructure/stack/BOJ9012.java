package BOJ.dataStructure.stack;

import java.io.*;

public class BOJ9012 {
    /*
  BOJ NO.9012 : 괄호
      괄호 문자열 판단하기
  */
    static char[] stack;  // 스택을 저장할 배열
    static int idx;  // 스택의 현재 위치(크기)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정수 K 입력 받기
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String s = br.readLine();
            stack = new char[s.length()]; // 스택의 크기는 입력된 문자열의 길이와 같음
            idx = 0;  // 스택의 초기화

            boolean isValid = true;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 여는 괄호일 때
                if(c == '('){
                    push(c); // 스택에 입력
                } else { // 닫는 괄호일 때
                    // 스택이 비어있는데 닫는 괄호가 나온다면
                    // 해당 괄호 문자열은 무조건 올바르지 않은 괄호 문자열임
                    if(empty()){
                        isValid = false;
                        break;
                    } else {
                        pop(); // 괄호 쌍이 맞으면 스택에서 제거
                    }
                }
            }

            if(empty() && isValid) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 정수 X를 스택에 넣는 메소드
    public static void push(char item) {
        stack[idx++] = item;
    }

    // 스택의 맨 위 정수를 꺼내는 메소드 (꺼낸 후 해당 자리를 0으로 초기화)
    public static char pop() {
        char item = stack[--idx];
        stack[idx] = ' ';
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
    public static char peek() {
        return stack[idx - 1];
    }
}
