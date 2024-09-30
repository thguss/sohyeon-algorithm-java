import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int V = Integer.valueOf(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS
        boolean[] visited = new boolean[N + 1];
        dfs(graph, V, visited);
        
        bw.write("\n");

        // BFS
        visited = new boolean[N + 1];
        visited[V] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            bw.write(String.valueOf(x) + " ");

            for (int next : graph.get(x)) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(next);
            }
        }
        
        bw.flush();
    }

    private static void dfs(List<List<Integer>> graph, int x, boolean[] visited) throws Exception {
        bw.write(String.valueOf(x) + " ");
        visited[x] = true;

        for (int next : graph.get(x)) {
            if (visited[next]) continue;
            dfs(graph, next, visited);
        }
    }

}