package BOJ.dataStructure.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class BOJ1620 {
	/*
	 * BOJ NO.1620 : 나는야 포켓몬 마스터
	 *
	 * 1. 특정 포켓몬과 해당하는 인덱스를 모두 요구하고 있기에 List 사용 => 실패
	 * 2. Map<String, Integer> entrySet 사용해서 value 값으로 key값 찾기 => 실패
	 * 3. Map<String, Integer>, Map<Integer, String> 으로 이름과 순번을 각각 매핑하는 2개의 HashMap 생성
	 */
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> nameToNumber = new HashMap<>();
        Map<Integer, String> numberToName = new HashMap<>();

        String[] mn = br.readLine().split(" ");
        int N = Integer.parseInt(mn[0]);
        int M = Integer.parseInt(mn[1]);

        // 도감에 넣기
        for (int index = 1; index <= N; index++) {
            String name = br.readLine();
            nameToNumber.put(name, index);    // 이름 -> 번호
            numberToName.put(index, name);    // 번호 -> 이름
        }

        StringBuilder sb = new StringBuilder();

        // 문항 풀기
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            if (question.charAt(0) < 'A') { // 숫자인 경우
                sb.append(numberToName.get(Integer.parseInt(question))); // 번호 -> 이름
            } else { // 이름인 경우
                sb.append(nameToNumber.get(question)); // 이름 -> 번호
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
