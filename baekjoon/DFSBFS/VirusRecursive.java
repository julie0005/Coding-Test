package baekjoon.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class VirusRecursive {
    public static boolean[] visited=new boolean[105];
    public static int[][] graph=new int[101][101];
    public static int num;
    public static int infected=0;

    public static void dfs(int computer){
        visited[computer]=true;
        for(int i=1; i<=num; i++){
            if(!visited[i] && graph[computer][i]==1){
                infected++;
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        num=Integer.parseInt(br.readLine());
        int edge=Integer.parseInt(br.readLine());
        StringTokenizer st=null;
        //Arrays.fill(visited,false);
        for(int i=0; i<edge; i++){
            st=new StringTokenizer(br.readLine(), " ");
            int row=Integer.parseInt(st.nextToken());
            int col=Integer.parseInt(st.nextToken());
            graph[row][col]=1;
            graph[col][row]=1;
        }
        dfs(1);
        System.out.println(infected);
    }
    
}
