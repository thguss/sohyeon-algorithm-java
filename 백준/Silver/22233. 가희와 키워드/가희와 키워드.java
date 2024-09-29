import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        Set<String> keywords = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String keyword = br.readLine();
            keywords.add(keyword);
        }

        for (int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(",");
            for (String str : arr) {
                if (keywords.contains(str)) keywords.remove(str);
            }
            bw.write(String.valueOf(keywords.size() + "\n"));
        }

        
        bw.flush();
    }

}