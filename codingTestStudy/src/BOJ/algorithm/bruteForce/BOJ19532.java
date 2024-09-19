package BOJ.algorithm.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ19532 {
	/*
	 * BOJ NO.19532 : 수학은 비대면강의입니다
	 * 연립방정식의 해(x,y) 구하기
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		int d = Integer.parseInt(input[3]);
		int e = Integer.parseInt(input[4]);
		int f = Integer.parseInt(input[5]);
		
		for(int x = -999; x <= 999; x++) {
			for(int y = -999; y <= 999; y++) {
				if(a*x + b*y == c) {
					if(d*x + e*y == f) {
						System.out.println(x + " " + y);
						br.close();
						return;
					}
				}
			}
		}
	}
}
