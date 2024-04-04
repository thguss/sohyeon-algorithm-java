import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		solve();
	}

	static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());
		int time = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 등장 시간
			int b = Integer.parseInt(st.nextToken()); // 활동 시간
			if (time == 0) {
				time += (b + 1);
			} else {
				if (time % (a + b) >= b) { // 활동 안하는 시간
					time++;
				} else {
					time = (time / (a + b)) * (a + b) + b + 1;
				}
			}
		}

		System.out.println(time);
	}

}