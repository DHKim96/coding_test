package BOJ.dataStructure.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ18258 {
	  /*
    BOJ NO.18258 : 큐 2
    */
    static int[] queue;
    static int rear = 0;
    static int front = 0;
    static int size = 0; // 큐에 들어있는 요소의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령의 수 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        // 큐의 크기를 넉넉하게 할당
        queue = new int[N];

        StringBuilder sb = new StringBuilder();
        
        // 명령어 처리
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            
            switch (input[0]) {
                case "push":
                    int num = Integer.parseInt(input[1]);
                    push(num);
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 정수 x를 큐에 넣는 연산
    public static void push(int X) {
        // 큐의 뒷부분에 값을 추가
        queue[rear] = X;
        rear = (rear + 1) % queue.length; // 순환 구조로 rear가 배열 끝을 넘어서면 다시 0으로
        size++;  // 큐의 크기를 증가
    }
    
    // 큐에서 가장 앞의 정수를 빼고 반환
    public static int pop() {
        if (size == 0) {
            return -1;  // 큐가 비어있으면 -1 반환
        }
        int result = queue[front];
        front = (front + 1) % queue.length; // front도 순환 구조
        size--;  // 큐의 크기를 감소
        return result;
    }
    
    // 큐에 들어있는 정수의 개수를 반환
    public static int size() {
        return size;
    }
    
    // 큐가 비어있으면 1, 아니면 0 반환
    public static int empty() {
        return size == 0 ? 1 : 0;
    }
    
    // 큐의 가장 앞에 있는 정수를 반환
    public static int front() {
        if (size == 0) {
            return -1;  // 큐가 비어있으면 -1 반환
        }
        return queue[front];
    }
    
    // 큐의 가장 뒤에 있는 정수를 반환
    public static int back() {
        if (size == 0) {
            return -1;  // 큐가 비어있으면 -1 반환
        }
        return queue[(rear - 1 + queue.length) % queue.length];  // rear는 다음에 삽입될 위치이므로 -1 해줌
    }
}
