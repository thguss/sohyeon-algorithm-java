import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();

        bw.write(String.valueOf(solve(str)));
        bw.flush();
    }

    private static int solve(String str) {
        int check = 0;
        int origin = 0;

        while (origin++ <= 30000) {
            String temp = String.valueOf(origin);

            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == str.charAt(check)) check++;
                if (check >= str.length()) return origin;
            }
        }

        return origin;
    }

}