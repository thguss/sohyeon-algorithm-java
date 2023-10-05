import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		long left = 1;
		long right = K;

		while (left <= right) {
			long mid = (left + right) / 2;

			if (solve(N, K, mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(left);
	}

	private static boolean solve(int N, int K, long mid) {
		long count = 0;

		for (int i = 1; i <= N; i++) {
			count += Math.min(mid / i, N);
		}

		return K <= count;
	}
}
