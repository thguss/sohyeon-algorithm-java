import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		int N = getN();
		int longCnt = N / 4;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= longCnt; i++) {
			sb.append("long ");
		}
		sb.append("int");
		System.out.println(sb);
	}

	static int getN() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		return Integer.parseInt(br.readLine());
	}
}