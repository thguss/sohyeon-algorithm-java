import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int indexA = 0;
        int indexB = 0;
        int answer = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[indexA] >= B[indexB]) {
                indexB++;
            } else {
                indexA++;
                indexB++;
                answer++;
            }
        }

        return answer;
    }
}