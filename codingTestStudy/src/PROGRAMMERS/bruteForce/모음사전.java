package PROGRAMMERS.bruteForce;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {
    private static final String[] VOWELS = {"A", "E", "I", "O", "U"}; // 상수로 선언
    private static List<String> dictionary;

    public int solution(String word) {
        int answer = 0;

        dictionary = new ArrayList<>();

        dfs("", 0);

        return dictionary.indexOf(word);
    }

    public void dfs(String word, int depth){
        if (depth > 5) return;

        dictionary.add(word);

        for (String vowel : VOWELS){
            dfs(word + vowel, depth + 1);
        }
    }
}
