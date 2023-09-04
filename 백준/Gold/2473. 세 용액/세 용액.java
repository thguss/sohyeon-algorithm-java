import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static long[] arr;
	static long[] pick = new long[3];
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		arr = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 2; i++) {
			solve(i);
		}

		Arrays.sort(pick);
		System.out.println(pick[0] + " " + pick[1] + " " + pick[2]);
	}

	private static void solve(int fix) {
		int left = fix + 1;
		int right = arr.length - 1;

		while (left < right) {
			long sum = arr[left] + arr[right] + arr[fix];

			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				pick[0] = arr[left];
				pick[1] = arr[right];
				pick[2] = arr[fix];
			}

			if (sum == 0) {
				return;
			} else if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}
	}
}
