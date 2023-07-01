
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0) break;

			ArrayList<Integer> al = new ArrayList<>();
			al.add(a);
			al.add(b);
			al.add(c);

			Collections.sort(al);

			if (Math.pow(al.get(al.size() - 1), 2) == Math.pow(al.get(0), 2) + Math.pow(al.get(1), 2))
				System.out.println("right");
			else
				System.out.println("wrong");
		}


	}
}