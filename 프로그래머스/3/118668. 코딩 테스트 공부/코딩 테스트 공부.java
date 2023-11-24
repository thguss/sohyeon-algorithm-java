import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int alpMax = alp;
        int copMax = cop;
        for (int[] problem : problems) {
            alpMax = Math.max(alpMax, problem[0]);
            copMax = Math.max(copMax, problem[1]);
        }
        
        int[][] dp = new int[alpMax + 1][copMax + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        alp = Math.min(alp, alpMax);
        cop = Math.min(cop, copMax);
        dp[alp][cop] = 0;
        
        for (int i = alp; i <= alpMax; i++) {
            for (int j = cop; j <= copMax; j++) {
                if (i != alpMax) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                if (j != copMax) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                
                for (int[] problem : problems) {
                    int alp_req = problem[0];
                    int cop_req = problem[1];
                    int alp_rwd = problem[2];
                    int cop_rwd = problem[3];
                    int cost = problem[4];
                    
                    if (i >= alp_req && j >= cop_req) { // 풀 수 있는 문제
                        int alp_next = i + alp_rwd >= alpMax ? alpMax : i + alp_rwd;
                        int cop_next = j + cop_rwd >= copMax ? copMax : j + cop_rwd;
                        dp[alp_next][cop_next] = Math.min(dp[alp_next][cop_next], dp[i][j] + cost);
                    }
                }
            }
        }
        
        return dp[alpMax][copMax];
    }
}