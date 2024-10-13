package SSG_coding_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
/*
 * BOJ NO.1966 : 프린터 큐
 * 	문서의 중요도에 따라 큐의 원소들을 재배치
 * 	=> 프린터 순서 저장하는 큐와 중요도 저장하는 우선순위 큐 사용
 */
	
	// 문서의 정보 담을 내부클래스(static 함수에서 사용하기에 static 클래스 선언)
	class Document{
		int index; // 문서의 기존 순번
		int importance; // 중요도
		
		public Document(int index, int importance) {
			this.index = index;
			this.importance = importance;
		}
	}
	
	/**
	 * 문서의 중요도에 따라 문서를 출력하는 메서드
	 * @param queue // 프린터 큐
	 * @param importances // 중요도 담은 우선순위 큐
	 * @param targetDocu // 인쇄 순번을 계산할 목표 문서
	 * @return
	 */
	public static int printerQueue( Queue<Document> queue, PriorityQueue<Integer> importances, int targetDocu) {
		// 인쇄 횟수
		int count = 0;
		
		while(!queue.isEmpty()) {
			Document document = queue.peek();
						
			//우선순위 여부 검증
			if(importances.peek() == document.importance) { //우선순위일 경우 바로 프린트
				// 목표 문서가 아닐 경우
				// 큐에서 제거(프린트)
				queue.poll();
				// 우선순위 큐에서 해당 중요도 제거
				importances.poll();
				
				// 인쇄 횟수 증가
				count++;
				
				// 목표 문서일 경우 반복문 종료
				if(targetDocu == document.index) {
					break;
				}
			} else {// 우선순위가 아닐 경우 큐 가장 뒤로 재배치
			   queue.add(queue.poll());
			}
			
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 테스트 케이스의 개수 입력 받기
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			
			// 첫째 줄 입력 받기
			String[] firstLine = br.readLine().split(" ");
			//  첫째 줄에서
			// 문서의 개수 N 입력 받기
			int N = Integer.parseInt(firstLine[0]);	
			// 몇 번째로 인쇄됐는지 궁금한 문서가 현재 몇 번째 놓여 있는지 입력 받기
			int M = Integer.parseInt(firstLine[1]);
			
			// 둘째 줄 = N개 문서의 중요도 입력 받기
			String[] secondLine = br.readLine().split(" ");
			
			// 문서들 담을 큐
			Queue<Document> queue = new LinkedList<>();
			
			// 문서의 중요도 담을 우선순위 큐(우선순위 큐는 기본적으로 오름차순 기준이므로 컬렉션 프레임워크의 내장함수 이용해 내림차순 기준으로 생성)
			PriorityQueue<Integer> importances = new PriorityQueue<Integer>(Collections.reverseOrder());
			
			// 중요도 담기
			for(int i = 0; i < secondLine.length; i++) {
				// 중요도 추출
				int importance = Integer.parseInt(secondLine[i]);
				// 우선수위 큐에 삽입
				importances.add(importance);
				// 큐에 넣기(문서의 순서, 중요도)
				queue.add(new Document(i, importance));
			}
			
			sb.append(printerQueue(queue, importances, M)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
	}
}
