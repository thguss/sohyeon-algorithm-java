import java.util.*;
import java.io.*;

public class Main {

	static int cnt = 0;
	static int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		System.out.println(isYes() ? "Yes" : "No");
	}

	static boolean isYes() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			sum += (price * count);
		}

		return X == sum;

	}
}