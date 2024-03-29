package programmers.dfsbfs;
class Network {
    public static boolean[] visited=new boolean[205]; // boolean 배열 기본 초기값은 false
    public static int[][] graph;
    public static void dfs(int start){
        visited[start]=true;
        for(int i=0; i<graph[0].length; i++){
            if(!visited[i] && graph[start][i]==1) dfs(i);
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph=computers;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}