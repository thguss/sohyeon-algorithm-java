import java.util.*;

class Solution {
    
    static int res;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String bin = dec_to_bin(numbers[i]);
            int treeLen = getFullTreeLen(bin);
            boolean[] binary = new boolean[treeLen];
            int idx = treeLen - bin.length(); // 0~idx : false
            for (int j = 0; j < bin.length(); j++) {
                binary[idx++] = bin.charAt(j) == '1';
            }
            
            res = 1;
            solve(0, treeLen - 1, false, binary);
            answer[i] = res;
        }
        
        return answer;
    }
    
    private void solve(int s, int e, boolean isRootDummy, boolean[] binary) {
        int mid = (s + e) / 2; // 다음 루트
        
        if (isRootDummy && binary[mid]) { // 루트가 더미이면 자식은 1이 될 수 없음
            res = 0;
            return;
        }
        
        if (s == e) return; // 마지막 노드
        
        solve(s, mid - 1, !binary[mid], binary); // 왼쪽 서브 트리, 루트가 더미(false)이면 true
        solve(mid + 1, e, !binary[mid], binary); // 오른쪽 서브 트리
    }
    
    private int getFullTreeLen(String bin) {
        int len = bin.length();
        int num = 0, exp = 1;
        while (num < len) {
            num = (int) Math.pow(2, exp++) - 1;  // 노드 수 : 2^H - 1
        }
        return num;
    }
    
    private long bin_to_dec(long num) {
        return Long.parseLong(String.valueOf(num), 2);
    }
    
    private String dec_to_bin(long num) {
        return Long.toString(num, 2);
    }
    
    private void print(Object obj) {
        System.out.println(obj);
    }
}