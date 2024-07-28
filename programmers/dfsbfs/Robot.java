package programmers.dfsbfs;
import java.util.*;

/*
 * LG 산학장학생 코딩테스트 문제
 * 1. bfs 에서 전단계와 현재 단계 사이에서 arrayList를 활용했는데 새로 만들어주지 않고 이어줘서 call by reference 문제 발생으로, 독립적이어야 하는 것들이 연관관계가 생겼음.
 * 2. forward의 경우 새로 만들어주는 것으로 해결, convertable 조건문 작성도 실수함. 조건문 후에 추가되는거라 3개부터 전환할 수 없으면, size 2부터 추가할 수 없는건데. <3으로 해둠.
 * 3. 종료 조건도 length 실수로 잘못함.
 */
class Robot {
    char[][] board;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        String[] grid = {"...", "#.#", "#.#", "#.."};
        Robot robot = new Robot();
        int a = robot.solution(grid);
    }
    public int solution(String[] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length();
        board = new char[rowSize][colSize];
        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<colSize; j++) {
                board[i][j] = grid[i].charAt(j);
            }
        }
        return bfs(new Position(0, 0, 0, 1, new ArrayList<>()));
    }

    int bfs(Position init) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(init);
        int elementSize = 0;
        while(!queue.isEmpty()) {
            System.out.println("elementSize : " + ++elementSize);
            Position current = queue.poll();
            System.out.println("current : " + current);
            if (current.row == board.length - 1 && current.col == board[0].length - 1) {
                System.out.println("arrived : " + current.depth);
                return current.depth;
            }
            if (current.isMovable()) {
                Position next = current.goForward();
                System.out.println("forward : " + next);
                queue.add(next);
            }
            if (current.isConvertable()) {
                Position next = current.convertDirection();
                System.out.println("convert : " + next);
                queue.add(next);
            };
        }
        return 0;
    }

    class Position{
        int row;
        int col;
        int depth;
        int direction;
        ArrayList<Boolean> isConverted;

        Position(int row, int col, int depth, int direction, ArrayList<Boolean> isConverted) {
            this.row = row;
            this.col = col;
            this.depth = depth;
            this.direction = direction;
            this.isConverted = isConverted;
        }

        Position convertDirection() {
            int newDirection = direction - 1 < 0 ? 3 : direction - 1;
            isConverted.add(0, true);
            return new Position(this.row, this.col, this.depth + 1, newDirection, this.isConverted);
        }

        Position goForward() {
            int nextRow = row + dx[this.direction];
            int nextCol = col + dy[this.direction];
            return new Position(nextRow, nextCol, this.depth + 1, this.direction, new ArrayList<>());
        }

        boolean isMovable() {
            int nextRow = row + dx[this.direction];
            int nextCol = col + dy[this.direction];
            System.out.println(this.direction);
            System.out.println("nextRow, nextCol : " + nextRow + ", " + nextCol);
            return !(nextRow >= board.length || nextRow < 0 || nextCol >= board[0].length || nextCol < 0) && board[nextRow][nextCol] != '#';
        }

        boolean isConvertable() {
            return isConverted.size() < 2;
        }

        public String toString() {
            String string = "row, col, depth, direction, isConverted\n";
            string += row + ", " + col + ", " + depth + ", " + direction + ", ";
            for (int i=0; i<isConverted.size() ; i++) {
                string += isConverted.get(i);
            }
            return string;
        }
    }
}
