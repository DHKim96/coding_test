package SSG_coding_test.week5;

import java.io.*;
import java.util.*;

public class BOJ17140{
    /*
        [BOJ]17140 : 이차원 배열과 연산
        
        => 박치기 구현
    */

    public static int[][] A; // 결과 담은 배열
    public static int time; // 시간
    public static Map<Integer, Integer> frequencyMap; // frequencyMap<n, n의 등장 횟수>
    public static List<List<int[]>> sortedList; // 각 행과 열의 [n, n 등장 횟수] 담을 리스트

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(stk.nextToken()) - 1; // 0부터 시작하도록 조정
        int c = Integer.parseInt(stk.nextToken()) - 1; // 0부터 시작하도록 조정
        int k = Integer.parseInt(stk.nextToken());

        A = new int[3][3];
        time = 0;

        for (int i = 0; i < 3; i++){
            stk = new StringTokenizer(br.readLine());

            A[i][0] = Integer.parseInt(stk.nextToken());
            A[i][1] = Integer.parseInt(stk.nextToken());
            A[i][2] = Integer.parseInt(stk.nextToken());
        }

        int result = -1;
        
        frequencyMap = new HashMap<>(); // 숫자는 최대 100개
        
        
        while(time <= 100){ // time < 100 하는 바람에 계속 틀림
            if (isTargetValue(r, c, k)) {
                result = time;
                break;
            }
            
            sortedList = new ArrayList<>();

            if (shouldApplyR()) operateR();
            else operateC();

            time++;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();

    }
    public static boolean isTargetValue(int r, int c, int k){
        return r < A.length && c < A[0].length && A[r][c] == k;
    }

    // R연산인지 C연산인지 확인
    public static boolean shouldApplyR(){
        return A.length >= A[0].length;
    }

    // R연산 => 열 증가
    public static void operateR(){ // 행을 기준으로 정렬하기
        int maxSize = 0;

        for (int i = 0; i < A.length; i++){
            List<int[]> row = new ArrayList<>();

            for (int j = 0; j < A[1].length; j++){
            	if (A[i][j] > 0) frequencyMap.put(A[i][j], frequencyMap.getOrDefault(A[i][j], 0) + 1);
            }

            for (int key : frequencyMap.keySet()) {
            	row.add(new int[] {key, frequencyMap.get(key)});
            }

            maxSize = Math.max(maxSize, 2 * row.size());
            
         // 등장 횟수 오름차순, 같으면 수의 오름차순
            Collections.sort(row, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

            sortedList.add(row);

            frequencyMap = new HashMap<>(); // 초기화
        }

        updateArray(A.length, maxSize, true);
    }

    // C연산 => 행이 증가함
    public static void operateC(){
        int maxSize = 0;

        for (int i = 0; i < A[1].length; i++){
            List<int[]> col = new ArrayList<>();

            for (int j = 0; j < A.length; j++){
            	if (A[j][i] > 0) frequencyMap.put(A[j][i], frequencyMap.getOrDefault(A[j][i], 0) + 1);
            }

            for (int key : frequencyMap.keySet()) {
            	col.add(new int[] {key, frequencyMap.get(key)});
            }

            maxSize = Math.max(maxSize, 2 * col.size());
            
            // 등장 횟수 오름차순, 같으면 수의 오름차순
            Collections.sort(col, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

            sortedList.add(col);

            frequencyMap.clear(); // 초기화
        }

        updateArray(maxSize, A[1].length, false);
    }

    // 정렬된 결과로 배열 새로 만들기
    public static void updateArray(int row, int col, boolean isR){
        row = Math.min(row, 100);
        col = Math.min(col, 100);

        A = new int[row][col];
        
        int slSize = sortedList.size();
        
        int slIdx = 0;
        
        while (slIdx < slSize && slIdx <= 100) {
        	List<int[]> currentList = sortedList.get(slIdx);
        	
        	int clSize = currentList.size();
        	int clIdx = 0;
        	
        	while (clIdx < clSize && 2 * clIdx < 100) {
                int[] pair = currentList.get(clIdx);
                
                if (isR) sortRow(pair, slIdx, clIdx);
                else sortCol(pair, slIdx, clIdx);
                
                clIdx++;
        	}
        	slIdx++;
        }
    }

    public static void sortRow(int[] pair, int slIdx, int clIdx) {
        A[slIdx][2 * clIdx] = pair[0];
        A[slIdx][2 * clIdx + 1] = pair[1];
    }

    public static void sortCol(int[] pair, int slIdx, int clIdx) {
        A[2*clIdx][slIdx] = pair[0];
        A[2*clIdx + 1][slIdx] = pair[1];
    }
}
