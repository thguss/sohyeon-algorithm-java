import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(computers, n, i);
            answer++;
        }
        
        return answer;
    }
    
    private void dfs(int[][] computers, int n, int i) {
        visited[i] = true;
        
        for (int j = 0; j < n; j++) {
            if (i != j && computers[i][j] == 1 && !visited[j]) {
                dfs(computers, n, j);
            }
        }
    }
}