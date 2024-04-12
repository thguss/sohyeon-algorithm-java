import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		int[] arr = getArr();

		int max = 0;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, count(arr, i));
		}

		System.out.println(max);
	}

	static int count(int[] arr, int h) {
		int cnt = 0;
		double tmp = 0;

		// left : 기울기 증가
		for (int i = h - 1; i >= 0; i--) {
			double slope = (double) (arr[h] - arr[i]) / (h - i);

			if (i == h - 1 || slope < tmp) {
				cnt++;
				tmp = slope;
			}
		}

		// right : 기울기 감소
		for (int i = h + 1; i < N; i++) {
			double slope = (double) (arr[h] - arr[i]) / (h - i);

			if (i == h + 1 || slope > tmp) {
				cnt++;
				tmp = slope;
			}
		}

		return cnt;
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