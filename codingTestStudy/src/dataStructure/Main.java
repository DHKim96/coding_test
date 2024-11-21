package dataStructure;


public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("copy");

        System.out.println("단어 검색 결과 : " + trie.search("cop"));
        System.out.println("접두사 검색 결과 : " + trie.startsWith("cop"));
    }
}
