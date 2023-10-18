import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        // for (int i : citations) {
        //     System.out.print(i + " ");
        // }
        
        int answer = 0;
        
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // citaions[i] 이상 인용된 논문 수
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}