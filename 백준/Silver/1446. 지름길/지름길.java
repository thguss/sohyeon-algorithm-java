import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Road implements Comparable<Road> {
        int start;
        int end;
        int cost;

        public Road(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int D = Integer.valueOf(st.nextToken());
        List<Road> roads = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            roads.add(new Road(start, end, cost));
        }

        Collections.sort(roads);

        int[] distances = new int[10001];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        int idx = 0;
        int distance = 0;

        while (distance < D) {
            if (idx < roads.size()) {
                Road road = roads.get(idx);
                if (distance == road.start) {
                    distances[road.end] = Math.min(distances[road.end], distances[distance] + road.cost);
                    idx++;
                    continue;
                }
            }
            distances[distance + 1] = Math.min(distances[distance + 1], distances[distance] + 1);
            distance++;
        }

        bw.write(String.valueOf(distances[D]));
        bw.flush();
    }

}