package PROGRAMMERS.bfs;

import java.util.Stack;

public class 주식가격 {
	  public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        Stack<Integer> stack = new Stack<>();
	        
	        for (int i = 0; i < prices.length; i++) {
	            // 현재 가격보다 낮은 가격이 나올 때까지 스택을 확인
	            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
	                int idx = stack.pop();
	                answer[idx] = i - idx; // 가격이 떨어진 시점 계산
	            }
	            // 현재 인덱스를 스택에 추가
	            stack.push(i);
	        }
	        
	        // 가격이 끝까지 떨어지지 않은 주식 처리
	        while (!stack.isEmpty()) {
	            int idx = stack.pop();
	            answer[idx] = prices.length - 1 - idx;
	        }
	        
	        return answer;
	    }
}
