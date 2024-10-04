import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int solve(int N, List<List<int[]>> graph) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[] {1, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int cnt = cur[1];

            if (cnt > distance[num]) continue;

            for (int[] next : graph.get(num)) {
                if (distance[next[0]] > distance[num] + next[1]) {
                    distance[next[0]] = distance[num] + next[1];
                    queue.add(new int[] {next[0], distance[next[0]]});
                }
            }
        }

        return distance[N] != Integer.MAX_VALUE ? distance[N] : -1;
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            int k = Integer.valueOf(st.nextToken());
            graph.get(u).add(new int[] {v, k});
            graph.get(v).add(new int[] {u, k});
        }

        int res = solve(N, graph);

        bw.write(String.valueOf(res));
        bw.flush();
    }

}