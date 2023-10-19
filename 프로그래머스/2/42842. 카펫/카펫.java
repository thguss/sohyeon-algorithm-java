import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for (int i = 3; i <= sum; i++) {
            if (sum % i != 0) continue;
            
            int j = sum / i;
            if (j < 3) continue;
            
            int w = Math.max(i, j);
            int h = Math.min(i, j);
            
            if ((w - 2) * (h - 2) == yellow) {
                answer[0] = w;
                answer[1] = h;
                return answer;
            }
        }
        
        return answer;
    }
}