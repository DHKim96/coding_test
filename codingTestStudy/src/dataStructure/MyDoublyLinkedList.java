package dataStructure;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyDoublyLinkedList<E> {
    private Node<E> head; // 노드의 첫 부분을 가리키는 레퍼런스(포인터)
    private Node<E> tail; // 노드의 끝 부분을 가리키는 레퍼런스

    private int size; // 요소의 갯수

    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // inner static class
    private static class Node<E> {
        private E item; // 노드에 담을 데이터
        private Node<E> next; // 다음 노드 객체 가리키는 레퍼런스
        private Node<E> prev; // 이전 노드 객체 가리키는 레퍼런스

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    // =================================== 탐색 ============================================
    // add, remove 위해선 추가 / 삭제할 요소 탐색이 선행되어야 함
    // 1. 만약 요소의 위치가 헤드에 가깝다면 순차 방향 탐색
    // 2. 만약 요소의 위치가 테일(size)에 가깝다면 역 방향 탐색
    public Node<E> search(int index) {
        Node<E> n = null; // 반환할 노드

        if (index < (this.size / 2)) { // head에 가까움 => 순차 탐색
            n = this.head;
            for (int i = 0; i < index; i++) { // 노드의 next 자체가 다음 노드를 가리키기 때문에 index 전까지만 탐색
                n = n.next;
            }
        } else { // tail에 가까움 => 역순 탐색
            n = this.tail;
            for (int i = this.size - 1; i > index; i--) { // prev도 상기 이유와 마찬가지로 인덱스 후까지만 탐색
                n = n.prev;
            }
        }

        return n;

    }

    public E get(int index){
        // 1. 인덱스 유효성 검사
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index = " + index + "Size = " + size);
        }

        // 2. 탐색한 값 반환
        return search(index).item;
    }

    public void set(int index, E value){
        // 1. 인덱스 유효성 검사
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index = " + index + "Size = " + size);
        }

        // 2. search 메소드 통해 교체할 노드 가져옴
        Node<E> replaceNode = search(index);

        // 3. 해당 노드의 값 변경
        replaceNode.item = value;
    }

    // 순차 검색, 위치 반환
    public int indexOf(Object value){
        Node<E> node= this.head;
        int index = 0;

        while(node != null){
            if(Objects.equals(value, node.item)){ // String.equals() 와 달리 null도 비교 가능
                return index;
            }

            index++;
            node = node.next;
        }

        return -1;
    }

    // 역순 탐색, 위치 반환
    public int lastIndexOf(Object value){
        Node<E> node= this.tail;

        int index = size - 1;

        while(node != null){
            if(Objects.equals(value, node.item)){
                return index;
            }
            index--;
            node = node.prev;
        }

        return -1;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1; // -1 이 아니라는 말은 요소가 리스트에 존재한다는 것이다.
    }



    //==================================== 추가 ====================================
    public void addFirst(E value) {
        // 1. head 백업
        Node<E> first = head; // 최초 삽입 시 null
        // 2. 노드 추가, 새 노드의 prev, next 설정(최초 삽입 시 null)
        Node<E> newNode = new Node<>(null, value, first);
        // 3. 리스트의 사이즈 증가
        this.size++;
        // 4. head 업데이트 (최초 삽입 시 tail도 업데이트)
        head = newNode;

        if (first == null) { // 최초 삽입 시 tail 업데이트
            tail = newNode;
        } else {// 5. 기존 첫 번째 노드의 prev 설정(최초 삽입 시 null)
            first.prev = newNode; // 추가되기 이전 첫 번째 노드에서 prev를 새 노드를 참조하도록 업데이트
        }
    }

    public void addLast(E value) {
        // 1. tail 백업(최초 삽입 시 null)
        Node<E> last = tail;

        // 2. 노드 추가, 새 노드의 prev, next 설정(최초 삽입 시 null)
        Node<E> newNode = new Node<>(last, value, null);

        // 3. 리스트 사이즈 증가
        this.size++;

        // 4. tail 업데이트(최초 삽입 시 head도 업데이트)
        tail = newNode;

        if (last == null) {
            head = newNode;
        } else { // 5. 기존 마지막 노드의 next 설정(최초 삽입 시 null)
            last.next = newNode;
        }


    }

    public boolean add(E value) {
        addLast(value);
        return true;
    }

    // 중간 위치 삽입
    public void add(int index, E value) {
        // 1. 인덱스 범위 체크
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index = " + index + "Size = " + size);
        }

        // 2. 추가할 index == 0, addFirst
        if(index == 0){
            addFirst(value);
            return;
        }

        // 3. 추가할 index == size, addLast
        if(index == size){
            addLast(value);
            return;
        }

        // 4. 추가하려는 위치의 다음 노드 얻기
        Node<E> nextNode = search(index).next;

        // 5. 추가하려는 위치의 이전 노드 얻기
        Node<E> prevNode = nextNode.prev;

        // 6. 새 노드 생성
        Node<E> newNode = new Node<>(prevNode, value, nextNode);

        // 7. 리스트 크기 증가
        size++;

        // 8. 이전 노드의 next를 새 노드에 연결
        prevNode.next = newNode;

        // 9. 다음 노드의 prev를 새 노드에 연결
        nextNode.prev = newNode;
    }

    //======================================= 삭제 ===============================
    public E removeFirst(){
        // 1. 빈 리스트일 시 에러
        if(head == null){
            throw new NoSuchElementException();
        }

        // 2. 삭제할 첫 번째 노드의 데이터 백업(반환용)
        E value = head.item;

        // 3. 두 번째 노드 임시 저장
        Node<E> first = head.next;

        // 4. 첫 번째 노드 전부 삭제
        head.next = null;
        head.item = null;

        // 5. 리스트 크기 감소
        size--;

        // 6. head가 기존 두 번째 노드 가리키도록 업데이트
        head = first;

        if(first == null){
        // 7. 만일 빈 리스트가 될 경우 tail은 null 처리
            tail = null;
        } else { // 8. 빈 리스트가 아닐 경우 기존 두 번째 노드의 prev을 null 업데이트(기존 첫 번째 노드 삭제 반영)
            first.prev = null;
        }

        // 8. 백업했던 기존 첫 번째 노드의 요소 반환
        return value;
    }

    public E remove(){
        return removeFirst();
    }

    public E removeLast(){
        // 1. 빈 리스트일 경우 에러 처리
        if (tail == null){
            throw new NoSuchElementException();
        }

        // 2. 삭제할 마지막 노드 백업
        E value = tail.item;

        // 3. 마지막 노드의 이전 노드를 임시 저장
        Node<E> last = tail.prev;

        // 4. 마지막 노드 삭제
        tail.item = null;
        tail.prev = null;

        // 5. tail 업데이트(이전 노드를 가리키도록)
        tail = last;

        // 노드 삭제로 인해 빈 리스트가 될 경우 head도 null
        if (last == null){
            head = null;
        } else {
            // 아닐 경우 기존 마지막 노드의 이전 노드가 마지막 노드가 되기에 해당 노드의 next를 null 처리
            last.next = null;
        }

        // 6. 반환
        return value;
    }

    // 인덱스로 요소 삭제하기
    public E remove(int index){
        // 1. 인덱스 범위 유효성 체크
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index = " + index + "Size = " + size);
        }

        // 2. 첫 번째 인덱스이면 removeFirst, 마지막 인덱스일 시 removeLast
        if (index == 0){
            return removeFirst();
        }

        if (index == size - 1){
            return removeLast();
        }

        // 3. 중간 인덱스일 경우
        // 3.1. 삭제할 위치의 노드 탐색
        Node<E> deleteNode = search(index);

        // 3.2. 해당 노드의 데이터 백업
        E value = deleteNode.item;

        // 3.3. 해당 노드의 이전 노드 저장
        Node<E> prevNode = deleteNode.prev;

        // 3.4. 해당 노드의 다음 노드 저장
        Node<E> nextNode = deleteNode.next;

        // 3.5. 해당 노드 내부 요소 전부 삭제
        deleteNode.item = null;
        deleteNode.next = null;
        deleteNode.prev = null;

        // 4. 크기 감소
        size--;

        // 5. 이전 노드가 해당 인덱스 노드의 다음 노드 가리키도록 업데이트
        prevNode.next = nextNode;

        // 6. 다음 노드가 해당 인덱스 이전 노드 가리키도록 업데이트
        nextNode.prev = prevNode;

        // 7. 삭제한 노드의 데이터 반환
        return value;
    }

    // 값으로 요소 삭제하기
    // => search 메소드를 사용할 수 없어 직접 순회해야함
    public boolean remove(Object value){
        // 1. 삭제 노드 저장할 변수 선언
        Node<E> delNode = null;

        // 2. 리스트를 루프할 변수 선언
        Node<E> i = head; // 첫 번째 노드부터 루프

        // 3. 노드의 next를 순회하며 일치하는 값 탐색
        while(i != null){ // 마지막 노드까지

            if(Objects.equals(value, i.item)){
                delNode = i;
                break;
            }

            i = i.next; // 다음 노드로 이동
        }

        // 4. 찾는 요소가 없을 시 false 반환
        if(delNode == null){
            return false;
        }

        // 5. 삭제 작업 실시
        // 5.1. (삭제 대상이)첫 번째 노드일 시
        if(delNode.prev == null){
            removeFirst();
            return true;
        }

        // 5.2. 마지막 노드일 시
        if(delNode.next == null){
            removeLast();
            return true;
        }

        // 5.3. 중간 노드일 시
        // 5.3.1. 해당 노드 이전 노드와 다음 노드 저장
        Node<E> prevNode = delNode.prev;
        Node<E> nextNode = delNode.next;

        // 5.3.2. 해당 노드 삭제
        delNode.item = null;
        delNode.prev = null;
        delNode.next = null;

        // 5.3.3. 리스트 크기 감소
        size--;

        // 5.3.4. 해당 노드의 이전 노드와 다음 노드를 서로 연결
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        return true;
    }

    // 모든 요소 삭제
    public void clear(){
        Node<E> node = this.head;

        while(node != null){
            Node<E> next = node.next;

            node.prev = null;
            node.item = null;
            node.next = null;

            node = next;
        }

        head = null;
        tail = null;
        size = 0; // 크기 초기화
    }

    // ====================================================== 기타 함수 ==================================
    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){
        if(head == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        Node<E> n = head;
        while(n == null) {
            result.append(n.next.item);

            if(n.next != null){
                result.append(", ");
            }

            n = n.next;
        }

        result.append("]");

        return result.toString();
    }

}
