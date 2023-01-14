package samsung;


import java.util.*;
import java.io.FileInputStream;
class Travel
{
    static String[][] board;
    static boolean[][] isVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R, C;
    static int max=-1;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        Stack<String> goods = new Stack<>();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			R = sc.nextInt();
            C = sc.nextInt();
            board = new String[R][C];
            isVisited = new boolean[R][C];
            max = -1;
            goods.clear();
            sc.nextLine();
            for(int rIdx = 0; rIdx < R; rIdx++) {
                String line = sc.nextLine();
                for(int cIdx = 0; cIdx < C; cIdx++) {
                    String location = line.substring(cIdx, cIdx+1);
                    board[rIdx][cIdx] = location;
                }
            }
            dfs(goods, 0, 0);
            System.out.printf("#%d %d\n", test_case, max);
		}
	}

    public static void dfs(Stack<String> goods, int r, int c) {
        String current = board[r][c];
        goods.add(current);
        isVisited[r][c] = true;

        for (int i=0; i<4; i++) {
            int row = r + dx[i];
            int col = c + dy[i];
            if (row < 0 || row >= R || col < 0 || col >= C) continue;
            if (!isVisited[row][col] && !goods.contains(board[row][col])) {
                dfs(goods, row, col);
            }
        }
        max = Math.max(max, goods.size());
        isVisited[r][c] = false;
        goods.pop();
    }
}