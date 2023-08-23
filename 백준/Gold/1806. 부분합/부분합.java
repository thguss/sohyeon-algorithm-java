import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long S = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 0;
		int l = 0, r = 0;
		int min = Integer.MAX_VALUE;
		long sum = 0;

		while (left <= N && right <= N) {
			if (sum >= S && min > right - left) {
				min = right - left;
				l = left;
				r = right;
			}

			if (sum < S) {
				sum += arr[right++];
			} else {
				sum -= arr[left++];
			}
		}

		if (min != Integer.MAX_VALUE) {
			System.out.println(r - l);
		} else {
			System.out.println(0);
		}
	}

	private static long getSum(int[] arr, int start, int end) {
		long sum = 0;
		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		return sum;
	}
}