
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> S = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				if (!S.contains(num)) {
					S.add(num);
				}
			} else if (command.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				if (S.contains(num)) {
					S.remove(Integer.valueOf(num));
				}
			} else if (command.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if (S.contains(num)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (command.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if (S.contains(num)) {
					S.remove(Integer.valueOf(num));
				} else {
					S.add(num);
				}
			} else if (command.equals("all")) {
				S.clear();
				for (int x = 1; x <= 20; x++) {
					S.add(x);
				}
			} else if (command.equals("empty")) {
				S.clear();
			}
		}

		System.out.println(sb);

	}

}