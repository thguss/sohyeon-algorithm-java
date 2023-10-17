import java.util.*;

class Solution {
    static class Process {
        int id;
        int priority;
        
        Process(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
            pq.add(priorities[i]);
        }
        
        int order = 1;
        while (!queue.isEmpty()) {
            Process process = queue.poll();
            int priority = pq.peek();
            if (process.priority == priority) {
                pq.poll();
                if (process.id == location) return order;
                order++;
            } else {
                queue.add(process);
            }
        }
        
        
        int answer = 0;
        return answer;
    }
}