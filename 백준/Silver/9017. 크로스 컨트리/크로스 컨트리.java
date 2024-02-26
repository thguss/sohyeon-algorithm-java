import java.util.*;
import java.io.*;

public class Main {

	static int T, N;
	static Map<Integer, Integer> result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int[] players = getRank(br);
			System.out.println(solve(players));
		}
	}

	static int solve(int[] rank) {
		int[] fifthScore = new int[result.size() + 1];
		Map<Integer, Integer> scoreMap = new HashMap<>();
		Map<Integer, Integer> teamMap = new HashMap<>();
		int score = 1;

		for (int element : rank) {
			if (result.get(element) < 6) continue;

			teamMap.put(element, teamMap.getOrDefault(element, 0) + 1);

			if (teamMap.get(element) <= 4) { // ㅇ ㅏ 4명까지 합산이네?
				scoreMap.put(element, scoreMap.getOrDefault(element, 0) + score);
			}

			if (teamMap.get(element) == 5) {
				fifthScore[element] = score;
			}

			score++;
		}

		List<Integer> keys = new ArrayList<>(scoreMap.keySet());
		keys.sort((a, b) -> {
			if (Objects.equals(scoreMap.get(a), scoreMap.get(b))) {
				return fifthScore[a] - fifthScore[b];
			}
			return scoreMap.get(a) - scoreMap.get(b);
		});

		return keys.get(0);
	}

	static int[] getRank(BufferedReader br) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());
		result = new HashMap<>();
		int[] rank = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int data = Integer.parseInt(st.nextToken());
			result.put(data, result.getOrDefault(data, 0) + 1);
			rank[i] = data;
		}

		return rank;
	}

}