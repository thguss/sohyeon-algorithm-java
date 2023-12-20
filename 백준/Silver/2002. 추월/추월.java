import java.util.*;
import java.io.*;

import org.w3c.dom.Node;

public class Main {	static String title;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());
		Queue<String> in = new LinkedList<>();
		Queue<String> out = new LinkedList<>();

		// 들어간 차
		for (int i = 0; i < N; i++) {
			in.add(br.readLine());
		}

		// 나온 차
		for (int i = 0; i < N; i++) {
			out.add(br.readLine());
		}

		int answer = 0;
		while (!out.isEmpty()) {
			String car = out.poll();
			if (!in.peek().equals(car)) { // 추월
				answer++;
				in.remove(car);
			} else {
				in.poll();
			}
		}

		System.out.println(answer);
	}
}
