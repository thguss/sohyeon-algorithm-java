import java.sql.Time;
import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println(getMoney());
	}

	static int getMoney() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int dice1 = Integer.parseInt(st.nextToken());
		int dice2 = Integer.parseInt(st.nextToken());
		int dice3 = Integer.parseInt(st.nextToken());

		if (dice1 == dice2 && dice2 == dice3) {
			return dice1 * 1000 + 10000;
		} else if (dice1 != dice2 && dice2 != dice3 && dice3 != dice1) {
			int max = Math.max(dice1, Math.max(dice2, dice3));
			return max * 100;
		} else {
			int sameValue;
			if (dice1 == dice2) {
				sameValue = dice1;
			} else if (dice2 == dice3) {
				sameValue = dice2;
			} else {
				sameValue = dice3;
			}
			return 1000 + sameValue * 100;
		}
	}
}