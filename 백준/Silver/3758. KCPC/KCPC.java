import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Team implements Comparable<Team> {
        int id;
        int score;
        int[] scores;
        int count = 0;
        int updatedAt = Integer.MAX_VALUE;

        Team(int id, int k) {
            this.id = id;
            this.scores = new int[k + 1];
        }

        public void updatedScore() {
            int sum = 0;
            for (int s : scores) {
                sum += s;
            }
            this.score = sum;
        }

        @Override
        public int compareTo(Team o) {
            if (this.score == o.score) {
                if (this.count == o.count) {
                    return this.updatedAt - o.updatedAt;
                }
                return this.count - o.count;
            }
            return o.score - this.score;
        }
    }

    static class Log {
        int i; // 팀
        int j; // 문제 ID
        int s; // 획득한 점수
        int order;

        Log(int i, int j, int s, int order) {
            this.i = i;
            this.j = j;
            this.s = s;
            this.order = order;
        }
    }

    public static void main(String[] args) throws Exception {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.valueOf(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken()); // 팀의 개수
            int k = Integer.valueOf(st.nextToken()); // 문제 개수
            int t = Integer.valueOf(st.nextToken()); // 속한 팀의 ID
            int m = Integer.valueOf(st.nextToken()); // 로그 엔트리 개수

            List<Log> logs = new ArrayList<>();
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.valueOf(st.nextToken());
                int solveId = Integer.valueOf(st.nextToken());
                int score = Integer.valueOf(st.nextToken());
                
                logs.add(new Log(teamId, solveId, score, i));
            }

            bw.write(String.valueOf(solve(n, k, t, logs)) + "\n");
        }
        
        bw.flush();
    }

    private static int solve(int n, int k, int t, List<Log> logs) {
        Map<Integer, Team> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new Team(i, k));
        }

        for (int i = 0; i < logs.size(); i++) {
            Log log = logs.get(i);
            Team team = map.get(log.i);
            team.scores[log.j] = Math.max(team.scores[log.j], log.s);
            team.count++;
            team.updatedAt = i;
        }

        List<Team> teams = new ArrayList<>();
        for (int key : map.keySet()) {
            Team team = map.get(key);
            team.updatedScore();
            teams.add(team);
        }

        Collections.sort(teams);

        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).id == t) return i + 1;
        }

        return teams.size();
    }

}