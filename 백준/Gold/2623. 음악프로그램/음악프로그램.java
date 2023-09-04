import java.util.*;
import java.io.*;

public class Main {

	static ArrayList<ArrayList<Integer>> graph;
	static int[] indegree;
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

		indegree = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			for (int j = 1; j < num; j++) {
				int y = Integer.parseInt(st.nextToken());
				graph.get(x).add(y);
				indegree[y]++;
				x = y;
			}
		}

		solve();
	}

	private static void solve() {
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int num = queue.poll();
			result.add(num);
			for (int next : graph.get(num)) {
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}

		if (result.size() != n) {
			System.out.println(0);
		} else {
			for (int num : result) {
				System.out.println(num);
			}
		}
	}
}
