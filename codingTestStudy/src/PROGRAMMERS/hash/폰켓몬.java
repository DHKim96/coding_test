package PROGRAMMERS.hash;

import java.util.*;

class 폰켓몬 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
                
        for(int type: nums){
            set.add(type);
        }
        
        return set.size() >= nums.length / 2 ? nums.length / 2 : set.size();
    }
}
