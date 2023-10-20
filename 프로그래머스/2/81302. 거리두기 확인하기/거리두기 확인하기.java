import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            answer[i] = solve(places[i]) ? 1 : 0;
        }
        
        return answer;
    }
    
    private boolean solve(String[] arr) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i].charAt(j) == 'P') {
                    if(!bfs(i, j, arr)) return false;
                }
            }
        }
        return true;
    }
    
    private boolean bfs(int x, int y, String[] arr) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0});
        
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                    if(visited[nx][ny] || arr[nx].charAt(ny) == 'X') continue;
                    if(arr[nx].charAt(ny) == 'P' && cur[2] + 1 <= 2) return false;
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, cur[2] + 1});
                }
            }
        }
        
        return true;
    }
}