package BOJ.divisorMultiplePrimeNumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ5086 {
	/*
	 * BOJ NO.5086 : 배수와 약수
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		while ( true ) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			
			if ( A == 0 && B == 0 ) break;
			
			if ( B % A == 0 ) sb.append("factor");
			else if ( A % B == 0 ) sb.append("multiple");
			else sb.append("neither");
			
			sb.append("\n");
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
}
