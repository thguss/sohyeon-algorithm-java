import java.util.*;

class Solution {
    
    // (x, y) -> (r, c) : 총 거리 k
    // dlru
    static int[] dx = {1, 0, 0, -1}, dy = {0, -1, 1, 0};
    static String way = "dlru";
    static int mapR, mapC, endR, endC;
    static String answer = null;
    static StringBuilder sb = new StringBuilder();
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        mapR = n;
        mapC = m;
        endR = r;
        endC = c;
        
        int d = distance(x, y, r, c);
        if (d > k || (k - d) % 2 == 1) return "impossible";
        dfs(x, y, 0, k);
        return answer != null ? answer : "impossible";
    }
    
    private void dfs(int x, int y, int len, int k) {
        if (answer != null) return;
        if (len + distance(x, y, endR, endC) > k) return;
        if (len == k) {
            if (x == endR && y == endC) answer = sb.toString();
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (0 < nx && nx <= mapR && 0 < ny && ny <= mapC) {
                sb.append(way.charAt(i));
                dfs(nx, ny, len + 1, k);
                sb.delete(len, len + 1);
            }
        }
    }
    
    private int distance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
    
    private void print(Object obj) {
        System.out.println(obj);
    }
}