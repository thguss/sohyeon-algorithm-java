import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		solve();
	}

	static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			graph.get(n1).add(new int[] {n2, distance});
			graph.get(n2).add(new int[] {n1, distance});
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			sb.append(bfs(n1, n2, graph)).append("\n");
		}

		System.out.println(sb);
	}

	static int bfs(int n1, int n2, List<List<int[]>> graph) {
		boolean[] visited = new boolean[N + 1];
		visited[n1] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {n1, 0});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (cur[0] == n2) {
				return cur[1];
			}

			for (int[] next : graph.get(cur[0])) {
				if (visited[next[0]]) continue;
				visited[next[0]] = true;
				queue.add(new int[] {next[0], next[1] + cur[1]});
			}
		}

		return -1;
	}
}