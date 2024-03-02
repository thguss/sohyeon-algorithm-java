import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		input();
		permutation(1, 0, new int[M]);
		System.out.println(sb);
	}

	static void permutation(int start, int depth, int[] arr) {
		if (depth == M) {
			sb.append(print(arr)).append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			permutation(i, depth + 1, arr);
		}
	}

	static String print(int[] arr) {
		StringBuilder res = new StringBuilder();
		for (int num : arr) {
			res.append(num).append(" ");
		}
		return res.toString();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}

}