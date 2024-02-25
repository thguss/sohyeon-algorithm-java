import java.util.*;
import java.io.*;

public class Main {
	static class Position {
		int x;
		int y;
		int dist;
		int k;

		Position(int x, int y, int dist, int k) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.k = k;
		}
	}

	static int N, M, K;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		int[][] map = getMap();
		System.out.println(bfs(map));
	}

	static int bfs(int[][] map) {
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(0, 0, 1, 0));

		int[][] visited = new int[N][M]; // 부순 벽의 개수 저장 (메모리 초과 보완)
		for (int i = 0; i < N; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);
		visited[0][0] = 0;

		while (!queue.isEmpty()) {
			Position cur = queue.poll();

			if (cur.x == N - 1 && cur.y == M - 1) {
				return cur.dist;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && visited[nx][ny] > cur.k) {
					if (map[nx][ny] == 1) {
						if (cur.k < K && visited[nx][ny] > cur.k + 1) {
							visited[nx][ny] = cur.k + 1;
							queue.add(new Position(nx, ny, cur.dist + 1, cur.k + 1));
						}
					} else {
						visited[nx][ny] = cur.k;
						queue.add(new Position(nx, ny, cur.dist + 1, cur.k));
					}
				}
			}
		}

		return -1;
	}

	static int[][] getMap() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}

		return map;
	}

}