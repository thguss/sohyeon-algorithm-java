import java.util.*;

class Solution {
    
    static String[] arr;
    static int cnt = 0, answer;
    
    public int solution(String word) {
        arr = new String[] {"A", "E", "I", "O", "U"};
        permutation("", word);
        

        return answer;
    }
    
    private void permutation(String str, String word) {
        if (str.length() >= 1 && str.length() <= 5) {
            cnt++;
            if (str.equals(word)) {
                answer = cnt;
                return;
            }
            if (str.length() == 5) return;
        }
        
        for (int i = 0; i < 5; i++) {
            permutation(str + arr[i], word);
        }
    }
}