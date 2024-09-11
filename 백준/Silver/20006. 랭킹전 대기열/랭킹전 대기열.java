import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static class Room {
        List<Player> players = new ArrayList<>();
    }
    
    static class Player implements Comparable<Player> {
        int level;
        String nickname;
        
        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
        
        @Override
        public int compareTo(Player p) {
            return this.nickname.compareTo(p.nickname);
        }
    }

	public static void main(String[] args) throws Exception {
	    StringTokenizer st = new StringTokenizer(br.readLine());
		
		int p = Integer.parseInt(st.nextToken()); // 플레이어 수
		int m = Integer.parseInt(st.nextToken()); // 방의 정원
		List<Room> rooms = new ArrayList<>();

		for (int i = 0; i < p; i++) {
		    st = new StringTokenizer(br.readLine());
		    int l = Integer.parseInt(st.nextToken()); // 레벨
		    String n = st.nextToken(); // 닉네임
		    boolean isEntered = false;
		    
		    for (Room room : rooms) {
		        if (room.players.size() >= m) {
		            continue;
		        }
		        if (!room.players.isEmpty() && Math.abs(l - room.players.get(0).level) <= 10) {
		            isEntered = true;
		            room.players.add(new Player(l, n));
		            break;
		        }
		    }
		    
		    if (!isEntered) {
		        Room room = new Room();
		        room.players.add(new Player(l, n));
		        rooms.add(room);
		    }
		}
		
		for (Room room : rooms) {
		    Collections.sort(room.players);
		    bw.write(room.players.size() == m ? "Started!\n" : "Waiting!\n");
		    
		    for (Player player : room.players) {
		        bw.write(Integer.toString(player.level) + " " + player.nickname + "\n");
		    }
		}
		
		bw.flush();
	}
}