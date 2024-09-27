import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {
        int N = Integer.valueOf(br.readLine());
        // StringTokenizer st = new StringTokenizer(br.readLine());

        bw.write(N % 2 == 1 ? "SK" : "CY");
        bw.flush();
    }
}