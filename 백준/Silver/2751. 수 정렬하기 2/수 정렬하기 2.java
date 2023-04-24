

import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			al.add(sc.nextInt());
		}

		Collections.sort(al);

		for (int num : al) {
			sb.append(num).append("\n");
		}

		System.out.println(sb);
	}
}
