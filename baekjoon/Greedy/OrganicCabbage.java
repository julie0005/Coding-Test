package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class OrganicCabbage {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void bfs(boolean[][] board, boolean[][] visited, int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i=0; i<4; i++) {
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];
                if (nextX >= 0 && nextX < board[0].length && nextY >= 0 && nextY < board.length) {
                    if (!visited[nextY][nextX] && board[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        queue.add(new Point(nextX, nextY));
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws IOException{
        int testCase = 0;
        int width = 0;
        int height = 0;
        int num = 0;
        boolean[][] board;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        testCase = Integer.parseInt(st.nextToken());
        for (int i=0; i<testCase; i++) {
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());
            board = new boolean[height][width];
            int cluster = 0;
            boolean[][] visited = new boolean[height][width];
            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = true;
            }

            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    if (board[j][k] && !visited[j][k]) {
                        cluster++;
                        bfs(board, visited, j, k);
                    }
                }
            }
            System.out.println(cluster);
        }

    }
    
}
