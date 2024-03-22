import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		int[] numbers = getNumbers();
		System.out.println(tp(numbers));
	}

	static long tp(int[] numbers) {
		long ans = 0;
		int[] cnt = new int[N + 1];

		int left = 1;
		int right = 0;

		while (left <= N) {
			while (right + 1 <= N && cnt[numbers[right + 1]] == 0) {
				cnt[numbers[++right]]++;
			}

			ans += (right - left + 1);

			cnt[numbers[left++]]--;
		}

		return ans;
	}

	static int[] getNumbers() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		return arr;
	}

}