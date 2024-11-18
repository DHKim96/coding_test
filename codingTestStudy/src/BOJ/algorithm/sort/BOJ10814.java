package BOJ.algorithm.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class BOJ10814 {
	/*
	 * BOJ NO.10814 : 나이순 정렬
	 * 
	 * 객체 배열 생성
	 * 
	 * 내장 정렬 메서드 사용 & 람다식으로 compare 사용해 조건부 정렬 구현
	 */

//	static class Member {
//		int age;
//		String name;
//
//		public Member() {}
//
//		public Member(int age, String name) {
//			this.age = age;
//			this.name = name;
//		}
//
//		@Override
//		public String toString() {
//			return this.age + " " + this.name;
//		}
//	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
//        Member[] memberList = new Member[N]; // 객체 배열 사용

		Map<Integer, String> map = new HashMap<>();


        //입력 받기
        for (int i = 0; i < N; i++) {
        	String[] input = br.readLine().split(" ");
        	int age = Integer.parseInt(input[0]);
        	String name = input[1];

			map.put(age, map.getOrDefault(age, "") + " " + name);
        	
//        	memberList[i] = new Member(age, name);
        }

        // Arrays.sort 는 안정 정렬(stable sort)  따라서 별도의 처리없이 입력 순서 유지
//        Arrays.sort(memberList, (member1, member2) -> Integer.compare(member1.age, member2.age));

        // 결과 출력
        StringBuilder sb = new StringBuilder();
       
//        for (int i = 0; i < N; i++) {
//            sb.append(memberList[i]).append("\n");
//        }

		for (int key : map.keySet()) {
			System.out.println(map.get(key));
		}

//        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

