package dataStructure;

public class Trie {
    class Node {
        Node[] children;
        boolean isEnd;

        public Node() {
            this.children = new Node[26]; // 소문자 a ~ z
            this.isEnd = false; // 단어의 끝 여부
        }
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    // 단어 삽입
    public void insert(String word) {
        Node currNode = root; // 루트 노드부터 시작(루트 노드는 공백)

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a'; // 'a'는 0, 'b'는 1, ..., 'z'는 25

            if(currNode.children[idx] == null) { // 현재 노드의 자식 노드 중 해당 철자가 없다면 새로 생성
                currNode.children[idx] = new Node();
            }

            currNode = currNode.children[idx]; // 자식 노드로 이동
        }

        currNode.isEnd = true; //끝까지 이동하면 해당 노드에 끝 여부 true 저장
    }

    // 단어 검색
    public boolean search(String word) {
        Node currNode = root; // 루트 노드부터 시작(루트 노드는 공백)

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if(currNode.children[idx] == null) { // 자식 노드 중 해당 철자가 없다면 바로 없음 리턴
                return false;
            }

            currNode = currNode.children[idx]; // 있다면 다음 철자 존재 여부 확인
        }

        return currNode.isEnd; // 찾고자 하는 문자열의 크기만큼 탐색한 후에 도착한 노드가 단어의 끝이라면 해당 단어 존재함
    }

    // 접두사 검색
    public boolean startsWith(String prefix) {
        Node currNode = root;

        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';

            if(currNode.children[idx] == null) {
                return false;
            }

            currNode = currNode.children[idx];
        }

        return true; // 단어가 아니라 접두사 검색이라 무조건 존재
    }
}
