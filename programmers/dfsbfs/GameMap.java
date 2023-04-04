package programmers.dfsbfs;

import java.util.*;
class GameMap {
    int N,M;
    boolean[][] visited;
    int[][] diff = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int bfs(int[][] maps, Position startPos) {
        Queue<Position> queue = new LinkedList<Position>();
        queue.add(startPos);
        visited[startPos.row][startPos.col] = true;
        
        while(!queue.isEmpty()) {
            Position currentPos = queue.poll();
            if (currentPos.row == N-1 && currentPos.col == M-1) {
                return currentPos.cnt + 1;
            }
            for (int i=0; i<4; i++) {
                int nextRow = currentPos.row + diff[i][0];
                int nextCol = currentPos.col + diff[i][1];
                if (nextRow >=0 && nextRow < N && nextCol >=0 && nextCol < M) {
                    if (!visited[nextRow][nextCol] && maps[nextRow][nextCol]==1) {
                        Position nextPos = new Position(nextRow, nextCol, currentPos.cnt + 1);
                        queue.add(nextPos);
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        
        return -1;
    }
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        int answer = bfs(maps, new Position(0,0,0));
        return answer;
    }
    
    class Position {
        int row;
        int col;
        int cnt;
        Position(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }
}
