import java.util.*;

class Solution {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
        
        @Override
        public String toString() {
            return "(" + this.x + " " + this.y + ")";
        }
    }
    
    static int n;
    static boolean[][] visited;
    static List<List<Point>> emptyList = new ArrayList<>(); // 빈 공간
    static List<List<Point>> blockList = new ArrayList<>(); // 테이블 블록
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        visited = new boolean[n][n];
        
        // 보드판의 빈 공간 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board[i][j] != 0 || visited[i][j]) continue;
                emptyList.add(bfs(game_board, i, j, 0));
            }
        }
        
        // visited 초기화
        for (boolean[] arr : visited) {
            Arrays.fill(arr, false);
        }
        
        // 테이블의 블록 구하기
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] != 1 || visited[i][j]) continue;
                blockList.add(bfs(table, i, j, 1));
            }
        }
        
        boolean[] visitedBoard = new boolean[emptyList.size()];
        int answer = 0;
        
        for (int i = 0; i < blockList.size(); i++) {
            List<Point> block = blockList.get(i);
            
            for (int j = 0; j < emptyList.size(); j++) {
                List<Point> empty = emptyList.get(j);
                
                if(block.size() == empty.size() && !visitedBoard[j]) {
                    if (rotate(block, empty)) {
                        visitedBoard[j] = true;
                        answer += block.size();
                        break;
                    }
                }
            }
        }
        
        
        return answer;
    }
    
    private boolean rotate(List<Point> block, List<Point> empty) {
        for(int i = 0; i < 4; i++) {
            int zeroX = block.get(0).x;
            int zeroY = block.get(0).y;
            
            // 블록 0 기준으로 맞추기
            for(int j = 0; j < block.size(); j++) {
                block.get(j).x -= zeroX;
                block.get(j).y -= zeroY;
            }
            
            boolean isCorrect = true;
            
            for (int j = 0; j < empty.size(); j++) {
                Point emptyP = empty.get(j);
                Point blockP = block.get(j);
                
                // 하나라도 다르면 즉시 중단
                if (emptyP.x != blockP.x || emptyP.y != blockP.y) {
                    isCorrect = false;
                    break;
                }
            }
            
            if (isCorrect) return true;
            else { // 90도 회전 : (y, -x)
                for (int j = 0; j < block.size(); j++) {
                    int temp = block.get(j).x;
                    block.get(j).x = block.get(j).y;
                    block.get(j).y = (-1) * temp;
                }
                Collections.sort(block);
            }
        }
        
        return false;
    }
    
    private List<Point> bfs(int[][] board, int x, int y, int type) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        
        List<Point> al = new ArrayList<>();
        al.add(new Point(0, 0)); // 빈 공간이나 블록의 첫 좌표
        
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (visited[nx][ny] || board[nx][ny] != type) continue;
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    al.add(new Point(nx - x, ny - y));
                }
            }
        }
        
        Collections.sort(al);
        
        return al;
    }
}