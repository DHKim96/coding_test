package BOJ.dataStructure.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ18258 {
	  /*
    	BOJ NO.18258 : 큐 2
	   	=> 선형 배열을 이용한 큐 구현
	  */
    static int[] queue;
    static int rear; // 큐의 뒤쪽(요소 삽입 위치)
    static int front; // 큐의 앞쪽(요소 제거 위치)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령의 수 입력 받기
        int N = Integer.parseInt(br.readLine());
                
        // 큐의 크기를 넉넉하게 할당
        queue = new int[N];
        rear = 0;
        front = 0;

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
        // 큐의 뒷부분에 값을 추가 후 rear 값 증가
        queue[rear++] = X;
    }
    // => 현재 크기를 넘어서면 추가 삽입이 불가능하지만
    // 문제에서는 N의 크기를 고려하여 적절히 처리 가능
    
    // 큐에서 가장 앞의 정수를 빼고 반환
    public static int pop() {
        if (size() == 0) {
            return -1;  // 큐가 비어있으면 -1 반환
        }
        return queue[front++]; // front값 위치 반환 후 front 증가(이를 통해 제거된 것으로 간주됨)
    }
    
    // 큐에 들어있는 정수의 개수를 반환
    public static int size() {
        return rear - front; 
    }
    
    // 큐가 비어있으면 1, 아니면 0 반환
    public static int empty() {
        return size() == 0 ? 1 : 0;
    }
    
    // 큐의 가장 앞에 있는 정수를 반환
    public static int front() {
        if (size() == 0) {
            return -1;  // 큐가 비어있으면 -1 반환
        }
        return queue[front];
    }
    
    // 큐의 가장 뒤에 있는 정수를 반환
    public static int back() {
        if (size() == 0) {
            return -1;  // 큐가 비어있으면 -1 반환
        }
        return queue[rear - 1]; // rear는 다음 삽입 위치이므로 - 1 해줘야 함
    }
}
