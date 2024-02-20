import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		int year = getYear();
		System.out.println(year - 543);
	}

	static int getYear() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		return Integer.parseInt(br.readLine());
	}

}