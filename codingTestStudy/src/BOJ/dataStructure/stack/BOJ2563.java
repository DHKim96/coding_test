package BOJ.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
	// 도화지
	private static boolean[][] arr;
	// 색종이 개수
	private static int n;
	// 검은 영역의 넓이
	private static int total;
	
	/**
	 * 검은 영역의 갯수를 세는 메소드
	 * 하나의 좌표는 1x1 박스 한 개를 나타낸다고 가정(x,y 는 자연수).
	 * @param x
	 * @param y
	 */
	public static void count(int x, int y) {
        //(x,y)부터 (x+9, y+9)까지의 영역을 하나씩 체크한 후 총 넓이에 더해준다
        // * x+10, y+10 의 영역을 계산하면 박스가 11x11 개가 되버림
        for (int j = x; j < x+10; j++) {
            for (int k = y; k < y+10; k++) {
            	//불린형 이차원 배열이 false(=흰색)일 경우 카운트함
                if (!arr[j][k]) {
                	// 이미 검은 영역을 또 카운트하지 않도록 카운트하면서 상태값을 true(=검은색)로 변경
                	total++;
                    arr[j][k] = true;
                }
            }
        }
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		total = 0;  //검은 영역의 넓이
        n = Integer.parseInt(br.readLine());  //색종이 개수
        arr = new boolean[100][100];  //100x100 도화지. boolean 형의 기본값은 false(=흰색 영역).
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            count(x, y);
        }
	    br.close();
	    System.out.print(total);
	}

	
}
