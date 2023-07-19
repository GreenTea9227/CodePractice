import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
         Queue<Node> queue = new PriorityQueue<>((a,b) ->  a.fail != b.fail ? Float.compare(b.fail ,a.fail) :a.index - b.index);

        int[] stageNumber = new int[N + 2];
        int people = stages.length;

        for (int stage : stages) {
            stageNumber[stage]++;
        }
        for (int i = 1; i < stageNumber.length-1; i++) {
            float fail = (float) stageNumber[i] / people;
             if (people ==0)
                fail = 0;
            queue.offer(new Node(fail,i));
            people -= stageNumber[i];
        }

         int[] answer = new int[N];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll().index;
        }

        return answer;
    }

    static class Node {
        private float fail;
        private int index;

        public Node(float fail, int index) {
            this.fail = fail;
            this.index = index;
        }
    }
}