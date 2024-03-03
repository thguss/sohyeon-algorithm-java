import java.util.*;
import java.io.*;

public class Main {
	static long A, B, C;

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(A + B + C);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
	}

}