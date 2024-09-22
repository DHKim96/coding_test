package BOJ.dataStructure.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ7785 {
	/*
	 * BOJ NO.7785 : 회사에 있는 사람
	 * 
	 * 각 사원의 퇴근 여부(Boolean)를 가려야 함
	 * => Map<사원명, 퇴근 여부> 자료구조
	 * 
	 */
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    	Map<String, Boolean> log = new HashMap<>();
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	for(int i = 0; i < N; i++) {
    		String[] inputLine = br.readLine().split(" ");
    		
    		String name = inputLine[0];
    		String state = inputLine[1];
    		
    		if(state.equals("enter")) {
    			log.put(name, true);
    		} else {
    			log.put(name, false);
    		}
    	}
    	
    	//퇴근하지 않은 사원에 대한 리스트 생성
    	List<String> result = new ArrayList<>();
    	
    	for(String name : log.keySet()) {
    		if(log.get(name)) {
    			result.add(name);
    		}
    	}
    	
    	// 사전순 내림차순 정렬(Collections.reverseOrder() 도 가능)
    	Collections.sort(result, (o1, o2) -> o2.compareTo(o1));;
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(String name : result) {
    		sb.append(name).append("\n");
    	}
    	
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();
    	br.close();
    }
}
