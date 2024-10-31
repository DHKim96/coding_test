package PROGRAMMERS.bruteForce;

import java.util.ArrayList;
import java.util.List;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        List<int[]> divisorList = divisors(brown + yellow);
        int[] answer = new int[2];

        for (int[] nums : divisorList) {
            int col = Math.max(nums[0], nums[1]);
            int row = Math.min(nums[0], nums[1]);

            if (yellow == (row - 2) * (col - 2)) {
                answer[0] = col;
                answer[1] = row;
                break;
            }
        }

        return answer;
    }

    public List<int[]> divisors(int num) {
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                list.add(new int[]{i, num / i});
            }
        }
        return list;
    }
}
