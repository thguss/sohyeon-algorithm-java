
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] land;
	static int[] goal = new int[2];
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visited;
	static int[][] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		land = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
				if (land[i][j] == 2) {
					goal[0] = i;
					goal[1] = j;
				}
			}
		}

		visited = new boolean[N][M];
		distance = new int[N][M];

		getDistance(goal[0], goal[1]);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && land[i][j] == 1) {
					sb.append(-1).append(" ");
				} else {
					sb.append(distance[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	private static void getDistance(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (visited[nx][ny] || land[nx][ny] == 0) continue;
					distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}
	}

}