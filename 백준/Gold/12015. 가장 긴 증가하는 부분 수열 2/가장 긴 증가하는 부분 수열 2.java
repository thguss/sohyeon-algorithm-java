import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] LIS = new int[N];
		LIS[0] = arr[0];
		int len = 1;

		for (int i = 1; i < N; i++) {
			int key = arr[i];

			if (LIS[len - 1] < key) { // 추가
				LIS[++len - 1] = key;
			} else { // 대치
				int l = 0, r = len;
				while (l < r) {
					int mid = (l + r) / 2;
					if (LIS[mid] < key) {
						l = mid + 1;
					} else {
						r = mid;
					}
				}
				LIS[l] = key;
			}
		}

		System.out.println(len);
	}
}
