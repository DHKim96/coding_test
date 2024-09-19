package BOJ.dataStructure.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BOJ10773 {
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			Scanner sc = new Scanner(System.in);
			// 정수 k
			int k = sc.nextInt();
			// stack 생성
			// 0이 나올 시 가장 최근에 쓴 수를 지워야 한다는 점에서 스택 사용 
			Stack<Integer> stack = new Stack<>();
			// 최종적으로 적어 낸 수를 담기 위한 변수 선언
			int sum = 0;
		
			while(k-- > 0) {
				int num = sc.nextInt();
				// 0일 경우 pop;
				if(num == 0) {
					stack.pop(); 
					continue;
				}
				stack.push(num);
			}
			
			
			while(!stack.isEmpty()) { 
				// empty() 는 자바 1부터 있던 레거시 코드, 현재는 컬렉션 클래스에 있는 isEmpty() 권장 
				sum += stack.pop();
			}
			
			System.out.println(sum);
			sc.close();
		}	
}
