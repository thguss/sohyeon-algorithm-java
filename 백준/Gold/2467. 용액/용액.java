import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		int left = 0, right = N - 1;
		int l = 0, r = 0;
		long min = Long.MAX_VALUE;
		while (left < right) {
			long sum = arr[left] + arr[right];
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				l = left;
				r = right;
			}
			if (sum >= 0) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(arr[l] + " " + arr[r]);
	}
}