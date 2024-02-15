import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int N;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		String G = st.nextToken();

		Map<String, Integer> games = getInitializedGames();
		Set<String> players = getPlayers();
		int playerCountForGame = games.get(G) - 1; // 임스 제외
		int playerCount = players.size();

		System.out.println(playerCount / playerCountForGame);
	}

	private static Set<String> getPlayers() throws IOException {
		Set<String> players = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String playerName = br.readLine();
			players.add(playerName);
		}
		return players;
	}

	private static Map<String, Integer> getInitializedGames() {
		Map<String, Integer> games = new HashMap<>();
		games.put("Y", 2); // 윷놀이
		games.put("F", 3); // 같은 그림 찾기
		games.put("O", 4); // 원카드
		return games;
	}
}