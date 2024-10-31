package PROGRAMMERS.heap;

public class 더맵게 {
    private static int idx = 0;

    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 1. 힙 정렬
        int[] heap = new int[scoville.length + 1];

        for (int i = 0; i < scoville.length; i++){
            add(heap, scoville[i]);
        }

        // 1번째 2번째
        int min = heap[1];

        while (min < K){
            if (idx < 2) return -1; // 음식이 하나 밖에 안남았는 데 K보다 작다면 조건을 만족시킬 수 없으므로 -1 리턴

            answer++;

            int first = remove(heap);
            int second = remove(heap);

            add(heap, first + second * 2);

            min = heap[1];
        }

        return answer;
    }



    // 삽입 => 가장 맨 끝 자리에 삽입 후 부모 노드와 비교하며 올림
    public void add(int[] scoville, int data){
        // 1. 맨 끝 자리에 삽입
        scoville[++idx] = data;
        // 2. 부모 노드와 비교 => 부모 노드보다 작을 경우 부모 노드와 교환 반복
        int child = idx;
        int parent = idx / 2;

        while ( parent >= 1 && scoville[parent] > scoville[child]){
            swap(scoville, parent, child);
            child = parent;
            parent = child / 2;
        }

    }

    // 삭제 => 루트 노드 삭제 후 루트 노드에 맨 끝 노드 삽입 후 차례로 내림
    public int remove(int[] scoville){
        // 힙이 비어있을 시 0 반환
        if (idx == 0) return 0;

        // 1. 루트 노드 저장(최댓값 출력 목적)
        int minValue = scoville[1];

        // 2. 루트 노드 자리에 리프 노드 삽입
        scoville[1] = scoville[idx--];


        // 4. 루트 노드를 자식 노드들과 비교 => 자식 노드들 보다 작을 때까지 교환 반복
        int parent = 1;

        while (parent * 2 <= idx) { // 리프 노드가 아닐 때까지
            int leftChild = 2 * parent;
            int rightChild = leftChild + 1;
            int littleChild = leftChild;

            // 자식 노드 중 더 작은 노드 확인
            if (rightChild <= idx && scoville[rightChild] < scoville[littleChild]){
                littleChild = rightChild;
            }

            // 더 작은 자식 노드보다 작을 탈출
            if (scoville[parent] < scoville[littleChild]) break;

            // 더 작은 자식 노드보다 클 경우 교환
            swap(scoville, parent, littleChild);
            parent = littleChild;
        }

        return minValue;
    }

    public void swap(int[] scoville, int a, int b){
        int temp = scoville[a];
        scoville[a] = scoville[b];
        scoville[b] = temp;

    }
}
