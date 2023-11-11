import java.util.*;

class Solution {
    static class Point implements Comparable<Point> {
        int num;
        int cnt;
        
        Point(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Point p) {
            if (this.cnt == p.cnt) {
                return this.num - p.num;
            }
            return p.cnt - this.cnt;
        }
        
        @Override
        public String toString() {
            return "(" + this.num + " " + this.cnt + ")";
        }
    }
    
    static List<Point> al = new ArrayList<>();
    
    public int[] solution(int e, int[] starts) {
        init(e);
        
        int[] answer = new int[starts.length];
        
        for (int i = 0; i < starts.length; i++) {
            int s = starts[i];
            for (int j = 0; j < al.size(); j++) {
                if (al.get(j).num >= s) {
                    answer[i] = al.get(j).num;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private void init(int e) {
        for (int i = 1; i <= e; i++) {
            al.add(new Point(i, 1));
        }
        
        for (int i = 2; i <= e; i++) {
            for (int j = 1; j <= e / i; j++) {
                al.get(i * j - 1).cnt++;
            }
        }
        
        Collections.sort(al);
    }
}