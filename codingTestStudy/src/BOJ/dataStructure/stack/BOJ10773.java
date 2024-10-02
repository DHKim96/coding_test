package BOJ.dataStructure.stack;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class BOJ10773 {

	/*
BOJ NO.10773 : 제로
*/
	static int[] stack;  // 스택을 저장할 배열
	static int idx;  // 스택의 현재 위치(크기)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 정수 K 입력 받기
		int K = Integer.parseInt(br.readLine());
		stack = new int[K];  // 명령의 수에 맞는 스택 크기

		idx = 0;  // 스택의 초기 크기 0

		while (K-- > 0) {
			int num = Integer.parseInt(br.readLine());

			if(num == 0) pop();
			else push(num);
		}

		int sum = 0;

		for(int num : stack) {
			sum += num;
		}

		bw.write(String.valueOf(sum));
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
		if(empty()) return -1;
		int item = stack[--idx];
		stack[idx] = 0;
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
		if (empty()) return -1;
		return stack[idx - 1];
	}
}
