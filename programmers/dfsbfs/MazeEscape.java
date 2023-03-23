package programmers.dfsbfs;
import java.util.*;
import java.awt.Point;
public class MazeEscape {
    char[][] map;
    int N,M;
    Point ptr;
    Point start;
    Point end;
    Point lever;
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int bfs(Point start, Point end) {
        boolean[][] visited = new boolean[N][M];
        Queue<Position> queue = new LinkedList<Position>();
        queue.add(new Position(start, 0));
        visited[start.x][start.y] = true;
        
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            ptr = current.pos;
            int cnt = current.cnt;
            if (ptr.x == end.x && ptr.y == end.y) {
                return cnt;
            }
            
            for (int i=0; i<4; i++) {
                int nextRow = current.pos.x + dx[i];
                int nextCol = current.pos.y + dy[i];
                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                    if (map[nextRow][nextCol] != 'X' && !visited[nextRow][nextCol]) {
                        queue.add(new Position(new Point(nextRow, nextCol), cnt+1));
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        return -1;
    }
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];

        for ( int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[i].length(); j++) {
                char input = maps[i].charAt(j);
                map[i][j] = input;
                if (input == 'S') {
                    //스타트
                    start = new Point(i, j);
                }
                else if(input == 'E'){
                    //출구
                    end = new Point(i, j);
                }
                else if(input == 'L') {
                    //레버
                    lever = new Point(i, j);
                }
                    
            }
        }
        int levCnt = bfs(start, lever);
        if (levCnt == -1) return -1;
        int endCnt = bfs(ptr, end);
        if (endCnt == -1) return -1;
        return levCnt + endCnt;
    }
    class Position {
        Point pos;
        int cnt;
        Position(Point pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
}
