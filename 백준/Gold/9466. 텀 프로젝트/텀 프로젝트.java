import java.util.*;
import java.io.*;

public class Main { // 그래프 이론, DFS

	static boolean[] visited, done;
	static int[] arr;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			count = 0;
			arr = new int[N + 1];
			visited = new boolean[N + 1];
			done = new boolean[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i<= N; i++) {
				if (!done[i]) {
					dfs(i);
				}
			}

			System.out.println(N - count);
		}

	}

	private static void dfs(int x) {
		if (visited[x]) {
			done[x] = true;
			count++;
		} else {
			visited[x] = true;
		}

		int next = arr[x];
		if (!done[next]) {
			dfs(next);
		}

		visited[x] = false;
		done[x] = true;

	}
}
