import java.util.*;

class Solution {
    
    static class Work {
        int progress;
        int speed;
        
        Work(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
        
        public int getTotalProgress(int day) {
            return this.progress + this.speed * day;
        }
        
        public String toString() {
            return progress + " " + speed;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Work> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(new Work(progresses[i], speeds[i]));
        }
        
        List<Integer> al = new ArrayList<>();
        int day = 0, count = 0;
        
        while (!queue.isEmpty()) {
            Work work = queue.peek();
            
            if (work.getTotalProgress(day) >= 100) { // 진행 완료
                queue.poll();
                count++;
            } else { // 진행 중
                if (count > 0) { // 배포 작업이 있으면 반영 후 초기화
                    al.add(count);
                    count = 0;
                }
                day++;
            }
        }
        
        if (count > 0) al.add(count);
        
        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}