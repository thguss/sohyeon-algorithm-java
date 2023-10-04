import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken()); // 가지고 있는 개수
		long N = Long.parseLong(st.nextToken()); // 필요한 개수
		long[] arr = new long[K];
		long max = Integer.MIN_VALUE;

		for (int i = 0; i < K; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}

		long left = 1;
		long right = max;
		long lenMax = 0;

		while (left <= right) {
			long mid = (left + right) / 2;

			if (cutting(arr, mid, N)) {
				lenMax = Math.max(lenMax, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(lenMax);

	}

	private static boolean cutting(long[] arr, long len, long N) {
		long cnt = 0;

		for (long n : arr) {
			cnt += n / len;
		}

		return cnt >= N;
	}
}
