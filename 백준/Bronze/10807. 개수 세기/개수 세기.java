import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		input();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int v = Integer.parseInt(br.readLine());
		int count = 0;

		for (int num : arr) {
			if (num == v) count++;
		}

		System.out.println(count);
	}

}