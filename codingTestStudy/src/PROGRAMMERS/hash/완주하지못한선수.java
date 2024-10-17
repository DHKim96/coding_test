package PROGRAMMERS.hash;

import java.util.*;

class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String winner : completion){
            map.put(winner, map.getOrDefault(winner, 0) + 1); // 동명이인 처리
            // getOrDefault
        }
        
        for(String runner : participant){
            if(map.getOrDefault(runner, 0) == 0){
                answer = runner;
                break;
            }
            // 만약 완주한 사람이었다면 밸류값 - 1
            map.put(runner, map.get(runner) - 1);
        }
        
        
        return answer;
    }
}