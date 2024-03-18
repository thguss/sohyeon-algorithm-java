import java.util.*;
import java.io.*;

public class Main {
	static int[] operations = new int[4];
	static long min = Long.MAX_VALUE;
	static long max = Long.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		int[] numbers = getNumbers();
		getResult(numbers, 1, numbers[0]);
		System.out.println(max);
		System.out.println(min);
	}

	static void getResult(int[] numbers, int index, long total) {
		if (index == numbers.length) {
			min = Math.min(min, total);
			max = Math.max(max, total);
			return;
		}

		if (operations[0] > 0) {
			operations[0]--;
			getResult(numbers, index + 1, total + numbers[index]);
			operations[0]++;
		}
		if (operations[1] > 0) {
			operations[1]--;
			getResult(numbers, index + 1, total - numbers[index]);
			operations[1]++;
		}
		if (operations[2] > 0) {
			operations[2]--;
			getResult(numbers, index + 1, total * numbers[index]);
			operations[2]++;
		}
		if (operations[3] > 0) {
			operations[3]--;
			getResult(numbers, index + 1, total / numbers[index]);
			operations[3]++;
		}
	}

	static int[] getNumbers() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		operations[0] = Integer.parseInt(st.nextToken());
		operations[1] = Integer.parseInt(st.nextToken());
		operations[2] = Integer.parseInt(st.nextToken());
		operations[3] = Integer.parseInt(st.nextToken());

		return arr;
	}
}