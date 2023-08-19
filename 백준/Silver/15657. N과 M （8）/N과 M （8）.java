import java.io.*;
import java.util.*;

public class Main {

	static int[] arr, res;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		res = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		comb(0, 0);

	}

	private static void comb(int start, int cnt) {
		if (cnt == M) {
			for (int n : res) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			res[cnt] = arr[i];
			comb(i, cnt + 1);
		}
	}

}