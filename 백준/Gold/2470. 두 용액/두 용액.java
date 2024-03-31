import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		long[] arr = getArr();
		solve(arr);
	}

	static void solve(long[] arr) {
		// System.out.println(Arrays.toString(arr));
		int left = 0;
		int right = N - 1;
		long min = Long.MAX_VALUE;
		long liquid1 = arr[left];
		long liquid2 = arr[right];

		while (left < right) {
			long diff = arr[right] + arr[left];

			if (diff == 0) {
				System.out.println(arr[left] + " " + arr[right]);
				return;
			}

			if (min > Math.abs(diff)) {
				// System.out.println(left + " " + right + " " + diff);
				min = Math.abs(diff);
				liquid1 = arr[left];
				liquid2 = arr[right];
			}

			if (diff < 0) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println(liquid1 + " " + liquid2);
	}

	static long[] getArr() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());

		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		return arr;
	}

}