package PROGRAMMERS.hash;

import java.util.*;

class 의상{
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        // 각 의상의 종류별 갯수 + 1 를 누적곱
        // 해당 의상을 아예 입지 않는 경우를 고려하여 + 1을 해줬음
        for(int num : map.values()){ // Map.values() 메소드 숙지 필요
            answer *= (num + 1);
        }
        
        return answer - 1; // 아무것도 안 입는 경우는 존재하지 않기 때문에 -1
    }
}
