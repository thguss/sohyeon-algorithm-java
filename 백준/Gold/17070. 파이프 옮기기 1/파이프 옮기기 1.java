import java.io.*;
import java.util.*;

public class Main {
	static int N, cnt;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		int[] pos1 = new int[] {0, 0};
		int[] pos2 = new int[] {0, 1};

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cnt = 0;
		dfs(pos1, pos2);
		System.out.println(cnt);


	}

	private static void dfs(int[] pos1, int[] pos2) {
		if (pos2[0] == N -1 && pos2[1] == N - 1) {
			cnt++;
			return;
		}

		String state = getStatus(pos1, pos2);
		int x = pos2[0];
		int y = pos2[1];
		if (state.equals("W")) {
			if (y + 1 < N && arr[x][y + 1] == 0) {
				int[] next1 = new int[] {x, y};
				int[] next2 = new int[] {x, y + 1};
				dfs(next1, next2);
			}
			if (y + 1 < N && x + 1 < N && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) {
				int[] next1 = new int[] {x, y};
				int[] next2 = new int[] {x + 1, y + 1};
				dfs(next1, next2);
			}
		} else if (state.equals("H")) {
			if (x + 1 < N && arr[x + 1][y] == 0) {
				int[] next1 = new int[] {x, y};
				int[] next2 = new int[] {x + 1, y};
				dfs(next1, next2);
			}
			if (y + 1 < N && x + 1 < N && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) {
				int[] next1 = new int[] {x, y};
				int[] next2 = new int[] {x + 1, y + 1};
				dfs(next1, next2);
			}
		} else if (state.equals("D")) {
			if (y + 1 < N && x + 1 < N && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) {
				int[] next1 = new int[] {x, y};
				int[] next2 = new int[] {x + 1, y + 1};
				dfs(next1, next2);
			}
			if (y + 1 < N && arr[x][y + 1] == 0) {
				int[] next1 = new int[] {x, y};
				int[] next2 = new int[] {x, y + 1};
				dfs(next1, next2);
			}
			if (x + 1 < N && arr[x + 1][y] == 0) {
				int[] next1 = new int[] {x, y};
				int[] next2 = new int[] {x + 1, y};
				dfs(next1, next2);
			}
		}
	}

	private static String getStatus(int[] pos1, int[] pos2) {
		int x1 = pos1[0];
		int y1 = pos1[1];
		int x2 = pos2[0];
		int y2 = pos2[1];

		if (x1 == x2 && Math.abs(y1 - y2) == 1) {
			return "W"; // 가로
		} else if (Math.abs(x1 - x2) == 1 && y1 == y2) {
			return "H"; // 세로
		} else {
			return "D"; // 대각선
		}
	}

}