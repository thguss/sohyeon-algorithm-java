import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		int N = getN();
		System.out.println(greedy(N));
	}

	static int greedy(int N) {
		int count = 0;

		while (N > 0) {
			if (N % 5 == 0) {
				count += (N / 5);
				return count;
			}

			N -= 3;
			count++;
		}

		return (N == 0) ? count : -1;
	}

	static int getN() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		return Integer.parseInt(br.readLine());
	}

}