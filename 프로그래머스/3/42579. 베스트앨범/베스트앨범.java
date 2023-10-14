import java.util.*;

class Solution {
    
    static Map<String, Integer> map;
    
    static class Song implements Comparable<Song> {
        int id;
        String genre;
        int playCnt;
        
        Song(int id, String genre, int playCnt) {
            this.id = id;
            this.genre = genre;
            this.playCnt = playCnt;
        }
        
        @Override
        public int compareTo(Song o) {
            if (map.get(this.genre) == map.get(o.genre)) {
                if (this.playCnt == o.playCnt) {
                    return this.id - o.id;
                }
                return o.playCnt - this.playCnt;
            }
            return map.get(o.genre) - map.get(this.genre);
        }
        
    }
    
    public int[] solution(String[] genres, int[] plays) {
        map = new HashMap<>();
        
        List<Song> songs = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) map.put(genres[i], 0);
            map.put(genres[i], map.get(genres[i]) + plays[i]);
            songs.add(new Song(i, genres[i], plays[i]));
        }
        
        System.out.println(map);
        
        Collections.sort(songs);
        
        Map<String, Integer> map2 = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (Song song : songs) {
            if (!map2.containsKey(song.genre)) map2.put(song.genre, 0);
            if (map2.get(song.genre) >= 2) continue;
            map2.put(song.genre, map2.get(song.genre) + 1);
            result.add(song.id);
        }
        
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}