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

        List<Integer> al = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String keyword = st.nextToken();
            int limit = Integer.valueOf(st.nextToken());
            if (!map.containsKey(limit)) {
                al.add(limit);
                map.put(limit, keyword);
            }
        }

        Collections.sort(al);

        for (int i = 0; i < M; i++) {
            int score = Integer.valueOf(br.readLine());
            bw.write(bs(al, map, score) + "\n");
        }
        
        bw.flush();
    }

    private static String bs(List<Integer> keys, Map<Integer, String> map, int score) {
        int left = 0;
        int right = keys.size() - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int key = keys.get(mid);

            if (score <= key) {
                right = mid - 1;
                min = Math.min(min, key);
            } else {
                left = mid + 1;
            }
        }

        return map.get(min);
    }

}