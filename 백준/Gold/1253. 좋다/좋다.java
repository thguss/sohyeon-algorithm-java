import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		int[] arr = getArr();
		System.out.println(getCount(arr));
	}

	static int getCount(int[] arr) {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			if (bs(arr, i)) cnt++;
		}

		return cnt;
	}

	static boolean bs(int[] arr, int i) {
		int left = 0;
		int right = N - 1;

		while (true) {
			if (left == i) left++;
			if (right == i) right--;

			if (left >= right) break;

			int sum = arr[left] + arr[right];

			if (sum > arr[i]) right--;
			else if (sum < arr[i]) left++;
			else return true;
		}

		return false;
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

		Arrays.sort(arr);

		return arr;
	}

}