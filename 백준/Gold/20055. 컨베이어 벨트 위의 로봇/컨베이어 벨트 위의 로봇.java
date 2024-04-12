import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		int[][] container = getContainer();
		System.out.println(solve(container));
	}

	static int solve(int[][] container) {
		boolean[] robot = new boolean[N];
		int time = 1;

		while (true) {
			// for (int i = 0; i < 2 * N; i++) {
			// 	System.out.print(container[i][0] + " ");
			// }
			// System.out.println();

			// 1. 벨트 회전
			turnContainer(container, robot);

			// 2. 로봇 이동
			moveRobot(container, robot);

			// 3. 로봇 올리기
			boardRobot(container, robot);

			// 4. 내구도 0인 위치가 K개 이상이면 종료, 아니면 반복
			// int temp = 0;
			// for (int i = 0; i < N * 2; i++) {
			// 	if (container[i][0] <= 0) temp++;
			// }
			if (cnt >= K) break;
			time++;
		}

		return time;
	}

	static void boardRobot(int[][] container, boolean[] robot) {
		if (!robot[0] && container[0][0] > 0) {
			container[0][0]--;
			robot[0] = true;

			if (container[0][0] == 0 && container[0][1] == 0) {
				cnt++;
				container[0][1] = 1; // visit
			}
		}
	}

	static void moveRobot(int[][] container, boolean[] robot) {
		for (int i = N - 1; i >= 0; i--) {
			if (!robot[i]) continue;

			int next = i + 1;

			if (next == N) {
				robot[i] = false;
				continue;
			}

			if (next < N && !robot[next]) {
				if (container[next][0] > 0) {
					robot[next] = true;
					robot[i] = false;
					container[next][0]--;

					if (container[next][0] == 0 && container[next][1] == 0) {
						cnt++;
						container[next][1] = 1; // visit
					}
				}
			}
		}
	}

	static void turnRobot(boolean[] robot) {
		for (int i = N - 1; i > 0; i--) {
			robot[i] = robot[i - 1];
		}

		robot[0] = false;
	}

	static void turnContainer(int[][] container, boolean[] robot) {
		int temp1 = container[N * 2 - 1][0];
		int temp2 = container[N * 2 - 1][1];

		for (int i = N * 2 - 1; i > 0; i--) {
			container[i][0] = container[i - 1][0];
			container[i][1] = container[i - 1][1];
		}

		container[0][0] = temp1;
		container[0][1] = temp2;

		turnRobot(robot);
	}

	static int[][] getContainer() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 컨테이너 크기
		K = Integer.parseInt(st.nextToken()); // 내구도 0 허용 개수

		int[][] container = new int[N * 2][2];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N * 2; i++) {
			container[i][0] = Integer.parseInt(st.nextToken());
		}

		return container;
	}

}