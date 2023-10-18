import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        
        int cnt = 0;
        
        while (pq.peek() < K) {
            if (pq.size() < 2) return -1;
            int a = pq.poll();
            int b = pq.poll();
            int res = a + (b * 2);
            pq.add(res);
            cnt++;
        }

        return cnt;
    }
}