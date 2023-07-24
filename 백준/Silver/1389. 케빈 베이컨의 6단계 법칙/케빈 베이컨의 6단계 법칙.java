
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (!graph.get(a).contains(b)) graph.get(a).add(b);
			if (!graph.get(b).contains(a)) graph.get(b).add(a);
		}

		int cnt = Integer.MAX_VALUE;
		int num = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			int res = getNum(i);
			// System.out.println(i + " " + res);
			if (res < cnt) {
				cnt = res;
				num = i;
			} else if (res == cnt && i < num) {
				num = i;
			}
		}

		System.out.println(num);


	}

	private static int getNum(int num) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {num, 0});

		boolean[] visited = new boolean[N + 1];
		visited[num] = true;

		int res = 0;

		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			if (arr[1] > 0) res += arr[1];
			for (int f : graph.get(arr[0])) {
				if (visited[f]) continue;
				visited[f] = true;
				queue.add(new int[] {f, arr[1] + 1});
			}
		}

		return res;
	}

}