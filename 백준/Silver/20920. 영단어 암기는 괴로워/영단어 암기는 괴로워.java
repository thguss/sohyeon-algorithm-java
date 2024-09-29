import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Word implements Comparable<Word> {
        String str;
        int count;

        public Word(String str, int count) {
            this.str = str;
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            if (this.count == o.count) {
                if (o.str.length() == this.str.length()) {
                    return this.str.compareTo(o.str);
                }
                return o.str.length() - this.str.length();
            }
            return o.count - this.count;
        }
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        Queue<Word> pq = new PriorityQueue<>();
        
        for (String key : map.keySet()) {
            if (key.length() < M) continue;
            pq.add(new Word(key, map.get(key)));
        }

        while (!pq.isEmpty()) {
            Word word = pq.poll();
            bw.write(word.str + "\n");
        }

        bw.flush();
    }

}