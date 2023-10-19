import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int w = 0, h = 0;
        for (int[] size : sizes) {
            int i = size[0] > size[1] ? 0 : 1;
            int j = 1 - i;
            w = Math.max(w, size[i]);
            h = Math.max(h, size[j]);
        }
        // System.out.println(w + " " + h);
        return w * h;
    }
}