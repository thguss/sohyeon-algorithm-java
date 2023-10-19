import java.util.*;

class Solution {
    
    static int[][] map;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        
        for (int[] arr : rectangle) {
            fill(arr[0] * 2, arr[1] * 2, arr[2] * 2, arr[3] * 2);
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {characterX * 2, characterY * 2, 0});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            // System.out.println(Arrays.toString(cur));
            
            if (cur[0] == itemX * 2 && cur[1] == itemY * 2) {
                return cur[2] / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (0 < nx && nx <= 100 && 0 < ny && ny <= 100) {
                    if (visited[nx][ny] || map[nx][ny] != 1) continue;
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, cur[2] + 1});
                }
            }
        }
        
        return 0;
    }
    
    private void fill(int x1, int y1, int x2, int y2) { // 가장자리 1, 내부 2
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (map[i][j] == 2) continue;
                map[i][j] = (i == x1 || i == x2 || j == y1 || j == y2) ? 1 : 2;
            }
        }
    }
}