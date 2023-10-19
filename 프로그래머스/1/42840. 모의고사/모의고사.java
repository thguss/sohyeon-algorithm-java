import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        List<Integer> al = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i <= 3; i++) {
            int score;
            if (i == 1) {
                score = getScore(answers, p1);
            } else if (i == 2) {
                score = getScore(answers, p2);
            } else {
                score = getScore(answers, p3);
            }
            // System.out.println(score);
            
            if (score > max) {
                max = score;
                al = new ArrayList<>();
                al.add(i);
            } else if (score == max) {
                al.add(i);
            }
        }
        
        Collections.sort(al);
        
        int[] res = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }
        return res;
    }
    
    private int getScore(int[] answers, int[] pattern) {
        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (i < pattern.length && answers[i] == pattern[i]) {
                score++;
            } else if (i >= pattern.length && answers[i] == pattern[i % pattern.length]) {
                score++;
            }
        }
        return score;
    }
    
    
}