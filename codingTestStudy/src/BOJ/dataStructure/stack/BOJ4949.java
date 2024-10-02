package BOJ.dataStructure.stack;

import java.io.*;

public class BOJ4949 {
    /*
    BOJ NO.4949 : 균형잡힌 세상
        괄호 문자열 판단하기
    */
    static char[] stack;  // 스택을 저장할 배열
    static int idx;  // 스택의 현재 위치(크기)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정수 K 입력 받기
        StringBuilder sb = new StringBuilder();

        stack = new char[100]; // 문자열 최대 길이 100
        //  => idx 값으로 스택을 사용하기 때문에 매번 배열을 초기화할 필요 없음

        String input = br.readLine();

        while (!(input = br.readLine()).equals(".")) {
            idx = 0;  // 스택의 초기화

            boolean isValid = true;

            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if(c == '(' || c == '['){ // 여는 괄호
                    push(c);
                } else if (c == ')' || c == ']'){ // 닫는 괄호일 때
                    if (empty()){ // 닫는 괄호일 때 스택이 비어있다면 무조건 불균형
                        isValid = false;
                        break;
                    } else {
                        if (c == ')' && peek() == '('){
                            pop();
                        } else if (c == ']' && peek() == '['){
                            pop();
                        } else {
                            isValid = false;
                        }
                    }
                }
            }

            if(empty() && isValid) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
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
