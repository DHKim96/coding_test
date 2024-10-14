package SSG_coding_test.warmingUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1343 {
	/*
	 * BOJ NO.1343 : 폴리오미노
	 */
	
	private static StringBuilder sb;
	
	public static void coverPolyomino(int count) {
		while(count > 0) {
			if(count >= 4) {
				sb.append("AAAA");
				count -= 4;
			} else {
				sb.append("BB");
				count -= 2;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 보드판 입력 받기
		String board = br.readLine();
				
		sb = new StringBuilder();
				
		int count = 0; // "." 만나기 직전까지의 보드블럭 갯수를 저장하기 위한 변수
				
		for(int i = 0; i < board.length(); i++) {
			char ch = board.charAt(i);
			
			if(ch == '.') {
				if(count % 2 == 1) {
					System.out.println(-1);
					bw.flush();
					bw.close();
					br.close();
					return;
				}
				
				coverPolyomino(count);
		
				sb.append(".");
				
				count = 0;
			} else {
				count++;
			}
		}
		
		// 마지막 남은 블록들 처리
        if (count % 2 == 1) {
            bw.write("-1\n");
        } else {
            coverPolyomino(count);
            bw.write(sb.toString());
        }
				
		bw.flush();
		bw.close();
		br.close();
		
	}
}
