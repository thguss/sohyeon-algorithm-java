import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            String type = getType(new int[] {a, b, c});
            bw.write(type + "\n");
        }

        bw.flush();
    }

    private static String getType(int[] arr) {
        Arrays.sort(arr);
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        if (c >= a + b) {
            return "Invalid";
        }
        
        if (a == b && b == c && c == a) {
            return "Equilateral";
        }

        if (a == b || b == c || c == a) {
            return "Isosceles";
        }

        return "Scalene";
    }
}