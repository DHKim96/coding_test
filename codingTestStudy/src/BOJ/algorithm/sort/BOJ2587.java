package BOJ.algorithm.sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ2587 {
	/*
	 * BOJ NO.2587 : 대표값2
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[5];
		
		int total = 0;
		
		for(int i = 0; i < nums.length; i++) {
			int num = sc.nextInt();
			nums[i] = num;
			total += num;
		}
		
		Arrays.sort(nums);
		
		System.out.println(total / 5);
		System.out.println(nums[2]);
		
		sc.close();
	}
}
