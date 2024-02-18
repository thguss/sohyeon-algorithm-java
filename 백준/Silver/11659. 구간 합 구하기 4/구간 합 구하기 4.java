import java.util.*;
import java.io.*;

public class Main {

	static int N, M;

	public static void main(String[] args) throws IOException {
		solve();
	}

	static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int[] sum = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = (i == 0) ? arr[i] : (sum[i - 1] + arr[i]);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			System.out.println(sum[end] - ((start == 0) ? 0 : sum[start - 1]));
		}
	}

}