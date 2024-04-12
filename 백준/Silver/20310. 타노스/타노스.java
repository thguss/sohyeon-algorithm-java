import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		String str = getS();
		System.out.println(greedy(str.toCharArray()));
	}

	static String greedy(char[] arr) {
		int zeroCount = 0;
		int oneCount = 0;
		for (char ch : arr) {
			if (ch == '0') zeroCount++;
			else if (ch == '1') oneCount++;
		}
		zeroCount /= 2;
		oneCount /= 2;

		StringBuilder sb = new StringBuilder();
		for (char ch : arr) {
			// System.out.println(sb);
			if (ch == '0' && zeroCount > 0) {
				// System.out.println("zero: " + zeroCount);
				sb.append(ch);
				zeroCount--;
			} else if (ch == '1') {
				if (oneCount > 0) oneCount--;
				else sb.append(ch);
			}
		}

		return sb.toString();
	}

	static String getS() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		return br.readLine();
	}

}