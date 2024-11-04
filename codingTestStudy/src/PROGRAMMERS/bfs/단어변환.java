package PROGRAMMERS.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    static class Word{
        String data;
        int move;

        Word(String data, int move){
            this.data = data;
            this.move = move;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        // 최소 몇 단계 => bfs
        // 모든 노드를 시작 노드로 설정 후 탐색
        // words 중 begin 과 하나만 다를 경우 교환하며 탐색
        // 교환 결과 target일 경우 중지
        // 방문 배열
        boolean[] visited = new boolean[words.length];

        Queue<Word> q = new LinkedList<>();

        q.add(new Word(begin, 0));

        while(!q.isEmpty()){
            Word curr = q.poll(); // 단어

            int currMove = curr.move;
            String currWord = curr.data;

            if (currWord.equals(target)){ // 타켓일 시 반복문 탈출
                answer = currMove;
                break;
            }

            // 탐색한 단어가 아니고 변환 가능한 단어일 시 변환
            for (int i = 0; i < words.length; i++){
                String nextWord = words[i];
                if (!visited[i] && canConvert(currWord, nextWord)){
                    q.add(new Word(nextWord, currMove + 1)); // 단어 변환
                    visited[i] = true; // 방문처리
                }
            }
        }

        return answer;
    }

    public boolean canConvert(String curr, String next){
        int count = 0;

        int len = curr.length();

        for (int i = 0; i < len; i++){
            if (curr.charAt(i) != next.charAt(i)) {
                ++count;
                if(count > 1) return false;
            }
        }

        return count == 1;
    }
}
