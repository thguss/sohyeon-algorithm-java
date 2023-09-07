import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
	static char[][] map;
	static boolean[][] visited;
	static int keyBit, cnt;
	static int h, w;
	static Map<Integer, Queue<int[]>> doorList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			List<int[]> entrance = new ArrayList<>();
			map = new char[h][w];
			keyBit = 0;
			cnt = 0;
			doorList = new HashMap<>();

			for (int i = 0; i < h; i++) {
				String input = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] != '*') { // 벽X
						if (i == 0 || i == h - 1 || j == 0 || j == w - 1) { // 가장자리
							if (map[i][j] == '$') {
								cnt++;
								map[i][j] = '.';
							} else if ('a' <= map[i][j] && map[i][j] <= 'z') { // 가장자리에 있는 열쇠
								keyBit |= 1 << (map[i][j] - 'a');
							}
							entrance.add(new int[] {i, j});
						}
					}
				}
			}

			char[] keyList = br.readLine().toCharArray();
			for (char key : keyList) {
				if (key == '0') {
					break;
				}
				keyBit |= 1 << (key - 'a');
			}

			visited = new boolean[h][w];

			for (int[] pos : entrance) {
				int i = pos[0], j = pos[1];
				if ('A' <= map[i][j] && map[i][j] <= 'Z') {
					int key = 1 << (map[i][j] - 'A');
					if ((keyBit & key) != key) { // 열쇠 X
						putDoorQueue(i, j, key); // 대기
						continue;
					}
				}
				bfs(i, j);
			}


			System.out.println(cnt);


		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (0 <= nx && nx < h && 0 <= ny && ny < w) {
					if (visited[nx][ny] || map[nx][ny] == '*') {
						continue;
					}
					if (map[nx][ny] == '$') {
						cnt++;
					} else if ('a' <= map[nx][ny] && map[nx][ny] <= 'z') { // 열쇠
						keyBit |= 1 << (map[nx][ny] - 'a');
						for (int key : doorList.keySet()) { // 해당 열쇠에 맞는 대기 중인 대문 찾기
							if ((keyBit & key) == key) { // 열쇠 주우면 대문 위치 queue
								waitingQueueExtract(queue, key);
							}
						}
					} else if ('A' <= map[nx][ny] && map[nx][ny] <= 'Z') { // 대문
						int key = 1 << (map[nx][ny] - 'A');
						if ((keyBit & key) != key) { // 열쇠 X
							putDoorQueue(nx, ny, key); // 대기
							continue;
						}
					}
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}
	}

	private static void waitingQueueExtract(Queue<int[]> q, int key) {
		Queue<int[]> queue = doorList.get(key);
		while (!queue.isEmpty()) {
			q.offer(queue.poll());
		}
	}

	private static void putDoorQueue(int i, int j, int key) {
		if (!doorList.containsKey(key)) {
			doorList.put(key, new LinkedList<>());
		}
		doorList.get(key).add(new int[] {i, j});
	}
}
