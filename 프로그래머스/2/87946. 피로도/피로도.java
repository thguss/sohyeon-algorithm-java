import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        permutation(dungeons, new int[dungeons.length], 0, k);
        return max;
    }
    
    private void permutation(int[][] dungeons, int[] arr, int cnt, int k) {
        if (dungeons.length == cnt) {
            int res = explore(dungeons, arr, k);
            max = Math.max(max, res);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i;
            permutation(dungeons, arr, cnt + 1, k);
            visited[i] = false;
        }
    }
    
    private int explore(int[][] dungeons, int[] arr, int k) {
        int cnt = 0;
        
        for (int i : arr) { // {최소 필요 피로도, 소모 피로도}
            if (k <= 0) break;
            int[] dungeon = dungeons[i];
            if (k >= dungeon[0]) {
                k -= dungeon[1];
                cnt++;
            }
        }
        
        // System.out.println(Arrays.toString(arr) + " " + cnt);
        
        return cnt;
    }
}