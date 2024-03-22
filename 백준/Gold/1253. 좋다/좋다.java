import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		int[] numbers = getNumbers();
		System.out.println(getGoodCnt(numbers));
	}

	static int getGoodCnt(int[] numbers) {
		Arrays.sort(numbers);
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			if (bs(numbers, i)) {
				cnt++;
			}
		}

		return cnt;
	}

	static boolean bs(int[] numbers, int i) {
		int left = 0;
		int right = N - 1;

		while (true) {
			if (left == i) left++;
			else if (right == i) right--;

			if (left >= right) break;

			if (numbers[left] + numbers[right] > numbers[i]) right--;
			else if (numbers[left] + numbers[right] < numbers[i]) left++;
			else return true;
		}

		return false;
	}

	static int[] getNumbers() throws IOException {
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