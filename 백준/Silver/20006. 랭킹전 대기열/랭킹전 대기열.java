import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Room {
        int level;
        List<User> users = new ArrayList<>();

        Room(int level) {
            this.level = level;
        }
    }

    public static class User implements Comparable<User> {
        int level;
        String id;

        public User(int level, String id) {
            this.level = level;
            this.id = id;
        }

        @Override
        public int compareTo(User o) {
            return this.id.compareTo(o.id);
        }
    }
    
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.valueOf(st.nextToken());
            String id = st.nextToken();
            User user = new User(level, id);
            boolean isJoin = false;

            for (Room room : rooms) {
                if (room.users.size() == m || Math.abs(room.level - user.level) > 10) continue;
                room.users.add(user);
                isJoin = true;
                break;
            }

            if (!isJoin) {
                Room room = new Room(user.level);
                room.users.add(user);
                rooms.add(room);
            }
        }

        for (Room room : rooms) {
            boolean isStarted = room.users.size() == m;
            bw.write(isStarted ? "Started!\n" : "Waiting!\n");
            Collections.sort(room.users);
            for (User user : room.users) {
                bw.write(String.valueOf(user.level) + " " + user.id + "\n");
            }
        }

        bw.flush();
    }

}