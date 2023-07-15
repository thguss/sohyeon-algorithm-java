
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int room = 1;
		int circular = 1;
		while (room < N) {
			room += 6 * circular;
			circular++;
		}

		System.out.println(circular);
	}
}