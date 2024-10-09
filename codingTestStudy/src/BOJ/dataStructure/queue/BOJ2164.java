package BOJ.dataStructure.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;

public class BOJ2164 {
	/*
    BOJ NO.2164 : 카드 2
    	큐를 사용하여 동작 구현하기
    */
	
    static int[] queue;
    static int front; // 삭제 위치
    static int rear;  // 삽입 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 카드 갯수 입력
        int N = Integer.parseInt(br.readLine());

        // 원형 큐는 하나의 인덱스를 비워두기 때문에 크기를 N + 1로 설정
        queue = new int[N + 1];

        // 초기 상태
        front = 0;
        rear = 0;

        // 큐에 카드 넣기
        for (int i = 1; i <= N; i++) {
            add(i);
        }

        // 카드가 1장 남을 때까지 지속
        while (size() > 1) {
            // 1. 최상단 카드 버리기
            poll();

            if (size() == 1) break;

            // 2. 최상단 카드를 최하단으로 옮기기
            int num = poll();
            add(num);
        }

        // 마지막 남은 카드 출력
        bw.write(String.valueOf(poll()));
        bw.flush();
        bw.close();
        br.close();
    }

    // 삽입 연산
    public static void add(int num) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        queue[rear] = num;
        rear = (rear + 1) % queue.length; // 원형 큐 동작
    }

    // 삭제 연산
    public static int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int num = queue[front];
        front = (front + 1) % queue.length;
        return num;
    }

    // 큐의 크기 반환
    public static int size() {
        return (rear - front + queue.length) % queue.length;
    }

    public static boolean isEmpty() {
        return rear == front;
    }

    public static boolean isFull() {
        return (rear + 1) % queue.length == front;
    }
}	
