import java.util.*;

class Solution {    
    private int[] parent = new int[50 * 50 + 1];
    private String[] value = new String[50 * 50 + 1];
    
    public String[] solution(String[] commands) {
        for (int i = 1; i <= 50 * 50; i++) {
            parent[i] = i;
            value[i] = "";
        }
        
        ArrayList<String> al = new ArrayList<>();
        
        for (String command : commands) {
            String[] arr = command.split(" ");
            
            if (arr[0].equals("UPDATE") && arr.length == 4) { // UPDATE r c value
                int r = Integer.valueOf(arr[1]);
                int c = Integer.valueOf(arr[2]);
                String v = arr[3];
                updateByPos(r, c, v);
            } else if (arr[0].equals("UPDATE") && arr.length == 3) { // UPDATE value1 value2
                String v1 = arr[1];
                String v2 = arr[2];
                updateByWord(v1, v2);
            } else if (arr[0].equals("MERGE")) { // MERGE r1 c1 r2 c2
                int r1 = Integer.valueOf(arr[1]);
                int c1 = Integer.valueOf(arr[2]);
                int r2 = Integer.valueOf(arr[3]);
                int c2 = Integer.valueOf(arr[4]);
                merge(convertIdx(r1, c1), convertIdx(r2, c2));
            } else if (arr[0].equals("UNMERGE")) { // UNMERGE r c
                int r = Integer.valueOf(arr[1]);
                int c = Integer.valueOf(arr[2]);
                unmerge(r, c);
            } else { // PRINT r c
                int r = Integer.valueOf(arr[1]);
                int c = Integer.valueOf(arr[2]);
                int idx = convertIdx(r, c);
                int p = find(idx);
                al.add(!value[p].equals("") ? value[p] : "EMPTY");
            }
        }
        
        String[] answer = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
    
    private int convertIdx(int r, int c) {
        return (50 * (r - 1)) + c;
    }
    
    private void unmerge(int r, int c) {
        int idx = convertIdx(r, c);
        int p = find(idx);
        String v = value[p];
        value[p] = "";
        value[idx] = v;
        
        List<Integer> deletes = new ArrayList<>();
        for (int i = 1; i <= 2500; i++) {
            if (p == find(i)) deletes.add(i);
        }
        for (int d : deletes) {
            parent[d] = d;
        }
    }
    
    private void merge(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            String v = value[px].equals("") ? value[py] : value[px];
            value[px] = "";
            value[py] = "";
            union(px, py);
            value[px] = v;
        }
    }
    
    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[py] = px;
        }
    }
    
    private void updateByWord(String v1, String v2) {
        for (int i = 1; i <= 50 * 50; i++) {
            if (value[i].equals(v1)) {
                value[i] = v2;
            }
        }
    }
    
    private void updateByPos(int r, int c, String v) {
        int x = convertIdx(r, c);
        value[find(x)] = v;
    }
}