import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static List<int[]> al = new ArrayList<>();
	static List<int[]> homes = new ArrayList<>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		int[][] board = getBoards();
		comb(new int[M][2], 0, 0, board);
		System.out.println(min);
	}

	static void comb(int[][] arr, int start, int index, int[][] board) {
		if (index == M) {
			min = Math.min(min, getDistance(arr));
			return;
		}

		for (int i = start; i < al.size(); i++) {
			arr[index][0] = al.get(i)[0];
			arr[index][1] = al.get(i)[1];
			comb(arr, i + 1, index + 1, board);
		}
	}

	static int getDistance(int[][] arr) {
		int sum = 0;

		for (int[] home : homes) {
			int minDistance = Integer.MAX_VALUE;
			for (int[] open : arr) {
				minDistance = Math.min(minDistance, Math.abs(home[0] - open[0]) + Math.abs(home[1] - open[1]));
			}
			sum += minDistance;
		}

		return sum;
	}

	static int[][] getBoards() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					al.add(new int[] {i, j});
				} else if (arr[i][j] == 1) {
					homes.add(new int[] {i, j});
				}
			}
		}

		return arr;
	}

}