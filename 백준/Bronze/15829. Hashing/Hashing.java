
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int M = 1234567891;
		long res = 0;
		long pow = 1;

		for (int i = 0; i < N; i++) {
			int num = str.charAt(i) - 'a' + 1;
			res += num * pow % M;
			pow = pow * 31 % M;
		}

		System.out.println(res % M);
	}
}