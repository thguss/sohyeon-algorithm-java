import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.io.*;

import org.w3c.dom.Node;

public class Main {
	static int N, R, Q;
	static List<Integer>[] list, tree;
	static int[] parent, size;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		size = new int[N + 1];
		list = new ArrayList[N + 1];
		tree = new ArrayList[N + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}

		makeTree(R, -1);
		countSubtreeNodes(R);
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < Q; i++) {
			int query = Integer.parseInt(br.readLine());
			sb.append(size[query]).append("\n");
		}

		System.out.println(sb);
	}

	public static void makeTree(int cur, int p) {
		for (int next : list[cur]) {
			if(next != p) {
				tree[cur].add(next);
				parent[next] = cur;
				makeTree(next, cur);
			}
		}
	}

	public static void countSubtreeNodes(int cur) { // dfs
		size[cur] = 1; // 자기 자신 포함
		for(int next : tree[cur]) {
			countSubtreeNodes(next);
			size[cur] += size[next];
		}
	}
}