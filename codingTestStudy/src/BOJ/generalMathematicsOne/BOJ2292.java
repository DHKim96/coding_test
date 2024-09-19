package BOJ.generalMathematicsOne;

import java.util.Scanner;

public class BOJ2292 {
	/*
	 * BOJ NO.2292 : 벌집
	 * 
	 * 1부터 N번 벌집의 층을 depth라고 하고 해당 층의 마지막 벌집의 번호를 r이라고 할 때
	 *  depth = 1, r=1
	 * depth = 2, r=7(6+1)  
	 * depth = 3, r=19(12+7) 
	 * depth = 4, r=37(18+19)
	 * depth = 5, r=61(24+37)
	 * 
	 * => depth = n 일때 r = 6*(직전 depth) + 직전 depth의 r
	 *  
	 *  반복문을 돌려서 N <= r 을 최초로 만족할 때의 depth를 구하면 그게 곧 거리
	 * 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int depth = 1;
		int lastCellInDepth = 1; // 해당 depth의 마지막 벌집의 번호(최댓값)
		
		while( N > lastCellInDepth) {
			lastCellInDepth += 6 * depth;
			depth++;
		}
	
		System.out.println(depth);
		
		sc.close();
	}
}
