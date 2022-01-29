package baekjoon.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

import java.util.Stack;

public class VirusStack {
    public static boolean[] visited=new boolean[105];
    public static int[][] graph=new int[101][101];
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        int edge=Integer.parseInt(br.readLine());
        int answer=0;
        StringTokenizer st=null;
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0; i<edge; i++){
            st=new StringTokenizer(br.readLine(), " ");
            int row=Integer.parseInt(st.nextToken());
            int col=Integer.parseInt(st.nextToken());
            graph[row][col]=1;
            graph[col][row]=1;
        }
        stack.push(1);
        visited[1]=true;
        while(!stack.isEmpty()){
            int top=stack.peek();
            boolean hasNeighbor=false;
            for(int i=1; i<=num; i++){
                if(!visited[i] && graph[top][i]==1){
                    stack.push(i);
                    visited[i]=true;
                    hasNeighbor=true;
                    answer++;
                    break;
                }
            }
            if(!hasNeighbor) stack.pop();
        }
        System.out.println(answer);
    }
    
}
