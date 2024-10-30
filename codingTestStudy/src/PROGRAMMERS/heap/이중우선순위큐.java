package PROGRAMMERS.heap;

import java.util.PriorityQueue;

public class 이중우선순위큐 {
    static class DoublePriorityQueue<T extends Comparable<T>> { // T가 Comparable을 구현해야 우선순위 큐에서 정렬을 할 수 있으므로
        int size;
        PriorityQueue<T> minHeap; // 최소 힙
        PriorityQueue<T> maxHeap; // 최대 힙

        DoublePriorityQueue() {
            this.size = 0;
            this.minHeap = new PriorityQueue<>(); // 오름차순
            this.maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1)); // 내림차순 / T는 원시형 타입이 아니므로 compareTo 메소드 사용해 비교
        }

        void add(T value) {
            this.minHeap.add(value);
            this.maxHeap.add(value);
            this.size++;
        }

        void removeMax() {
            if (this.size > 0) {
                T max = this.maxHeap.poll();
                this.minHeap.remove(max); // minHeap에서도 삭제
                size--;
            }
        }

        void removeMin() {
            if (this.size > 0) {
                T min = this.minHeap.poll();
                this.maxHeap.remove(min); // maxHeap에서도 삭제
                size--;
            }
        }

        T maxValue() {
            return this.maxHeap.peek(); // 현재 최댓값 반환
        }

        T minValue() {
            return this.minHeap.peek(); // 현재 최솟값 반환
        }
    }

    public int[] solution(String[] operations) {
        int[] answer = {};

        DoublePriorityQueue<Integer> d = new DoublePriorityQueue<>();


        for (int i = 0; i < operations.length; i++){
            String[] operation = operations[i].split(" ");

            char head = operation[0].charAt(0); // 두문자 추출
            int num = Integer.parseInt(operation[1]); // 숫자 추출

            if (head == 'I'){
                // 삽입 연산
                d.add(num);
            } else {
                // 삭제 연산
                if (num == 1) { // 최댓값 삭제
                    d.removeMax();
                } else if (num == -1) { // 최솟값 삭제
                    d.removeMin();
                }
            }

        }

        answer = d.size > 0 ? new int[]{d.maxValue(), d.minValue()} : new int[]{0, 0};

        return answer;
    }
}
