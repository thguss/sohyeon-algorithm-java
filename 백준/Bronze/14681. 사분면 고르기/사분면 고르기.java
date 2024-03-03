import java.util.*;
import java.io.*;

public class Main {
	static int X, Y;

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getPosition(X, Y));
	}

	static int getPosition(int x, int y) {
		if (x > 0 && y > 0) return 1;
		else if (x < 0 && y > 0) return 2;
		else if (x <0 && y < 0) return 3;
		else return 4;
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		X = Integer.parseInt(br.readLine());
		Y = Integer.parseInt(br.readLine());
	}

}