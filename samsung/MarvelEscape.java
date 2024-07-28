package samsung;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class MarvelEscape {
    static List<List<String>> board = new ArrayList<>();
    static boolean[][] isVisited;
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] li = br.readLine().split(" ");
        int N = Integer.parseInt(li[0]);
        int M = Integer.parseInt(li[1]);
        isVisited = new boolean[N+1][M+1];
        Ball red;
        Ball blue;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            List<String> temp = new ArrayList<>();
            for(int k = 0; k < line.length()-1; k++) {
                String elem = line.substring(k, k+1);
                if (elem.equals("B")) {
                    blue = new Ball(i, k);
                    elem = ".";
                }
                if (elem.equals("R")) {
                    isVisited[i][k] = true;
                    red = new Ball(i, k);
                    elem = ".";
                }
                temp.add(elem);
            }
            board.add(temp);
        }
    }

    int bfs(Ball red, Ball blue, int goalRow, int goalCol) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(red, blue));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.tryCount > 10) return -1;
            for(int i=0; i<4; i++) {
                int nextRow = pair.red.row + dRow[i];
                int nextCol = pair.red.col + dCol[i];
                if (nextRow > 0 && nextRow < board.size() && nextCol > 0 && nextCol < board.get(0).size()) {
                    String nextElem = board.get(nextRow).get(nextCol);
                    if (nextElem.equals(".") && !isVisited[nextRow][nextCol]) {
                        
                    }
                }
            }
        }
        return -1;
    }

    static class Pair {
        Ball red;
        Ball blue;
        int tryCount = 0;
        Pair(Ball red, Ball blue) {
            this.red = red;
            this.blue = blue;
        }
    }

    static class Ball {
        int row;
        int col;

        Ball(Ball ball) {
            this.row = ball.row;
            this.col = ball.col;
        }

        Ball (int row, int col) {
            this.row = row;
            this.col = col;
        }

        void moveLeft(Ball blue) {
            int nextRow = this.row;
            int nextCol = this.col - 1;
            while(!board.get(nextRow).get(nextCol).equals("#"))
        }
    }
}
