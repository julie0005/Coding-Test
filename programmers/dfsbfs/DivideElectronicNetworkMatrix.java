package programmers.dfsbfs;

import java.util.*;
class DivideElectronicNetworkMatrix {
    int[][] graph;
    int searched = 0;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
       graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        int diff = Integer.MAX_VALUE;
        for (int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        for (int i=0; i<wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            searched = 0;
            
            // 끊기
            graph[v1][v2] = 0;
            graph[v2][v1] = 0;
            
            // dfs
            dfs(v1);
            
            // 차이 갱신
            diff = Math.min(diff, Math.abs(searched - (n - searched)));
            
            // 다시 잇기
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        
        return diff;
    }
    
    void dfs(int v) {
        visited[v] = true;
        searched++;
        
        for(int i=0; i<graph[v].length; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
        visited[v] = false;
    }

    
}
