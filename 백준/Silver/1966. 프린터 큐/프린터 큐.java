
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			Queue<int[]> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				queue.add(new int[] {i, Integer.parseInt(st.nextToken())});
			}

			int cnt = 0;

			while (true) {
				int[] now = queue.poll();
				boolean flag = true;

				for (int q[] : queue) {
					if (q[1] > now[1]) {
						flag = false;
						break;
					}
				}

				if (flag) {
					cnt++;
					if (now[0] == t) {
						break;
					}
				} else {
					queue.add(now);
				}
			}

			System.out.println(cnt);
		}
	}
}