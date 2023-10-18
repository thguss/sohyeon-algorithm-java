import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 요청 기준 정렬
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 소요시간 기준
        
        int count = 0, index = 0, time = 0, answer = 0;
        while(count < jobs.length) {
            // 처리 가능한 요청 추가
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.add(jobs[index++]);
            }
            
            if (pq.isEmpty()) time = jobs[index][0]; // 요청 시간
            else {
                int[] job = pq.poll();
                time += job[1];
                answer += time - job[0];
                count++; // 요청 처리
            }
        }
        
        return (int) Math.floor(answer / jobs.length);
    }
}