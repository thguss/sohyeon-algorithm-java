import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.io.*;

import org.w3c.dom.Node;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int height = getPosCnt(H, N + 1);
		int weight = getPosCnt(W, M + 1);

		System.out.println(height * weight);
	}

	private static int getPosCnt(int maxLen, int posLen) {
		int res = maxLen / posLen;
		return (maxLen % posLen == 0) ? res : res + 1;
	}
}