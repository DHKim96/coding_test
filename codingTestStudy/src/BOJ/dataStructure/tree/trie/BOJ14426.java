package BOJ.dataStructure.tree.trie;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14426 {
    // 접두사찾기

    static class Node{
        Node[] node;
        boolean isEnd;

        Node(){
            node = new Node[26]; // a ~ z
            isEnd = false;
        }
    }

    static class Trie{
        Node root;

        public Trie(){
            root = new Node();
        }

        public void insert(String word){
            Node cur = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (cur.node[idx] == null) {
                    cur.node[idx] = new Node();
                }
                cur = cur.node[idx];
            }
            cur.isEnd = true;
        }

        public boolean search(String word){
            Node cur = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (cur.node[idx] == null) {
                    return false;
                }
                cur = cur.node[idx];
            }
            return cur.isEnd;
        }

        public boolean startsWith(String prefix){
            Node cur = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (cur.node[idx] == null) {
                    return false;
                }
                cur = cur.node[idx];
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Trie trie = new Trie();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;

        while(N-- > 0){
            trie.insert(br.readLine());
        }

        while(M-- > 0){
            if(trie.startsWith(br.readLine())){
                count++;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
