package PROGRAMMERS.stack_queue;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        //뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있다.
        //뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포된다.

        int day = 0;

        List<Integer> list = new ArrayList<>();

        int idx = 0;

        while(idx < progresses.length){
            int count = 0;

            day++;

            while (idx < progresses.length && progresses[idx] + day * speeds[idx] >= 100){
                count++;
                idx++;
            }

            if (count != 0) list.add(count);
        }


        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
