import java.util.*;
import java.io.*;

public class Main {

	static int N, M, V;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		List<List<Integer>> graph = getGraph();

		dfs(graph, V, new boolean[N + 1]);
		System.out.println();
		bfs(graph, V);
	}

	static void bfs(List<List<Integer>> graph, int start) {
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			for (int next : graph.get(cur)) {
				if (visited[next]) continue;
				visited[next] = true;
				queue.add(next);
			}
		}
	}

	static void dfs(List<List<Integer>> graph, int start, boolean[] visited) {
		System.out.print(start + " ");

		visited[start] = true;

		for (int next : graph.get(start)) {
			if (visited[next]) continue;
			dfs(graph, next, visited);
		}
	}

	static List<List<Integer>> getGraph() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 0; i <= N; i++) Collections.sort(graph.get(i));

		return graph;
	}

}