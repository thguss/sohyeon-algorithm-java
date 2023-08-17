
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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
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

		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		boolean[] visited = new boolean[N + 1];

		ArrayList<Integer>[] routes = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) routes[i] = new ArrayList<>();
		routes[start].add(start);

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int node = cur.node;

			if (visited[node]) continue;
			visited[node] = true;

			for (Node next : graph.get(node)) {
				if (dist[next.node] >= dist[node] + next.cost) {
					dist[next.node] = dist[node] + next.cost;
					pq.offer(new Node(next.node, dist[next.node]));
					ArrayList<Integer> al = new ArrayList<>(routes[node]);
					al.add(next.node);
					routes[next.node] = al;
				}
			}
		}

		System.out.println(dist[end]);
		System.out.println(routes[end].size());
		for (int route : routes[end]) {
			System.out.print(route + " ");
		}
	}


}