import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static Queue<int[]> houses = new LinkedList<>();
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		int[][] village = getVillage();
		List<Integer> houseCounts = getHouseCounts(village);

		Collections.sort(houseCounts);

		System.out.println(houseCounts.size());

		for (int count : houseCounts) {
			System.out.println(count);
		}
	}

	static List<Integer> getHouseCounts(int[][] village) {
		boolean[][] visited = new boolean[N][N];
		List<Integer> houseCounts = new ArrayList<>();

		while (!houses.isEmpty()) {
			int[] house = houses.poll();
			int x = house[0];
			int y = house[1];

			if (!visited[x][y]) {
				houseCounts.add(bfs(village, x, y, visited));
			}
		}

		return houseCounts;
	}

	static int bfs(int[][] village, int x, int y, boolean[][] visited) {
		int count = 0;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			count++;
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < N && village[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}

		return count;
	}

	static int[][] getVillage() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());
		int[][] village = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("");

			for (int j = 0; j < N; j++) {
				village[i][j] = Integer.parseInt(arr[j]);

				if (village[i][j] == 1) {
					houses.add(new int[] {i, j});
				}
			}
		}

		return village;
	}

}