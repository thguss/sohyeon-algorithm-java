import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);
        
        for (int i : lost) {
            arr[i]--;
        }
        for (int i : reserve) {
            arr[i]++;
        }
        
        // System.out.println("Init: " + Arrays.toString(arr));
        
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(arr[i] >= 1) cnt++;
        }
        
        answer = cnt;
        dfs(arr, 1, cnt);
        
        return answer;
    }
    
    private void dfs(int[] arr, int start, int cnt) {
        answer = Math.max(answer, cnt);
        
        if (start == arr.length) {
            return;
        }
        
        for(int i = start; i < arr.length; i++) {
            if(arr[i] == 2) {
                if(i - 1 > 0 && arr[i - 1] == 0) {
                    arr[i - 1] = 1;
                    dfs(arr, i + 1, cnt + 1);
                    arr[i - 1] = 0;
                }
                if(i + 1 < arr.length && arr[i + 1] == 0) {
                    arr[i + 1] = 1;
                    dfs(arr, i + 1, cnt + 1);
                    arr[i + 1] = 0;
                }
            }
        }
    }
}