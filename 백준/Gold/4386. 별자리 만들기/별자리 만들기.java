import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
	int p1;
	int p2;
	float r;

	Edge(int p1, int p2, float r) {
		this.p1 = p1;
		this.p2 = p2;
		this.r = r;
	}

	@Override
	public int compareTo(Edge o) {
		return this.r >= o.r ? 1 : -1;
	}
}

public class Main { // MST

	static int n;
	static ArrayList<float[]> al;
	static Map<float[], Integer> map;
	static Queue<Edge> queue;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		al = new ArrayList<>();
		map = new HashMap<>();
		queue = new PriorityQueue<>();

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			float x = Float.parseFloat(st.nextToken());
			float y = Float.parseFloat(st.nextToken());
			float[] arr = {x, y};
			al.add(arr);
			map.put(arr, map.size());
		}

		comb(0, 0, new ArrayList<>());

		float weight = 0;

		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			int p1 = find(cur.p1);
			int p2 = find(cur.p2);
			if (p1 != p2) {
				union(p1, p2);
				weight += cur.r;
			}
		}

		System.out.printf("%.2f%n", weight);
	}

	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa < pb) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}
	}

	private static void comb(int start, int cnt, ArrayList<float[]> res) {
		if (cnt == 2) { // 경로 경우의 수
			float[] arr1 = res.get(0);
			float[] arr2 = res.get(1);
			queue.offer(new Edge(map.get(arr1), map.get(arr2), calDistance(arr1[0], arr1[1], arr2[0], arr2[1])));
			return;
		}
		for (int i = start; i < al.size(); i++) {
			res.add(al.get(i));
			comb(i + 1, cnt + 1, res);
			res.remove(res.size() - 1);
		}
	}

	private static float calDistance(float x1, float y1, float x2, float y2) {
		double res = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		return (float) res;
	}
}
