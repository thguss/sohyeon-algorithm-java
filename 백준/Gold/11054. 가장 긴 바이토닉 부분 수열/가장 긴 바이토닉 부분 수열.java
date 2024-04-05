import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		int[] arr = getArr();

		int[] idp = new int[N];
		for (int i = 0; i < N; i++) {
			idp[i] = LIS(i, arr, idp);
		}

		int[] ddp = new int[N];
		for (int i = 0; i < N; i++) {
			ddp[i] = LDS(i, arr, ddp);
		}

		int max = -1;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, idp[i] + ddp[i] - 1);
		}

		System.out.println(max);
	}

	static int LDS(int point, int[] arr, int[] ddp) { // 오른쪽 부분
		if (ddp[point] == 0) {
			ddp[point] = 1;

			for (int i = point + 1; i < N; i++) {
				if (arr[i] < arr[point]) {
					ddp[point] = Math.max(ddp[point], LDS(i, arr, ddp) + 1);
				}
			}
		}

		return ddp[point];
	}

	static int LIS(int point, int[] arr, int[] idp) { // 왼쪽 부분
		if (idp[point] == 0) {
			idp[point] = 1;

			for (int i = point - 1; i >= 0; i--) {
				if (arr[i] < arr[point]) {
					idp[point] = Math.max(idp[point], LIS(i, arr, idp) + 1);
				}
			}
		}

		return idp[point];
	}

	static int[] getArr() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		return arr;
	}

}