import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static Queue<int[]> houses = new LinkedList<>();
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[] headPosition;

	public static void main(String[] args) throws IOException {

		/**
		 * 머리는 심장 바로 윗 칸에 1칸 크기로 있다. (심장 : 머리 바로 밑에)
		 * 왼쪽 팔은 심장 바로 왼쪽에 붙어있고 왼쪽으로 뻗어 있으며, (왼쪽 팔 : 심장 바로 왼쪽에 일직선)
		 * 오른쪽 팔은 심장 바로 오른쪽에 붙어있고 오른쪽으로 뻗어있다. (오른쪽 팔 : 심장 바로 오른쪽에 일직선)
		 * 허리는 심장의 바로 아래 쪽에 붙어있고 아래 쪽으로 뻗어 있다. (허리 : 심장 바로 밑에)
		 * 왼쪽 다리는 허리의 왼쪽 아래에, (왼쪽 다리 : 허리 바로 왼쪽 아래 일직선)
		 * 오른쪽 다리는 허리의 오른쪽 아래에 바로 붙어있고, (오른쪽 다리 : 허리 바로 오른쪽 아래 일직선)
		 * 각 다리들은 전부 아래쪽으로 뻗어 있다.
		 */

		String[][] cookie = getCookie();

		// 심장 위치
		int[] heartPosition = getHeartPosition();
		System.out.println((heartPosition[0] + 1) + " " + (heartPosition[1] + 1));

		// 왼쪽 팔 크기
		System.out.print(getArmSize(cookie, heartPosition, "L") + " ");

		// 오른쪽 팔 크기
		System.out.print(getArmSize(cookie, heartPosition, "R") + " ");

		// 허리 위치 & 크기
		int[] waistPosition = getWaistPosition(cookie, heartPosition);

		// 왼쪽 다리 크기
		System.out.print(getLegSize(cookie, waistPosition, "L") + " ");

		// 오른쪽 다리 크기
		System.out.print(getLegSize(cookie, waistPosition, "R"));
	}

	static int getLegSize(String[][] cookie, int[] waistPosition, String way) {
		if (way.equals("L")) {
			return getSize(cookie, waistPosition[0] + 1, waistPosition[1] - 1, 1, 0);
		} else if (way.equals("R")) {
			return getSize(cookie, waistPosition[0] + 1, waistPosition[1] + 1, 1, 0);
		}
		return 0;
	}

	static int[] getWaistPosition(String[][] cookie, int[] heartPosition) {
		int x = heartPosition[0] + 1;
		int y = heartPosition[1];

		int size = getSize(cookie, x, y, 1, 0);
		System.out.print(size + " ");

		return new int[] {x + (size - 1), y};
	}

	static int getArmSize(String[][] cookie, int[] heartPosition, String way) {
		if (way.equals("L")) {
			return getSize(cookie, heartPosition[0], heartPosition[1] - 1, 0, -1);
		} else if (way.equals("R")) {
			return getSize(cookie, heartPosition[0], heartPosition[1] + 1, 0, 1);
		}

		return 0;
	}

	static int getSize(String[][] cookie, int x, int y, int dx, int dy) {
		int size = 0;

		while (0 <= x && x < N && 0 <= y && y < N && cookie[x][y].equals("*")) {
			size++;
			x += dx;
			y += dy;
		}

		return size;
	}

	static int[] getHeartPosition() {
		return new int[] {headPosition[0] + 1, headPosition[1]};
	}

	static String[][] getCookie() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());
		String[][] cookie = new String[N][N];

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("");

			for (int j = 0; j < N; j++) {
				cookie[i][j] = arr[j];

				if (headPosition == null && cookie[i][j].equals("*")) { // 가장 먼저 나오는 * == 머리
					headPosition = new int[] {i, j};
				}
			}
		}

		return cookie;
	}

}