import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int max = Integer.MIN_VALUE;
		int[] card = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			card[i] = num;
			max = Math.max(max, num);
		}

		int[] pos = new int[max + 1];
		for (int i = 0; i < N; i++) {
			pos[card[i]] = i + 1;
		}

		int[] score = new int[N];

		for (int i = 0; i < N; i++) {
			int num = card[i];
			int tmp = 2;
			while (num * tmp <= max) {
				if (pos[num * tmp] != 0) {
					score[i]++;
					score[pos[num * tmp] - 1]--;
				}
				tmp++;
			}
		}

		for (int s : score) {
			System.out.print(s + " ");
		}
	}

}