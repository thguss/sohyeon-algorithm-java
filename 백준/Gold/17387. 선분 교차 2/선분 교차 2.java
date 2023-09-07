import java.util.*;
import java.io.*;

public class Main {

	static class Point {
		long x, y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Point[] points = new Point[4];

		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		points[0] = new Point(x1, y1);

		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		points[1] = new Point(x2, y2);

		st = new StringTokenizer(br.readLine());

		long x3 = Long.parseLong(st.nextToken());
		long y3 = Long.parseLong(st.nextToken());
		points[2] = new Point(x3, y3);


		long x4 = Long.parseLong(st.nextToken());
		long y4 = Long.parseLong(st.nextToken());
		points[3] = new Point(x4, y4);

		System.out.println(check(points));

	}

	private static int check(Point[] p) {
		boolean is_result = false;
		int res = 0;

		int p123 = ccw(p[0], p[1], p[2]);
		int p124 = ccw(p[0], p[1], p[3]);
		int p341 = ccw(p[2], p[3], p[0]);
		int p342 = ccw(p[2], p[3], p[1]);

		boolean compare1 = Math.min(p[0].x, p[1].x) <= Math.max(p[2].x, p[3].x);
		boolean compare2 = Math.min(p[2].x, p[3].x) <= Math.max(p[0].x, p[1].x);
		boolean compare3 = Math.min(p[0].y, p[1].y) <= Math.max(p[2].y, p[3].y);
		boolean compare4 = Math.min(p[2].y, p[3].y) <= Math.max(p[0].y, p[1].y);

		if (p123 * p124 == 0 && p341 * p342 == 0) {
			is_result = true;
			if (compare1 && compare2 && compare3 && compare4) {
				res = 1;
			}
		}

		if (p123 * p124 <= 0 && p341 * p342 <= 0) {
			if (!is_result) {
				res = 1;
			}
		}

		return res;
	}

	private static int ccw(Point p1, Point p2, Point p3) {
		// CCW 공식 (x1y2 + x2y3 + x3y1)−(y1x2 + y2x3 + y3x1)
		long res = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p1.y * p2.x + p2.y * p3.x + p3.y * p1.x);
		if (res > 0) {
			return 1;
		} else if (res == 0) {
			return 0;
		} else {
			return -1;
		}
	}
}
