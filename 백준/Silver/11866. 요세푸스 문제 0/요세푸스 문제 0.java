
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		while (!queue.isEmpty()) {
			for (int i = 0; i < k - 1; i++) {
				int num = queue.poll();
				queue.offer(num);
			}
			sb.append(queue.poll()).append(", ");
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append(">");
		System.out.println(sb);

	}
}