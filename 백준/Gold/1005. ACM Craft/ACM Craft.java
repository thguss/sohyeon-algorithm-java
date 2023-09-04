import java.util.*;
import java.io.*;

public class Main {
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 건물의 개수
			int k = Integer.parseInt(st.nextToken()); // 규칙의 개수
			int[] d = new int[n + 1];
			int[] indegree = new int[n + 1];

			ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				d[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // 전
				int y = Integer.parseInt(st.nextToken()); // 후
				graph.get(x).add(y);
				indegree[y]++;
			}

			int w = Integer.parseInt(br.readLine());

			Queue<Integer> queue  = new LinkedList<>();
			int[] result = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				result[i] = d[i];

				if (indegree[i] == 0) {
					queue.offer(i);
				}
			}

			while (!queue.isEmpty()) {
				int num = queue.poll();

				for (int i : graph.get(num)) {
					result[i] = Math.max(result[i], result[num] + d[i]);
					indegree[i]--;

					if (indegree[i] == 0) {
						queue.offer(i);
					}
				}
			}

			System.out.println(result[w]);
		}
	}
}
