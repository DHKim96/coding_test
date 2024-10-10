package BOJ.dataStructure.tree;

import java.io.*;

public class BOJ11279 {
    /*
   BOJ NO.11279 : 최대 힙
       최대 힙 구현하기
       * 2^31 = int의 최대 범위
   */
    static int[] heap;  // 힙을 구현할 배열
    static int idx;  // 힙의 현재 위치(크기)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연산의 개수
        int N = Integer.parseInt(br.readLine());

        heap = new int[N + 1]; // 인덱스 1부터 시작

        idx = 0;

        StringBuilder sb = new StringBuilder();

        while(N-- > 0){
            int input = Integer.parseInt(br.readLine());
            if (input == 0){ // 0 일 경우 최댓값 출력 후 제거
                sb.append(delete()).append("\n");
            } else { // 자연수일 경우 배열에 추가
                insert(input);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 힙에 데이터 삽입
    public static void insert(int data) {
        // 1. 가장 끝 자리에 노드 삽입
        heap[++idx] = data;
        // 2. 부모 노드와 비교
        // 3. 부모 노드보다 클 때 교환
        int childNode = idx;
        int parentNode = childNode / 2;

        while (parentNode >= 1 && heap[parentNode] < heap[childNode]){
            swap(parentNode, childNode);
            childNode = parentNode;
            parentNode /= 2;
        }
    }

    // 힙에서 데이터 삭제
    public static int delete() {
        // 힙이 비어있는 경우 0 반환
        if (idx == 0) return 0;

        int maxValue = heap[1]; // 최댓값 출력 위한 변수
        // 1. 루트 노드 제거
        // 2. 루트 노드 자리에 가장 마지막 노드 삽입
        heap[1] = heap[idx--];
        // 3. 자식 노드들과 비교
        // 4. 더 큰 자식이 없을 때까지 교환
        int parentNode = 1;

        while(parentNode * 2 <= idx){ // 리프 노드가 아닐때까지
            int leftChild = 2 * parentNode;
            int rightChild = leftChild + 1;
            int largerChild = leftChild;
            // 자식 노드 중 더 큰 값 찾기
            if(rightChild <= idx && heap[rightChild] > heap[largerChild]){
                largerChild = rightChild;
            }
            // 자식노드보다 클 경우 탈출
            if(heap[parentNode] > heap[largerChild]) break;
            swap(parentNode, largerChild);
            parentNode = largerChild; // 더 큰 값의 노드 위치로 내려감
        }
        return maxValue;
    }

    // 노드 위치 교환
    public static void swap(int parentNode, int childNode){
        int temp = heap[parentNode];
        heap[parentNode] = heap[childNode];
        heap[childNode] = temp;
    }
}
