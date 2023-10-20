import java.util.*;

class Solution {
    
    static boolean[] isNum, visited;
    static int size = 0;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static class Point {
        int x, y, d;
        
        Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    public int solution(int[][] board, int r, int c) {
        isNum = new boolean[7];
        visited = new boolean[7];
        
        // 보드판에 있는 카드 확인
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(board[i][j] == 0 || isNum[board[i][j]]) continue;
                isNum[board[i][j]] = true;
                size++;
            }
        }
        
        permutation(0, new int[size], board, r, c);
        

        return answer;
    }
    
    private void bfs(int[][] board, int r, int c, int[] arr) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c, 0));
        
        boolean[][] isVisited = new boolean[4][4];
        isVisited[r][c] = true;
        
        boolean[][] enterVisited = new boolean[4][4];
        
        int answerCnt = 0;
        int idx = 0;
        boolean isSecond = false;
        
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            
            // 카드 일치
            if(board[cur.x][cur.y] == arr[idx] && !enterVisited[cur.x][cur.y]) {
                enterVisited[cur.x][cur.y] = true;
                answerCnt++; // enter
                answerCnt += cur.d; // 최단 이동 거리
                
                queue.clear();
                queue.add(new Point(cur.x, cur.y, 0));
                
                isVisited = new boolean[4][4];
                isVisited[cur.x][cur.y] = true;
                
                if(!isSecond) {
                    isSecond = true;
                } else {
                    isSecond = false;
                    idx++;
                    if(idx >= arr.length) {
                        answer = Math.min(answer, answerCnt);
                        return;
                    }
                }
                
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                // 한 칸 이동
                if(0 <= nx && nx < 4 && 0 <= ny && ny < 4 && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    queue.add(new Point(nx, ny, cur.d + 1));
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                while(0 <= nx + dx[i] && nx + dx[i] < 4 && 0 <= ny + dy[i] && ny + dy[i] < 4) {
                    nx += dx[i];
                    ny += dy[i];
                    
                    if(board[nx][ny] != 0 && !enterVisited[nx][ny]) {
                        break;
                    }
                }
                
                // ctrl 이동
                if(0 <= nx && nx < 4 && 0 <= ny && ny < 4 && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    queue.add(new Point(nx, ny, cur.d + 1));
                }
            }
        }
    }
    
    private void permutation(int cnt, int[] arr, int[][] board, int r, int c) {
        if(size == cnt) {
            // arr 순서대로 bfs 돌리기
            bfs(board, r, c, arr);
            return;
        }
        
        for(int i = 1; i <= 6; i++) {
            if(visited[i] || !isNum[i]) continue; // 없는 카드이거나 방문했으면 pass
            visited[i] = true;
            arr[cnt] = i;
            permutation(cnt + 1, arr, board, r, c);
            visited[i] = false;
        }
    }
}