package BOJ.divisorMultiplePrimeNumber;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ9506 {
	/*
	 * BOJ NO.9506 : 약수들의 합
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = sc.nextInt();
			
			if(n == -1) break;
			
			int sum = 0;
			boolean isFirst = true; // 첫 번째 약수에는 약수 앞에 + 가 안붙기 때문에 첫 번째 약수 여부 저장 위한 변수
			StringBuilder temp = new StringBuilder(); // 약수 저장하기 위한 스트링 빌더
			temp.append(n).append(" = ");

			
			for (int num = 1; num < n; num++) {
				if ( (n % num) == 0 ) {
					sum += num;
					if (!isFirst) {
						temp.append(" + ");
					}
					temp.append(num);
					isFirst = false;
				}
			}
			
			if (sum != n) {
				sb.append(n).append(" ").append("is NOT perfect.");
			} else {
				sb.append(temp.toString());
			}
			
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		sc.close();
	}
}
