import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] indegree = new int[N + 1];
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			al.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			al.get(a).add(b);
			indegree[b]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				pq.offer(i);
			}
		}

		while(!pq.isEmpty()) {
			int num = pq.poll();
			System.out.print(num + " ");
			for (int next : al.get(num)) {
				indegree[next]--;
				if (indegree[next] == 0) {
					pq.offer(next);
				}
			}
		}
	}
}
