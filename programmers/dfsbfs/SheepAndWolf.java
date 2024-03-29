package programmers.dfsbfs;
class SheepAndWolf {
    static boolean[][] map;
    
    static int[] node;
    
    static int max = 0;
    
    public void dfs(int curNode, int wolf, int sheep, boolean[] visited) {
        if(node[curNode] == 0) {sheep++;}
        else wolf++;
        if(sheep <= wolf) {
            return;
        }
        max = Math.max(max, sheep);
        
        boolean[] newVisited = visited.clone();
        newVisited[curNode] = true;
        
        for(int i=0; i<newVisited.length; i++) {
            if(newVisited[i]) {
                for(int j=0; j<map[i].length; j++) {
                    if(map[i][j] == true && !newVisited[j]) {
                        dfs(j, wolf, sheep, newVisited);
                    }
                }
            }
        }
        
    }
    
    public int solution(int[] info, int[][] edges) {
        node = info;
        boolean[] visited = new boolean[info.length];
        map = new boolean[info.length][info.length];
        for(int i=0; i<edges.length; i++) {
            map[edges[i][0]][edges[i][1]] = true;
        }
        dfs(0, 0, 0, visited);
        return max;
    }
}