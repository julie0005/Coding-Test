package baekjoon.DFSBFS;
import java.awt.Point;
import java.util.*;
public class MarbleEscape {
    static int N,M;
    static int holeRow, holeCol;
    static int redRow, redCol;
    static int blueRow, blueCol;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        visited = new boolean[N][M];
        sc.nextLine();

        // 보드 입력
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                if (i == 0 || i == N-1 || j == 0 || j == M-1) {
                    board[i][j] = -1;
                    continue;
                }
                String elem = line.substring(j, j+1);
                switch (elem) {
                    case "." -> board[i][j] = 1;
                    case "#" -> board[i][j] = -1;
                    case "0" -> {
                        board[i][j] = 0;
                        holeRow = i;
                        holeCol = j;
                    }
                    case "R" -> {
                        board[i][j] = 1;
                        redRow = i;
                        redCol = j;
                    }
                    case "B" -> {
                        board[i][j] = 1;
                        blueRow = i;
                        blueCol = j;
                    }
                }
            }
        }
        // 보드 출력
        for (int i = 0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        // bfs
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Position> queue = new LinkedList<Position>();
        queue.add(new Position(new Point(redRow, redCol), new Point(blueRow, blueCol), -1, 0));
        visited[redRow][redCol] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            int curRedRow = current.red.x;
            int curRedCol = current.red.y;
            int curBlueRow = current.blue.x;
            int curBlueCol = current.blue.y;
            int tilt = current.beforeTilt;
            int count = current.count;
            if (board[curRedRow][curRedCol] == 0) return count;
            System.out.printf("red position : %d, %d\nblue position : %d, %d\n beforeTilt : %d\ncount : %d\n\n", curRedRow, curRedCol, curBlueRow, curBlueCol, tilt, count);

            for (int i = 0; i < 4; i++) {
                int nextRedRow = curRedRow + dx[i];
                int nextRedCol = curRedCol + dy[i];
                int nextBlueRow = curBlueRow + dx[i];
                int nextBlueCol = curBlueCol + dy[i];
                int nextCount = tilt == i ? count : count+1;
                if (nextCount > 10) return -1;
                // refactoring is required
                if (!isMovable(nextRedRow, nextRedCol) && !isMovable(nextBlueRow, nextBlueCol)) continue;
                if (!isMovable(nextRedRow, nextRedCol)) {
                    nextRedRow = curRedRow;
                    nextRedCol = curRedCol;
                }
                if (!isMovable(nextBlueRow, nextBlueCol)) {
                    nextBlueRow = curBlueRow;
                    nextBlueCol = curBlueCol;
                }
                if (visited[nextRedRow][nextRedCol]) continue;
                if (board[nextBlueRow][nextBlueCol] == 0) continue;

                System.out.printf("NEXT!!!\nred position : %d, %d\nblue position : %d, %d\n beforeTilt : %d\ncount : %d\n\n", nextRedRow, nextRedCol, nextBlueRow, nextBlueCol, i, nextCount);

                Position nextPosition = new Position(new Point(nextRedRow, nextRedCol), new Point(nextBlueRow, nextBlueCol),
                        i, nextCount);
                queue.add(nextPosition);
                visited[nextRedRow][nextRedCol] = true;
            }
        }
        if (!visited[holeRow][holeCol]) return -1;
        else return -2;
    }

    public static boolean isMovable(int nextRow, int nextCol) {
        return board[nextRow][nextCol] != -1;
    }

    static class Position {
        Point red;
        Point blue;

        int beforeTilt;

        int count = 0;
        Position (Point red, Point blue, int tilt, int count) {
            this.red = red;
            this.blue = blue;
            this.beforeTilt = tilt;
            this.count = count;
        }
    }
}
