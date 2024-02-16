import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int N, M;
	static Queue<int[]> tomatoes = new LinkedList<>();
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int[][] box = getTomatoBox();
		bfs(box);

		System.out.println(getDay(box));

	}

	private static int getDay(int[][] box) {
		int max = -1;

		for (int[] days : box) {
			for (int day : days) {
				if (day == 0) { // 안 익은 토마토 존재
					return -1;
				}
				max = Math.max(max, day);
			}
		}

		return max - 1; // 원래 익어있던 토마토에서 하루 빼고
	}

	private static void bfs(int[][] box) {
		while (!tomatoes.isEmpty()) {
			int[] pos = tomatoes.poll();
			int x = pos[0];
			int y = pos[1];

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;

				if (0 <= nx && nx < N && 0 <= ny && ny < M && box[nx][ny] == 0) {
					box[nx][ny] = box[x][y] + 1;
					tomatoes.add(new int[] {nx, ny});
				}
			}
		}
	}

	private static int[][] getTomatoBox() throws IOException {
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int[][] box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				box[i][j] = tomato;
				if (box[i][j] == 1) {
					tomatoes.add(new int[] {i, j});
				}
			}
		}

		return box;
	}

}