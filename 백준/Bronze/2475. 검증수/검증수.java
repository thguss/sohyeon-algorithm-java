
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int sum = 0;
		for (String str : arr) {
			sum += Math.pow(Integer.parseInt(str), 2);
		}
		System.out.println(sum % 10);
	}
}