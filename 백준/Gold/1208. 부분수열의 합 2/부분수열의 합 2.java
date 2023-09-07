import java.util.*;
import java.io.*;

public class Main {

	static int N, S;
	static long[] arr;
	static ArrayList<Long> left = new ArrayList<>(), right = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new long[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		getSubsequence(0, N / 2, 0, left);
		getSubsequence(N / 2, N, 0, right);

		Collections.sort(left);
		Collections.sort(right);

		long cnt = getCnt();

		System.out.println(S != 0 ? cnt : cnt - 1);
	}

	private static void getSubsequence(int idx, int end, long sum, List<Long> list) {
		if (idx == end) {
			list.add(sum);
			return;
		}

		getSubsequence(idx + 1, end, sum + arr[idx], list);
		getSubsequence(idx + 1, end, sum, list);
	}

	private static long getCnt() {
		int l = 0, r = right.size() - 1;
		long cnt = 0;

		while (l < left.size() && r >= 0) {
			long sum = left.get(l) + right.get(r);

			if (sum == S) {
				long a = left.get(l);
				long cnt1 = 0;
				while (l < left.size() && left.get(l) == a) {
					l++;
					cnt1++;
				}

				long b = right.get(r);
				long cnt2 = 0;
				while (r >= 0 && right.get(r) == b) {
					r--;
					cnt2++;
				}

				cnt += (cnt1 * cnt2);
			} else if (sum < S) {
				l++;
			} else {
				r--;
			}
		}

		return cnt;
	}
}
