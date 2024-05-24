import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		solve();
	}

	static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int exp = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (exp == 0) {
				union(a, b);
			} else {
				int pa = find(a);
				int pb = find(b);
				sb.append(pa == pb ? "yes" : "no").append("\n");
			}
		}

		System.out.println(sb);
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa != pb) {
			if (pa <= pb) {
				parent[pb] = pa;
			} else {
				parent[pa] = pb;
			}
		}
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

}