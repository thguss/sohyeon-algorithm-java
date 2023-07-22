
import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> al;
	static int res = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		al = new ArrayList<>();
		for (int i = 0; i <= N; i++) al.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			al.get(u).add(v);
			al.get(v).add(u);
		}

		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			dfs(i);
			res++;
		}

		System.out.println(res);

	}

	private static void dfs(int v) {
		if (visited[v]) return;
		visited[v] = true;
		for (int u : al.get(v)) {
			dfs(u);
		}

	}
}