import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long min;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		arr = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}

		solve(0, 0);

	}

	private static void solve(int r, int c) {
		if (c == 9) {
			solve(r + 1, 0);
			return;
		}

		if (r == 9) {
			for (int[] temp : arr) {
				for (int num : temp) {
					System.out.print(num);
				}
				System.out.println();
			}
			System.exit(0);
		}

		if (arr[r][c] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (!isDuplicated(r, c, i)) {
					arr[r][c] = i;
					solve(r, c + 1);
				}
			}
			arr[r][c] = 0;
		} else {
			solve(r, c + 1);
		}

	}

	private static boolean isDuplicated(int r, int c, int value) {
		for (int i = 0; i < 9; i++) {
			if (arr[r][i] == value || arr[i][c] == value) {
				return true;
			}
		}

		int n = (r / 3) * 3;
		int m = (c / 3) * 3;

		for (int i = n; i < n + 3; i++) {
			for (int j = m; j < m + 3; j++) {
				if (arr[i][j] == value) {
					return true;
				}
			}
		}

		return false;
	}
}