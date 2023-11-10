import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		String str = br.readLine();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			System.out.println(count(str, c, l, r));
		}
	}

	private static int count(String str, char c, int l, int r) {
		int cnt = 0;
		for (int i = l; i <= r; i++) {
			if (str.charAt(i) == c) {
				cnt++;
			}
		}
		return cnt;
	}
}
