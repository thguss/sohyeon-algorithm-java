
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr, IDP, DDP;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		IDP = new int[N];
		for (int i = 0; i < N; i++) {
			IDP[i] = LIS(i);
		}

		DDP = new int[N];
		for (int i = 0; i < N; i++) {
			DDP[i] = LDS(i);
		}

		int max = -1;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, IDP[i] + DDP[i] - 1);
		}
		System.out.println(max);

		// System.out.println(Arrays.toString(IDP));
		// System.out.println(Arrays.toString(DDP));
	}

	private static int LIS(int num) {
		if (IDP[num] == 0) {
			IDP[num] = 1;
			for (int i = num - 1; i >= 0; i--) {
				if (arr[i] < arr[num]) {
					IDP[num] = Math.max(IDP[num], LIS(i) + 1);
				}
			}
		}
		return IDP[num];
	}

	private static int LDS(int num) {
		if (DDP[num] == 0) {
			DDP[num] = 1;
			for (int i = num + 1; i < N; i++) {
				if (arr[i] < arr[num]) {
					DDP[num] = Math.max(DDP[num], LDS(i) + 1);
				}
			}
		}
		return DDP[num];
	}

}