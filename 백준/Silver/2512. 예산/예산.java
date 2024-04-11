import java.util.*;
import java.io.*;

public class Main {

	static int N, M, SUM;

	public static void main(String[] args) throws Exception {
		int[] arr = getArr();
		System.out.println(solve(arr));
	}

	static int solve(int[] arr) {
		Arrays.sort(arr);

		if (M >= SUM) return arr[N - 1];

		int left = 0;
		int right = arr[N - 1];

		while (left <= right) {
			int mid = (left + right) / 2;

			int sum = 0; // 상한액으로 얻을 수 있는 합계
			for (int i = 0; i < N; i++) {
				sum += Math.min(arr[i], mid);
			}

			if (sum <= M) left = mid + 1;
			else right = mid - 1;
		}

		return right;
	}

	static int[] getArr() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		SUM = 0;
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			int cost = Integer.parseInt(st.nextToken());
			SUM += cost;
			arr[i] = cost;
		}

		M = Integer.parseInt(br.readLine());

		return arr;
	}

}