import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

	static String solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) parent[i] = i;

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int link = Integer.parseInt(st.nextToken());
				if (link == 1) {
					union(i, j);
				}
			}
		}


		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < M; i++) {
			int c = Integer.parseInt(st.nextToken());
			if (p != find(c)) return "NO";
		}
		return "YES";
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa == pb) return;

		if (pa <= pb) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}
	}

}