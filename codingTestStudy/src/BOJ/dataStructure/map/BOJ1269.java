package BOJ.dataStructure.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.HashMap;
import java.util.HashSet;
//import java.util.Map;
import java.util.Set;

public class BOJ1269 {
	/*
	 * BOJ NO.1269 : 대칭 차집합
	 * 
	 * => 공집합에서 여집합 빼기
	 * 
	 * Map<Integer, Boolean> 사용
	 * 중복 저장 안되는 점을 활용하여 같은 key 입력될 경우 true
	 * => false의 갯수 세기
	 */	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] sizes = br.readLine().split(" ");
    	
    	int sizeA = Integer.parseInt(sizes[0]);
    	int sizeB = Integer.parseInt(sizes[1]);
    	
//    	Map<Integer, Boolean> map = new HashMap<>();
//    	
//    	// A 입력 받기
//    	String[] inputA = br.readLine().split(" "); 
//    	for(int i = 0; i < sizeA; i++) {
//    		map.put(Integer.parseInt(inputA[i]), false);
//    	}
//    	
//    	// B 입력 받으면서 A의 숫자들과 비교
//    	String[] inputB = br.readLine().split(" ");
//    	for(int i = 0; i < sizeB; i++) {
//    		int numB = Integer.parseInt(inputB[i]);
//    		if(map.containsKey(numB)) { // 여집합일 경우 true
//    			map.replace(numB, true);
//    		} else {
//    			map.put(numB, false);
//    		}
//    	}
//    	
//    	int count = 0;
//    	
//    	for(int key : map.keySet()) { // 모든 key 순회하며 false일 경우에만(여집합 아닌 경우) 카운트
//    		if(!map.get(key)) {
//    			count++;
//    		}
//    	};
//    	
//    	System.out.println(count);
//    	
//    	br.close();
    	Set<Integer> setA = new HashSet<>();    	
    	Set<Integer> setB = new HashSet<>();
    	
    	// A 입력 받기
    	String[] inputA = br.readLine().split(" "); 
    	for(int i = 0; i < sizeA; i++) {
    		setA.add(Integer.parseInt(inputA[i]));
    	}
    	
    	// B 입력
    	String[] inputB = br.readLine().split(" ");
    	for(int i = 0; i < sizeB; i++) {
    		setB.add(Integer.parseInt(inputB[i]));
    	}
    	
    	Set<Integer> diff = new HashSet<>(setA); // A
    	
    	// 1. A - B
    	diff.removeAll(setB);
    	
    	// 2. B - A
    	setB.removeAll(setA);
    	
    	// 3. 대칭 차집합
    	diff.addAll(setB);
    	
    	System.out.println(diff.size());
    	
    	br.close();
    }
}
