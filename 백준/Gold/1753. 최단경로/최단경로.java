import java.util.*;
import java.io.*;

public class Main {

	static int V, E, K;

	public static void main(String[] args) throws Exception {
		List<List<int[]>> graph = getGraph();
		int[] distance = getDistance(graph);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(distance[i] != Integer.MAX_VALUE ? distance[i] : "INF").append("\n");
		}

		System.out.println(sb);
	}

	static int[] getDistance(List<List<int[]>> graph) {
		int[] distance = new int[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;

		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		queue.add(new int[] {K, 0});

		boolean[] visited = new boolean[V + 1];

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (visited[cur[0]]) continue;
			visited[cur[0]] = true;

			for (int[] next : graph.get(cur[0])) {
				if (distance[next[0]] > cur[1] + next[1]) {
					distance[next[0]] = cur[1] + next[1];
					queue.add(new int[] {next[0], distance[next[0]]});
				}
			}
		}

		return distance;
	}

	static List<List<int[]>> getGraph() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(u).add(new int[] {v, c});
		}

		return graph;
	}

}