import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[][] map = new int[R + 1][C + 1];

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + value;
			}
		}

		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int sum = map[r2][c2] - map[r1 - 1][c2] - map[r2][c1 - 1] + map[r1 - 1][c1 - 1];
			int size = (r2 - r1 + 1) * (c2 - c1 + 1);
			// System.out.println(sum + " " + size);
			System.out.println(sum / size);
		}

	}
}
