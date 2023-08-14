
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[][] board = new String[n][m];
		int[] dx = new int[] {1, -1, 0, 0};
		int[] dy = new int[] {0, 0, 1, -1};

		int sx = 0;
		int sy = 0;

		for (int i = 0; i < n; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				board[i][j] = arr[j];
				if (board[i][j].equals("I")) {
					sx = i;
					sy = j;
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {sx, sy});

		boolean[][] visited = new boolean[n][m];
		visited[sx][sy] = true;

		int res = 0;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (visited[nx][ny] || board[nx][ny].equals("X")) continue;
					visited[nx][ny] = true;
					if (board[nx][ny].equals("P")) res++;
					queue.offer(new int[] {nx, ny});
				}
			}
		}

		if (res != 0)
			System.out.println(res);
		else
			System.out.println("TT");
	}

}