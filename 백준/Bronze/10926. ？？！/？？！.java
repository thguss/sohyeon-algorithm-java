import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		String name = getName();
		System.out.println(name + "??!");
	}

	static String getName() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		return br.readLine();
	}

}