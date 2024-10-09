package BOJ;

import java.util.Scanner;

public class Main {
	/*
    BOJ NO.24264 : 알고리즘 수업 - 알고리즘의 수행 시간 3
    */

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	
    	System.out.println( (long)n * ( n - 1 )  / 2);
    	System.out.println(2);
    	
    	sc.close();
    }
}
