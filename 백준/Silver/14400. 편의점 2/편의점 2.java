import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		System.out.println(getTotalDistance());
	}

	static long getTotalDistance() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int[] X = new int[N];
		int[] Y = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(X);
		Arrays.sort(Y);

		int midX = X[N / 2];
		int midY = Y[N / 2];
		long totalDistance = 0;

		for (int i = 0; i < N; i++) {
			totalDistance += (Math.abs(midX - X[i]) + Math.abs(midY - Y[i]));
		}

		return totalDistance;
	}

}