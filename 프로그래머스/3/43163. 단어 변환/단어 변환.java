import java.util.*;

class Solution {
    
    static class Word {
        String str;
        int depth;
        
        Word(String str, int depth) {
            this.str = str;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));
        
        while (!queue.isEmpty()) {
            Word word = queue.poll();
            
            // System.out.println(word.str + " " + word.depth);
            
            if (word.str.equals(target)) {
                return word.depth;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && diff(word.str, words[i])) {
                    visited[i] = true;
                    queue.add(new Word(words[i], word.depth + 1));
                }
            }
        }
        

        return 0;
    }
    
    private boolean diff(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                cnt++;
            }
            if (cnt > 1) return false;
        }
        return cnt == 1;
    }
}