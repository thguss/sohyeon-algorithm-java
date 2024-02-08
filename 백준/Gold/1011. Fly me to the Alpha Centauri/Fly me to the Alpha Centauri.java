import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.io.*;

import org.w3c.dom.Node;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			System.out.println(calculateCount(x, y));
		}
	}

	private static int calculateCount(int x, int y) {
		int distance = y - x; // 총 이동 거리
		int max = (int)Math.sqrt(distance); // 최대 이동 거리

		/**
		 * 최대 이동 거리(max) = 총 이동 거리(distance)의 제곱근 (소수 버림)
		 * max가 처음으로 변하는 시점에서 count = (max * 2 - 1)
		 */
		if (max == Math.sqrt(distance)) {
			return max * 2 - 1;
		}

		/**
		 * distance가 제곱 수에서 제곱 수+1로 넘어갈 경우 count 1 증가
		 * max가 증가하는 지점에 총 이동 횟수(count) "2번" 증가
		 * count 값 기준으로 묶으면, 묶음 당 개수가 max 값과 동일
		 */
		if (distance <= max * max + max) {
			return max * 2;
		} else {
			return max * 2 + 1;
		}
	}
}