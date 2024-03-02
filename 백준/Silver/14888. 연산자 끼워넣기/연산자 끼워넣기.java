import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static Map<Character, Integer> map = new HashMap<>();
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		int[] arr = getArr();
		calculate(arr, 0, arr[0], map.get('+'), map.get('-'), map.get('*'), map.get('/'));
		System.out.println(max);
		System.out.println(min);
	}

	static void calculate(int[] arr, int depth, int res, int plus, int minus, int multiple, int divide) {
		if (depth == N - 1) {
			min = Math.min(min, res);
			max = Math.max(max, res);
			return;
		}

		if (plus > 0) {
			calculate(arr, depth + 1, res + arr[depth + 1], plus - 1, minus, multiple, divide);
		}

		if (minus > 0) {
			calculate(arr, depth + 1, res - arr[depth + 1], plus, minus - 1, multiple, divide);
		}

		if (multiple > 0) {
			calculate(arr, depth + 1, res * arr[depth + 1], plus, minus, multiple - 1, divide);
		}

		if (divide > 0) {
			calculate(arr, depth + 1, res / arr[depth + 1], plus, minus, multiple, divide - 1);
		}
	}

	static int[] getArr() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine()); // 수의 개수

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		map.put('+', Integer.parseInt(st.nextToken()));
		map.put('-', Integer.parseInt(st.nextToken()));
		map.put('*', Integer.parseInt(st.nextToken()));
		map.put('/', Integer.parseInt(st.nextToken()));

		return arr;
	}

}