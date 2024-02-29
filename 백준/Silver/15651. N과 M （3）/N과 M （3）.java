import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws Exception {
		input();
		permutation(0, new int[M]);
		System.out.println(result);
	}

	static void permutation(int depth, int[] arr) {
		if (depth == M) {
			result.append(print(arr)).append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			arr[depth] = i;
			permutation(depth + 1, arr);
		}
	}

	static String print(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int num : arr) {
			sb.append(num).append(" ");
		}
		return sb.toString();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}

}