import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {
        int N = Integer.valueOf(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            String channel = br.readLine();
            arr[i] = channel;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i].equals("KBS1")) {
                String tmp = "";
                for (int j = i; j > 0; j--) {
                    bw.write("4");
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
                break;
            } else bw.write("1");
        }

        if (!arr[1].equals("KBS2")) {
            for (int i = 0; i < N; i++) {
                if (arr[i].equals("KBS2")) {
                    String tmp = "";
                    for (int j = i; j > 1; j--) {
                        bw.write("4");
                        tmp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = tmp;
                    }
                    break;
                } else bw.write("1");
            }
        }

        bw.flush();
    }
}