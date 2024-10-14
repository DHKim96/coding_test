package BOJ.algorithm.sort;

import java.io.*;

public class BOJ24060 {
    /*
        BOJ NO.24060 : 알고리즘 수업 - 병합 정렬 1
        병합 정렬 수행 시 K번째 저장되는 수를 구해 반환하기
     */
    private static int[] tempArr; // 병합 과정에서 정렬하여 원소 담을 임시 배열
    private static int count; // 저장 순서를 저장하기 위한 변수
    private static int K;
    private static int result = -1; // 초기값을 -1로 설정(k번째 원소가 없을 시를 대비)

    /**
     * 부분리스트들을 비교 후 정렬하는 메소드
     *
     * @param arr   : 병합 대상 배열
     * @param left  : 배열의 시작점
     * @param mid   : 중간 지점
     * @param right : 마지막 지점
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int l = left; // 왼쪽 부분리스트의 시작점
        int r = mid + 1; // 오른쪽 부분리스트의 시작점
        int idx = left; // 채워 넣을 배열의 인덱스

        // 부분리스트들의 각 인덱스들의 크기를 비교해서 작은 값들을 임시 배열에 삽입
        while (l <= mid && r <= right) { // 각 부분리스트의 마지막 지점까지
            if (arr[l] <= arr[r]) {
                tempArr[idx++] = arr[l++];
            } else {
                tempArr[idx++] = arr[r++];
            }
        }

        // 한 쪽 부분리스트가 먼저 새 배열에 모두 채워질 수 있기에
        // 나머지 부분리스트들을 새 배열에 채워 넣어줘야 함

        // 오른쪽 부분리스트의 원소가 남았을 시 나머지 원소들을 배열에 채워넣기
        while (r <= right) {
            tempArr[idx++] = arr[r++];
        }
        // 왼쪽 부분리스트의 원소가 남았을 시 나머지 원소들을 배열에 넣기
        while (l <= mid) {
            tempArr[idx++] = arr[l++];
        }

        
        // 정렬된 배열을 기존 배열에 복사하기
        for(int i = left; i <= right; i++) {
            arr[i] = tempArr[i];
            count++;
            if (count == K){
                result = arr[i];
                return; // 본 문항은 굳이 정렬까지 수행할 필요가 없음
            }
        }
    }

    /**
     * 부분리스트들을 병합 작업하는 메소드
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right) {
        // 시작점과 끝점이 같은 경우 == 원소가 1개인 배열인 경우 재귀 탈출
        if(left == right) return;

        int mid = (left + right) / 2; // 절반 위치 산출

        mergeSort(arr, left, mid); // 왼쪽 부분리스트
        mergeSort(arr, mid + 1, right); // 오른쪽 부분리스트

        merge(arr, left, mid, right); // 병합 작업
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열 A의 크기 N, 저장 횟수 K 입력 받기
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        tempArr = new int[N];
        int[] arr = new int[N];
        count = 0;

        String[] input2 = br.readLine().split(" ");

        // 배열 A에 A1,A2, ... , AN 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        mergeSort(arr, 0, N - 1);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
