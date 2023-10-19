import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n - 1; i++) {
            parent = new int[n + 1];
            for (int k = 1; k <= n; k++) parent[k] = k;
            for (int j = 0; j < n - 1; j++) {
                if (i == j) continue;
                int p1 = find(wires[j][0]);
                int p2 = find(wires[j][1]);
                if (p1 != p2) union(p1, p2);
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j <= n; j++) {
                int p = find(j);
                if (!map.containsKey(p)) map.put(p, 0);
                map.put(p, map.get(p) + 1);
            }
            List<Integer> al = new ArrayList<>();
            for (int key : map.keySet()) {
                al.add(map.get(key));
            }
            min = Math.min(min, Math.abs(al.get(0) - al.get(1)));
        }
        
        
        // int answer = -1;
        return min;
    }
    
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
        
        if (ap <= bp) parent[ap] = bp;
        else parent[bp] = ap;
    }
}