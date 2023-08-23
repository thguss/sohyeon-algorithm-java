import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int n1;
	int n2;
	int cost;

	Edge(int n1, int n2, int cost) {
		this.n1 = n1;
		this.n2 = n2;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class Main {

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(a, b, c));
		}

		int weight = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (find(cur.n1) != find(cur.n2)) {
				union(cur.n1, cur.n2);
				weight += cur.cost;
			}
		}

		System.out.println(weight);

	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	private static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if (ra <= rb) {
			parent[rb] = ra;
		} else {
			parent[ra] = rb;
		}
	}
}