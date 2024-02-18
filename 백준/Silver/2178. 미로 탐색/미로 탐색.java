import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		int[][] maze = getMaze();
		System.out.println(getDistance(maze));
	}

	static int getDistance(int[][] maze) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 1});

		boolean[][] visited = new boolean[N][M];

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (cur[0] == N - 1 && cur[1] == M - 1) {
				return cur[2];
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && maze[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny, cur[2] + 1});
				}
			}
		}

		return -1;
	}

	static int[][] getMaze() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(arr[j]);
			}
		}

		return maze;
	}

}