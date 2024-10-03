import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean res = false;
    static String S, T;

    public static void main(String[] args) throws Exception {
        // StringTokenizer st = new StringTokenizer(br.readLine());
        S = br.readLine();
        T = br.readLine();

        dfs(T);

        bw.write(res ? "1" : "0");
        bw.flush();
    }

    private static void dfs(String str) {
        if (res) return;
        
        if (str.length() == S.length()) {
            if (str.equals(S)) res = true;
            return;
        }

        if (str.charAt(str.length() - 1) == 'A') {
            dfs(str.substring(0, str.length() - 1));
        }

        if (str.charAt(0) == 'B') {
            dfs(new StringBuilder(str).reverse().toString().substring(0, str.length() - 1));
        }
    }

}