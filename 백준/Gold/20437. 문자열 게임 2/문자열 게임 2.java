import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void solve(String str, int K) throws Exception {
        if (K == 1) {
            bw.write("1 1\n");
            return;
        }

        int min = Integer.MAX_VALUE;
        int max = -1;

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> indexes = entry.getValue();

            if (indexes.size() >= K) {
                for (int i = 0; i <= indexes.size() - K; i++) {
                    int len = indexes.get(i + K - 1) - indexes.get(i) + 1;
                    min = Math.min(min, len);
                    max = Math.max(max, len);
                }
            }
        }

        if (min == Integer.MAX_VALUE || max == -1) {
            bw.write("-1\n");
        } else {
            bw.write(String.valueOf(min) + " " + String.valueOf(max) + "\n");
        }
    }

    public static void main(String[] args) throws Exception {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.valueOf(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            int K = Integer.valueOf(br.readLine());
            solve(str, K);
        }
        
        bw.flush();
    }

}