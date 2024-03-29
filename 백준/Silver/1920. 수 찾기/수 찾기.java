import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

	static String solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			sb.append(bs(arr, target) ? 1 : 0).append("\n");
		}

		return sb.toString();
	}

	static boolean bs(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == target) return true;

			if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return false;
	}

}