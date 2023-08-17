
import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int node;
	int cost;

	Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {

	static int N, M;
	static ArrayList<ArrayList<Node>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 도시 개수
		M = Integer.parseInt(br.readLine()); // 버스 개수

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		System.out.println(dijkstra(start, end));
	}

	private static int dijkstra(int start, int end) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		boolean[] visited = new boolean[N + 1];

		Queue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int node = cur.node;

			if (visited[node]) continue;
			visited[node] = true;

			for(Node next : graph.get(node)) {
				if (dist[next.node] >= dist[node] + next.cost) {
					dist[next.node] = dist[node] + next.cost;
					queue.offer(new Node(next.node, dist[next.node]));
				}
			}
		}

		return dist[end];
	}

}