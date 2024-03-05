import java.util.*;
import java.io.*;

public class Main {
	static int N, M, q;

	public static void main(String[] args) throws Exception {
		int[][] arr = getArr();
		print(arr);
	}

	static void print(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (int[] line : arr) {
			for (int i = 0; i < M; i++) {
				sb.append(line[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[][] getArr() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			if (query == 0) change(arr, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			else if (query == 1) swap(arr, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		return arr;
	}

	static void change(int[][] arr, int i, int j, int target) {
		arr[i][j] = target;
	}

	static void swap(int[][] arr, int i, int j) {
		for (int c = 0; c < M; c++) {
			int temp = arr[i][c];
			arr[i][c] = arr[j][c];
			arr[j][c] = temp;
		}
	}

}