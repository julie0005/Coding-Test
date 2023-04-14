package programmers.dfsbfs;

class Fatique {
    static boolean[] visited = new boolean[8];
    static int[][] dungeonGraph;
    static int answer = 0;
    public void dfs(int depth, int k) {
        for (int i=0; i<dungeonGraph.length; i++) {
            if (!visited[i] && dungeonGraph[i][0] <= k) {
                visited[i] = true;
                dfs(depth+1, k-dungeonGraph[i][1]);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
    public int solution(int k, int[][] dungeons) {
        dungeonGraph = dungeons;
        dfs(0, k);
        return answer;
    }
}
