package BOJ.algorithm.bruteForce;

import java.util.Scanner;

public class BOJ1436 {
	/*
	 * BOJ NO.1436 : 영화감독 숌
	 * 
	 * 6이 3개 이상 연속으로 들어가야 함
	 * => 6이 비연속적으로 등장할 경우 6의 갯수 무효화하여
	 * 	  연속적으로 3번 등장할 경우만 갯수를 세도록 설정
	 */
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = 0;
		
		int num = 666; // 최초 케이스느 666
		
		while(true) {
			int temp = num;
			
			int digit = 0;
			
			int numOfSix = 0;
			
			while(temp > 0) {
				digit = temp % 10;
				
				temp = (temp - digit) / 10;
				
				numOfSix = digit == 6 ? (numOfSix + 1) : 0; // 비연속적인 경우 이전 6의 갯수 무효화
				
				if(numOfSix >= 3) {  // 연속적으로 3번 등장할 시에만 숫자를 카운트하도록
					count++;
					break;
				}
			}
			
			if(count >= N) {
				System.out.println(num);
				sc.close();
				return;
			}
			
			num++;
		}
	}
}
