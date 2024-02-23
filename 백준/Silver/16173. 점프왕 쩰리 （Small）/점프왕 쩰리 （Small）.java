import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};

	public static void main(String[] args) throws Exception {
		int[][] map = getMap();
		System.out.println(bfs(map));
	}

	static String bfs(int[][] map) {
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, map[0][0]});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (cur[0] == N - 1 && cur[1] == N - 1) {
				return "HaruHaru";
			}

			for (int i = 0; i < 2; i++) {
				int nx = cur[0] + dx[i] * cur[2];
				int ny = cur[1] + dy[i] * cur[2];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny, map[nx][ny]});
				}
			}
		}

		return "Hing";
	}

	static int[][] getMap() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		return arr;
	}

}