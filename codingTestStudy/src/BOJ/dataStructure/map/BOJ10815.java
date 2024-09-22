package BOJ.dataStructure.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ10815 {
	/*
	 * BOJ NO.10815 : 숫자 카드
	 * 
	 * 특정 숫자 카드를 지니고 있는지 여부를 가리는 문제
	 * => 중복 저장이 안되는 자료구조인 Set 활용
	 * 
	 */
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    	Set<Integer> set = new HashSet<>();
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	while(N-- > 0) {
    		set.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	int M = Integer.parseInt(br.readLine());
    	
    	st = new StringTokenizer(br.readLine());
    	
    	while(M-- > 0) {
    		int num = Integer.parseInt(st.nextToken());
    		
    		if(set.contains(num)) sb.append(1);
    		else sb.append(0);
    		
    		sb.append(" ");
    	}
    	
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();
    	br.close();
    }
}
