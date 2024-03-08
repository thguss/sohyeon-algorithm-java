import java.sql.Time;
import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		solve();
	}

	static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken()); // hour
		int B = Integer.parseInt(st.nextToken()); // minute

		int time = Integer.parseInt(br.readLine());

		int startMinute = A * 60 + B;
		int endMinute = startMinute + time;

		int hour = endMinute / 60;
		int minute = endMinute % 60;

		System.out.println((hour < 24 ? hour : (hour - 24)) + " " + minute);
	}
}