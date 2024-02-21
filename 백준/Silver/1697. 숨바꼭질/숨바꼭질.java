import java.util.*;
import java.io.*;

public class Main {
	static int N, K;

	public static void main(String[] args) throws Exception {
		getInput();
		System.out.println(bfs());
	}

	static int bfs() {
		boolean[] visited = new boolean[200002];
		visited[N] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {N, 0});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (cur[0] == K) {
				return cur[1];
			}

			// X - 1
			int pos = cur[0] - 1;
			if (isValid(pos, visited)) {
				visited[pos] = true;
				queue.add(new int[] {pos, cur[1] + 1});
			}

			// X + 1
			pos = cur[0] + 1;
			if (isValid(pos, visited)) {
				visited[pos] = true;
				queue.add(new int[] {pos, cur[1] + 1});
			}

			// 2*X
			pos = cur[0] * 2;
			if (isValid(pos, visited)) {
				visited[pos] = true;
				queue.add(new int[] {pos, cur[1] + 1});
			}
		}

		return -1;
	}

	static boolean isValid(int x, boolean[] visited) {
		return (0 <= x && x <= 100000 && !visited[x]);
	}

	static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수빈 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치
	}

}