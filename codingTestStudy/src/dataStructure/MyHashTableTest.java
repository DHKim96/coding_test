package dataStructure;

import java.util.LinkedList;

class MyHashTable {
    class Node {
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String getValue() {
            return value;
        }

        void setValue(String value) {
            this.value = value;
        }
    }

    LinkedList<Node>[] data; // 연결 리스트로 구성된 배열(개별 체이닝 기법)

    public MyHashTable(int size) {
        this.data = new LinkedList[size];
    }
    
    // 해싱하여 해시값 반환
    int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) { // toCharArray() : 문자열을 char형 배열로 반환
            hashCode += c; // 해당 문자의 아스키코드를 합산
        }
        return hashCode;
    }

    // 해시값을 통해 고유 색인 반환
    int convertToIndex(int hash) {
        return hash % this.data.length;
    }
    
    // 탐색
    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) return null;
        for (Node node : list) {
            if (node.key.equals(key)) return node;
        }
        return null;
    }

    // 저장
    void put(String key, String value){
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        if (list == null) { // 해당 인덱스의 배열이 공백일 시 리스트 생성
            list = new LinkedList<Node>();
            data[index] = list;
        }
        Node node = searchKey(list, key);
        if (node == null) { // 해당 노드가 존재하지 않을 시
            list.addLast(new Node(key, value)); // 입력 받은 키-값 쌍 저장(연결 리스트로 저장하는 개별 체이닝 방식)
        } else { // 중복된 키 일 시 value 덮어씌움
            node.setValue(value);
        }
    }

    String get(String key){
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null ? null : node.getValue();
    }
}

public class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable h = new MyHashTable(3);
        h.put("park", "isn't she lovely?");
        h.put("jin", "isn't he wonderful?");
        h.put("ddalgi", "what a cuty puppy");
        h.put("dalrae", "more beautiful puppy");

        System.out.println(h.get("park"));  // isn't she lovely?
        System.out.println(h.get("jin"));   // isn't he wonderful?
        System.out.println(h.get("ddalgi")); // what a cuty puppy
        System.out.println(h.get("dalrae")); // more beautiful puppy
        System.out.println(h.get("unknown")); // null
    }
}

