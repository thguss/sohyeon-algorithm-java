import java.lang.reflect.Member;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.io.*;

import org.w3c.dom.Node;

public class Main {

	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());
		List<Integer> al = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			al.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(al);

		for (int num : al) {
			sb.append(num).append("\n");
		}
		System.out.println(sb);
	}
}