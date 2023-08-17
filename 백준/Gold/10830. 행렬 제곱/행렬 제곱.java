
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}

		int[][] res = pow(board, M);

		StringBuilder sb = new StringBuilder();
		for (int[] arr : res) {
			for (int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	private static int[][] pow(int[][] arr, long exp) {
		if (exp == 1L) {
			return arr;
		}

		int[][] res = pow(arr, exp / 2);
		res = arrMul(res, res);

		if (exp % 2 == 1L) {
			res = arrMul(res, board);
		}

		return res;
	}

	private static int[][] arrMul(int[][] arr1, int[][] arr2) {
		int[][] res = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sum = 0;
				// System.out.println("===" + i + ", " + j + "===");
				for (int k = 0; k < N; k++) {
					// System.out.println("[" + i + "," + k + "] * [" + k + "," + j + "] = " + (arr1[j][k] * arr2[k][j]));
					sum += arr1[i][k] * arr2[k][j];
				}
				res[i][j] = sum % 1000;
			}
		}

		return res;
	}

}