import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int l = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()), sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken()), ey = Integer.parseInt(st.nextToken());
			System.out.println(bfs(l, sx, sy, ex, ey));
		}
	}

	private static int bfs(int l, int sx, int sy, int ex, int ey) {
		boolean[][] visited = new boolean[l][l];
		visited[sx][sy] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {sx, sy, 0});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == ex && cur[1] == ey) return cur[2];

			for (int i = 0; i < 8; i++) {
				int nx = cur[0] + dx[i], ny = cur[1] + dy[i];
				if (0 <= nx && nx < l && 0 <= ny && ny < l) {
					if (visited[nx][ny]) continue;
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny, cur[2] + 1});
				}
			}
		}

		return -1;
	}

}
