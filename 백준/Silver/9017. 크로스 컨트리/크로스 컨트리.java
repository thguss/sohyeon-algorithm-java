import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Team implements Comparable<Team> {
        int num;
        int score = 0;
        List<Integer> al = new ArrayList<>();

        public Team(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Team o) {
            if (this.score == o.score) {
                return this.al.get(4) - o.al.get(4);
            }
            return this.score - o.score;
        }
    }

    public static void main(String[] args) throws Exception {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.valueOf(br.readLine());

        while (T-- > 0) {
            int M = Integer.valueOf(br.readLine());
            int[] arr = new int[M];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr[i] = Integer.valueOf(st.nextToken());
            }
            bw.write(String.valueOf(solve(arr)) + "\n");
        }

        bw.flush();
    }

    private static int solve(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Team> teamMap = new HashMap<>();
        int rank = 1;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            
            if (map.get(num) != 6) continue;

            if (!teamMap.containsKey(num)) {
                teamMap.put(num, new Team(num));
            }
            
            Team t = teamMap.get(num);
            t.al.add(rank);
            rank++;
        }

        for (Team team : teamMap.values()) {
            Collections.sort(team.al);
            for (int i = 0; i < 4; i++) {
                team.score += team.al.get(i);
            }
        }

        List<Team> teams = new ArrayList<>(teamMap.values());
        Collections.sort(teams);

        return teams.get(0).num;
    }

}