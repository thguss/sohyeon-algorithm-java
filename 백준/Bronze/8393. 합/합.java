import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		int N = getN();
		int sum = 0;

		for (int i = 1; i <= N; i++) sum += i;

		System.out.println(sum);
	}

	static int getN() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		return Integer.parseInt(br.readLine());
	}
}