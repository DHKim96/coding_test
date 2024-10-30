package PROGRAMMERS.sort;

import java.util.Arrays;

public class 가장큰수 {
	public String solution(int[] numbers) {
        // numbers에 0만 존재할 시 return "0000..." 이 아니라 "0" 만 하도록 처리 필요
        if (Arrays.stream(numbers).allMatch(n -> n == 0)) return "0";
        
        // 문자열 배열로 변환
        String[] strs = Arrays.stream(numbers)
                                .mapToObj(String::valueOf)
                                .toArray(String[]::new); // == size -> new String[size];
        
        // 정렬 (s2 + s1 과 s1 + s2 비교해서 더 큰 값이 앞에 오도록 정렬)
        // 자바 9 부터 문자열 덧셈이 char 배열 대신 byte 배열 사용함에 따라 메모리 사용 최적화 되었음
        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        StringBuilder sb = new StringBuilder();        
        for (String str : strs){
            sb.append(str);
        }
        return sb.toString();
    }
}
