import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		int[][] gears = getGears();
		System.out.println(calculate(gears));
	}

	static int calculate(int[][] gears) {
		int sum = 0;

		sum += (gears[0][0] == 0) ? 0 : 1;
		sum += (gears[1][0] == 0) ? 0 : 2;
		sum += (gears[2][0] == 0) ? 0 : 4;
		sum += (gears[3][0] == 0) ? 0 : 8;

		return sum;
	}

	static int[][] getGears() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] gears = new int[4][8]; // 톱니바퀴 정보
		for (int i = 0; i < 4; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				gears[i][j] = Integer.parseInt(arr[j]); // N극(0), S극(1)
			}
		}

		int K = Integer.parseInt(br.readLine()); // 회전횟수
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gearNum = Integer.parseInt(st.nextToken()); // 톱니바퀴 번호
			int dist = Integer.parseInt(st.nextToken()); // 방향, 시계방향(1), 반시계방향(-1)
			rotate(gears, gearNum - 1, dist);
			// print(gears);
		}

		return gears;
	}

	static void print(int[][] gears) {
		System.out.println();
		for (int[] gear : gears) {
			System.out.println(Arrays.toString(gear));
		}
	}

	static void rotate(int[][] gears, int gearNum, int dist) {
		if (gearNum == 0) {
			if (gears[0][2] != gears[1][6]) { // 1번 - 2번 비교 (다르면 회전)
				if (gears[1][2] != gears[2][6]) { // 2번 - 3번 비교 (다르면 회전)
					if (gears[2][2] != gears[3][6]) { // 3번 - 4번 비교 (다르면 회전)
						rotateGear(gears, 3, (-1) * dist);
					}
					rotateGear(gears, 2, dist);
				}
				rotateGear(gears, 1, (-1) * dist); // 2번 반대 방향으로 회전
			}
			rotateGear(gears, 0, dist); // 1번 회전
		} else if (gearNum == 1) {
			if (gears[1][6] != gears[0][2]) { // 2번 - 1번 비교
				rotateGear(gears, 0, (-1) * dist);
			}
			if (gears[1][2] != gears[2][6]) { // 2번 - 3번 비교
				if (gears[2][2] != gears[3][6]) { // 3번 - 4번 비교
					rotateGear(gears, 3, dist);
				}
				rotateGear(gears, 2, (-1) * dist);
			}
			rotateGear(gears, 1, dist); // 2번 회전
		} else if (gearNum == 2) {
			if (gears[2][6] != gears[1][2]) { // 3번 - 2번 비교
				if (gears[1][6] != gears[0][2]) { // 1번 - 2번 비교
					rotateGear(gears, 0, dist);
				}
				rotateGear(gears, 1, (-1) * dist);
			}
			if (gears[2][2] != gears[3][6]) { // 3번 - 4번 비교
				rotateGear(gears, 3, (-1) * dist);
			}
			rotateGear(gears, 2, dist); // 3번 회전
		} else if (gearNum == 3) {
			if (gears[3][6] != gears[2][2]) { // 4번 - 3번 비교
				if (gears[2][6] != gears[1][2]) { // 3번 - 2번 비교
					if (gears[1][6] != gears[0][2]) { // 2번 - 1번 비교
						rotateGear(gears, 0, (-1) * dist);
					}
					rotateGear(gears, 1, dist);
				}
				rotateGear(gears, 2, (-1) * dist);
			}
			rotateGear(gears, 3, dist); // 4번 회전
		}
	}

	static void rotateGear(int[][] gears, int gearNum, int dist) {
		if (dist == 1) { // 시계방향
			int[] arr = new int[8];
			for (int i = 1; i < 8; i++) {
				arr[i] = gears[gearNum][i - 1];
			}
			arr[0] = gears[gearNum][7];
			for (int i = 0; i < 8; i++) {
				gears[gearNum][i] = arr[i];
			}
		} else if (dist == -1) { // 반시계방향
			int[] arr = new int[8];
			for (int i = 0; i < 7; i++) {
				arr[i] = gears[gearNum][i + 1];
			}
			arr[7] = gears[gearNum][0];
			for (int i = 0; i < 8; i++) {
				gears[gearNum][i] = arr[i];
			}
		}
	}
}