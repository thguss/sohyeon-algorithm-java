import java.util.*;

class Solution {
    class Edge implements Comparable<Edge> {
        int num;
        int cost;
        
        Edge (int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
    
    List<List<Edge>> graph = new ArrayList<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] fare : fares) {
            graph.get(fare[0]).add(new Edge(fare[1], fare[2]));
            graph.get(fare[1]).add(new Edge(fare[0], fare[2]));
        }
        
        int[] distanceS = dijkstra(s, n);
        int[] distanceA = dijkstra(a, n);
        int[] distanceB = dijkstra(b, n);
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            if (impossible(distanceS[i]) || impossible(distanceA[i]) || impossible(distanceB[i])) {
                continue;
            }
            answer = Math.min(answer, distanceS[i] + distanceA[i] + distanceB[i]);
        }
        return answer;
    }
    
    private boolean impossible(int i) {
        return i == Integer.MAX_VALUE;
    }
    
    private int[] dijkstra (int start, int n) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            
            for (Edge next : graph.get(now.num)) {
                if (distance[next.num] > distance[now.num] + next.cost) {
                    distance[next.num] = distance[now.num] + next.cost;
                    pq.add(new Edge(next.num, distance[next.num]));
                }
            }
        }
        
        return distance;
    }
}