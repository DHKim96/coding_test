package BOJ.dataStructure.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class BOJ1764 {
	/*
	 * BOJ NO.1764 : 듣보잡
	 *
	 *	듣도 못한 사람의 명단을 Set 자료구조로 저장
	 *	보도 못한 사람 명단 저장 중 set과 비교하여 같을 경우 List에 저장
	 *  Collections.sort() 로 사전순 정렬
	 *	list.size(), 명단 출력
	 *=> TreeSet 으로 저장하면 자동으로 오름차순 정렬되어 별도의 정렬 과정 불필요
	 */
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        
        Set<String> result = new TreeSet<>();

        String[] mn = br.readLine().split(" ");
        int N = Integer.parseInt(mn[0]); // 듣도 못한 사람의 수
        int M = Integer.parseInt(mn[1]); // 보도 못한 사람의 수

        // 듣도 못한 사람
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            set.add(name);
        }
       
        // 보도 못한 사람 => 듣도 못한 사람과 겹치는 지를 중점적으로 파악
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if(set.contains(name)) { // 듣도 못한 사람일 경우
            	result.add(name); // 트리셋에 추가
            }
        }
             
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		for(String name : result) {
			sb.append(name).append("\n");
		}
		
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
