package BOJ.dataStructure.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ11478 {
	/*
	 * BOJ NO.11478 : 서로 다른 부분 문자열의 개수
	 * 
	 * Set 와 String.subString() 사용
	 */
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String S = br.readLine();
    	
    	Set<String> set = new HashSet<>();
    	
    	for(int i = 0; i < S.length(); i++) {
			for(int j = i + 1; j <= S.length(); j++) { // subString(i,i) 일 시 공백 추출
				String str = S.substring(i, j); // subString의 endIndex : 추출하고자 하는 마지막 자리 + 1
				set.add(str);
			}
		}
    	
    	System.out.println(set.size());
    	
    	br.close();
    }
}
