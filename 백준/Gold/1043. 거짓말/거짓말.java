
import java.io.*;
import java.util.*;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 파티 수

		boolean[] isKnow = new boolean[N + 1];

		ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
		for (int i = 0; i < M; i++) parties.add(new ArrayList<>());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) parent[i] = i;

		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken()); // 거짓말을 아는 사람의 수
		for (int i = 0; i < num; i++) {
			isKnow[Integer.parseInt(st.nextToken())] = true;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken()); // 파티에 오는 사람 수

			if (num <= 1) {
				parties.get(i).add(Integer.parseInt(st.nextToken()));
				continue;
			}

			int temp = Integer.parseInt(st.nextToken());
			parties.get(i).add(temp);
			for (int j = 0; j < num - 1; j++) {
				int p = Integer.parseInt(st.nextToken());
				parties.get(i).add(p);
				if (find(temp) != find(p)) {
					union(temp, p);
				}
				temp = p;
			}
		}

		// System.out.println(Arrays.toString(parent));

		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (isKnow[i] && !visited[i]) {
				int root = find(i);
				for (int j = 1; j <= N; j++) {
					if (find(j) == root) {
						visited[j] = true;
						isKnow[j] = true;
					}
				}
			}
		}

		// System.out.println(Arrays.toString(isKnow));

		int res = 0;

		for (ArrayList<Integer> party : parties) {
			// System.out.println();
			boolean isLie = true;
			for (int p : party) {
				// System.out.print(p + "(" + isKnow[p] + ")");
				if (isKnow[p]) {
					isLie = false;
					break;
				}
			}
			// System.out.println(party + " " + isLie);
			if (isLie) res++;
		}

		System.out.println(res);

	}

	private static int find(int x) {
		if (parent[x] == x) return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa < pb) parent[pb] = pa;
		else parent[pa] = pb;
	}

}