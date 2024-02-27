import java.util.*;
import java.io.*;

public class Main {

	static int N, M;

	public static void main(String[] args) throws Exception {
		int[] lights = getLights();
		System.out.println(bs(lights));
	}

	static int bs(int[] lights) {
		int left = 1; // 굴다리 최소 길이
		int right = N; // 굴다리 최대 길이
		int result = N;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (isBrightAll(lights, mid)) {
				result = Math.min(result, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return result;
	}

	static boolean isBrightAll(int[] lights, int height) {
		int brightPoint = 0;

		for (int lightPosition : lights) {
			if (lightPosition - height <= brightPoint) {
				brightPoint = lightPosition + height; // 현재 가로등이 비추는 거리(최대)
			} else {
				return false;
			}
		}

		return brightPoint >= N;
	}

	static int[] getLights() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine()); // 굴다리의 길이
		M = Integer.parseInt(br.readLine()); // 가로등 개수

		int[] lights = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			lights[i] = Integer.parseInt(st.nextToken());
		}

		return lights;
	}

}