import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int num;
	int cost;

	public Node(int num, int cost) {
		this.num = num;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {

	static int n, m;
	static ArrayList<ArrayList<Node>> graph;
	static int[] item;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 지역의 개수
		m = Integer.parseInt(st.nextToken()); // 수색 범위
		int r = Integer.parseInt(st.nextToken()); // 길의 개수

		item = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, l));
			graph.get(b).add(new Node(a, l));
		}

		int max = Integer.MIN_VALUE;

		// System.out.println(Arrays.toString(item));

		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dijkstra(i));
		}

		System.out.println(max);

	}

	private static int dijkstra(int start) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		boolean[] visited = new boolean[n + 1];

		Queue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));

		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int num = cur.num;

			if (visited[num]) continue;
			visited[num] = true;

			for (Node next : graph.get(num)) {
				if (!visited[next.num] && dist[next.num] > dist[num] + next.cost) {
					dist[next.num] = dist[num] + next.cost;
					queue.add(new Node(next.num, dist[next.num]));
				}
			}
		}

		int cost = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] <= m) {
				cost += item[i];
			}
		}

		return cost;
	}

}