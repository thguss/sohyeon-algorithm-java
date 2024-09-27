import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int range = 2;

        if (N == 1) bw.write(String.valueOf(1));
        else {
            while (range <= N) {
                range += (6 * count);
                count++;
            }
            bw.write(String.valueOf(count));
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