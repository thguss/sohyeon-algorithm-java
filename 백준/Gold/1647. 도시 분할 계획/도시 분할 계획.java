import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int v;
	int u;
	int r;

	Edge(int v, int u, int r) {
		this.v = v;
		this.u = u;
		this.r = r;
	}

	@Override
	public int compareTo(Edge o) {
		return this.r - o.r;
	}
}

public class Main {

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) parent[i] = i;

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(A, B, C));
		}

		int weight = 0; // MST 만족 비용
		int max = Integer.MIN_VALUE; // 마을 분리를 위해 잘라낼 최대 비용
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (find(cur.v) != find(cur.u)) {
				union(cur.v, cur.u);
				weight += cur.r;
				max = cur.r;
			}
		}

		System.out.println(weight - max);

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

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
}