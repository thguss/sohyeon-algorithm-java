import java.util.*;

class Solution {
    
    List<String> allRoute = new ArrayList<>();
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", "ICN", 0);
        Collections.sort(allRoute);
        String[] arr = allRoute.get(0).split(" ");
        
        return arr;
    }
    
    private void dfs(String[][] tickets, String start, String route, int cnt) {
        if (cnt == tickets.length) {
            allRoute.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (visited[i] || !start.equals(tickets[i][0])) continue;
            visited[i] = true;
            dfs(tickets, tickets[i][1], route + " " + tickets[i][1], cnt + 1);
            visited[i] = false;
        }
    }
}