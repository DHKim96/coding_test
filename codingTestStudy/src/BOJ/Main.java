package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Main {
	/*
    BOJ NO.28279 : 덱 2
    	덱의 개념을 익히고 실습하기
    */
	
	private static int[] deque;

    public static void main(String[] args) throws IOException{
    	// 링크드 리스트로 데크 구현
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	// 명령의 수 N 입력 받기
    	int N = Integer.parseInt(br.readLine());
    	
    	// 반복문으로 명령 입력 받기
    	while(N-- > 0) {
    		String[] input = br.readLine().split(" ");
    		
    		int command = Integer.parseInt(input[0]);
    		
    		switch(command) {
    			case 1:
    				int num = Integer.parseInt(input[1]);
    				break;
    			case 2:
    				break;
    			case 3:
    				break;
    			case 4:
    				break;
    			case 5:
    				break;
    			case 6:
    				break;
    			case 7:
    				break;
    			default :
    		}
    		
    	}
    	
    }
    
    // 덱의 앞에 삽입
    public static void addFirst(int num) {
    	
    }
    
    // 덱의 뒤에 삽입
    public static void addLast(int num) {
    	
    }
    
    // 정수 있을 시 맨 앞 정수 빼고 출력, 없을 시 -1
    public static int removeFirst() {
    	
    }
    
    // 정수 있을 시 맨 뒤 정수 빼고 출력, 없을 시 -1
    public static int removeLast() {
    	
    }
    
    // 덱에 있는 정수의 갯수 출력
    public static int size() {
    	
    }
    
    // 덱 공백 상태 여부 출력(공백 : 1 // 비공백 : 0)
    public static boolean isEmpty() {
    	
    }
    
    // 덱에 정수가 있다면 맨 앞 정수 출력, 없을 시 -1
    public static int front() {
    	
    }
    
    // 덱에 정수 있다면 맨 뒤 정수 출력, 없을 시 -1
    public static int rear() {
    	
    }
}
