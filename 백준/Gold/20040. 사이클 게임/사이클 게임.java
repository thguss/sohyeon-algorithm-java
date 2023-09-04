import java.util.*;
import java.io.*;

class Route {
	int p1;
	int p2;

	Route(int p1, int p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
}

public class Main {

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 점의 개수
		int m = Integer.parseInt(st.nextToken()); // 차례의 개수

		ArrayList<Route> graph = new ArrayList<>();
		parent = new int[n];
		for (int i = 0; i < n; i++) parent[i] = i;

		boolean flag = false;
		int cnt = 0;

		for (int i = 1; i <= m; i++) {
			cnt++;

			st = new StringTokenizer(br.readLine());

			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());

			graph.add(new Route(p1, p2));
			int pa = find(p1);
			int pb = find(p2);
			if (pa != pb) {
				union(p1, p2);
			} else {
				flag = true;
				break;
			}

		}

		System.out.println(flag ? cnt : 0);
	}

	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa <= pb) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}
	}
}
