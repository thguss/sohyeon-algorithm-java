import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        
        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i : queue1) {
            q1.add(i);
        }
        
        for (int i : queue2) {
            q2.add(i);
        }
        
        int answer = 0;
        long mid = (sum1 + sum2) / 2;
        
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (sum1 == mid) {
                return answer;
            } else if (sum1 > mid) {
                sum1 -= q1.poll();
            } else { // sum1 < mid
                int temp = q2.poll();
                sum1 += temp;
                q1.add(temp);
            }
            answer++;
        }
        
        return -1;
    }
}