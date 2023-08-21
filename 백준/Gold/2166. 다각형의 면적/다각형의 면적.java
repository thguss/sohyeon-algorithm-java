import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] x = new long[N + 1];
		long[] y = new long[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		x[N] = x[0];
		y[N] = y[0];

		long A = 0, B = 0;

		for (int i = 0; i < N; i++) {
			A += x[i] * y[i + 1];
			B += x[i + 1] * y[i];
		}

		String res = String.format("%.1f", (Math.abs(A - B) / 2.0));
		System.out.println(res);
	}

}