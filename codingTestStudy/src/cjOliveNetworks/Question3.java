package cjOliveNetworks;

import java.io.*;
import java.util.*;

public class Question3 {
    private static List<int[]> leftList; // 시작 인덱스, 끝 인덱스, 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());

        leftList = new ArrayList<>();

        int maxEscapes = solution(arr, m);

        bw.write(String.valueOf(maxEscapes));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solution(int[] arr, int m) {
        grouping(arr); // 1로 이루어진 뭉치를 찾음

        sorting(arr); // 뭉치 크기순으로 정렬, 감시 대상 상태 고려

        // 방향 변경 (우선순위에 따라 최대 m명까지 변경)
        for (int[] leftBundle : leftList) {
            int start = leftBundle[0];
            int end = leftBundle[1];

            // 뭉치의 모든 요소를 `-1`로 변경
            for (int j = start; j <= end; j++) {
                if (m > 0) {
                    arr[j] = -1;
                    m--;
                } else {
                    break;
                }
            }

            if (m <= 0) break;
        }

        return calculateEscapes(arr); // 변경 후 탈출 가능한 최대 인원 계산
    }

    // 뭉치들을 우선순위에 따라 정렬하는 메서드
    public static void sorting(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            // 1. 뭉치 크기 기준 오름차순 정렬
            if (o1[2] != o2[2]) return Integer.compare(o1[2], o2[2]);

            // 2. 감시 대상 상태에 따라 정렬 (감시 대상이 탈출 가능하지 않은 경우 우선)
            boolean o1AffectsEscape = affectsEscape(arr, o1[1]);
            boolean o2AffectsEscape = affectsEscape(arr, o2[1]);
            if (o1AffectsEscape != o2AffectsEscape) return Boolean.compare(o2AffectsEscape, o1AffectsEscape);

            // 3. 위치 기준 정렬 (중앙에 가까운 뭉치를 우선)
            return Integer.compare(Math.abs(arr.length / 2 - o1[0]), Math.abs(arr.length / 2 - o2[0]));
        });

        pq.addAll(leftList);
        leftList.clear();
        while (!pq.isEmpty()) {
            leftList.add(pq.poll());
        }
    }

    // 특정 뭉치의 감시 대상이 탈출에 영향을 주는지 확인하는 메서드
    private static boolean affectsEscape(int[] arr, int end) {
        int next = (end + 1) % arr.length;
        return arr[next] == -1; // 감시 대상이 아직 탈출할 수 없는 경우 우선순위 부여
    }

    // 1로 이루어진 연속된 뭉치들을 그룹화하는 메서드
    public static void grouping(int[] arr) {
        int n = arr.length;
        int start = -1;
        int size = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                if (size == 0) start = i; // 새로운 뭉치의 시작 인덱스
                size++;
            } else if (size > 0) {
                // 1로 이루어진 뭉치의 시작, 끝, 크기를 저장
                leftList.add(new int[]{start, i - 1, size});
                size = 0;
            }
        }

        // 배열 끝에 도달했을 때 남아있는 뭉치 추가
        if (size > 0) {
            leftList.add(new int[]{start, n - 1, size});
        }
    }

    // 변경된 배열을 기반으로 탈출 가능한 최대 인원을 계산하는 메서드
    private static int calculateEscapes(int[] arr) {
        int n = arr.length;
        boolean[] escaped = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int escapes = 0;

        // 초기 탈출 가능한 사람을 확인하고 큐에 추가
        for (int i = 0; i < n; i++) {
            int left = (i - 1 + n) % n;
            int right = (i + 1) % n;
            if ((arr[i] == 1 && arr[left] != -1) || (arr[i] == -1 && arr[right] != 1)) {
                queue.offer(i);
                escaped[i] = true;
                escapes++;
            }
        }

        // 연쇄적인 탈출 가능 여부를 BFS 방식으로 확인
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int next = (current + 1) % n;
            int prev = (current - 1 + n) % n;

            // 현재 탈출자가 왼쪽을 감시하고 있었고, 오른쪽 사람이 아직 탈출하지 않았다면
            if (arr[current] == 1 && !escaped[next] && arr[next] == -1) {
                escaped[next] = true;
                queue.offer(next);
                escapes++;
            }

            // 현재 탈출자가 오른쪽을 감시하고 있었고, 왼쪽 사람이 아직 탈출하지 않았다면
            if (arr[current] == -1 && !escaped[prev] && arr[prev] == 1) {
                escaped[prev] = true;
                queue.offer(prev);
                escapes++;
            }
        }

        return escapes;
    }
}
