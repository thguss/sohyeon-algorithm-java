import java.util.*;
import java.io.*;

public class Main {
	static int N, M;

	public static void main(String[] args) throws Exception {
		List<List<Integer>> graph = getGraph();
		boolean[] visited = new boolean[N + 1];
		int count = 0;

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(graph, visited, i);
				count++;
			}
		}

		System.out.println(count);
	}

	static void bfs(List<List<Integer>> graph, boolean[] visited, int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		visited[start] = true;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : graph.get(cur)) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}

	static List<List<Integer>> getGraph() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		return graph;
	}

}