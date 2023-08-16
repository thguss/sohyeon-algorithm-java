
import java.io.*;
import java.util.*;

public class Main {

	static int N, E;
	static ArrayList<ArrayList<int[]>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new int[] {b, c});
			graph.get(b).add(new int[] {a, c});
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		// v1 <-> v2
		int v_dist = dijkstra(v1, v2);
		if (v_dist == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			int dist1 = dijkstra(1, v1) + v_dist + dijkstra(v2, N);
			int dist2 = dijkstra(1, v2) + v_dist + dijkstra(v1, N);
			if (dist1 < 0 && dist2 < 0) {
				System.out.println(-1);
			} else if (dist1 < 0) {
				System.out.println(dist2);
			} else if (dist2 < 0) {
				System.out.println(dist1);
			} else {
				System.out.println(Math.min(dist1, dist2));
			}
		}
	}

	private static int dijkstra(int start, int end) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < N; i++) {
			int value = Integer.MAX_VALUE;
			int node = 0;
			for (int j = 1; j <= N; j++) {
				if (visited[j] || dist[j] >= value) continue;
				value = dist[j];
				node = j;
			}
			visited[node] = true;
			for (int[] next : graph.get(node)) {
				int n = next[0];
				int c = next[1];
				dist[n] = Math.min(dist[n], dist[node] + c);
			}
		}

		return dist[end];
	}

}