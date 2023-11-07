import java.util.*;
import java.io.*;

public class Main {
	static List<List<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 국가의 수
			int M = Integer.parseInt(st.nextToken()); // 비행기 종류

			visited = new boolean[N + 1];
			graph = new ArrayList<>();
			for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}

			System.out.println(bfs());
		}
	}

	private static int bfs() {
		int res = 0;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		visited[1] = true;

		while (!queue.isEmpty()) {
			res++;
			int cur = queue.poll();

			for (int next : graph.get(cur)) {
				if (visited[next]) {
					continue;
				}
				visited[next] = true;
				queue.add(next);
			}
		}

		return res - 1;
	}
}
