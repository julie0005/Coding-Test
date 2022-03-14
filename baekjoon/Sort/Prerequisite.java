package baekjoon.Sort;
/*
14567 선수과목
1. 인접리스트로 그래프 표현
2. 인접리스트 탐색
*/
import java.util.*;
import java.io.*;
public class Prerequisite {
    public static ArrayList<ArrayList<Integer>> graph;
    public static int N,M;
    public static int[] answer;
    public static boolean[] visited;
    public static void search(int target, int depth, int firstTarget){
        boolean hasInput=false;
        if(depth==1) firstTarget=target;
        for(int i=1; i<=N; i++){
            for(int temp : graph.get(i)){
                
                if(temp==target && !visited[temp]){
                    //System.out.println("target : "+target+", temp : "+temp+", i : "+i+", depth : "+depth);
                    hasInput=true;
                    visited[temp]=true;
                    search(i, depth+1, firstTarget);
                }
            }
        }
        if(!hasInput){
            answer[firstTarget]=Math.max(answer[firstTarget],depth);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        graph=new ArrayList<ArrayList<Integer>>();
        answer=new int[N+1];
        visited=new boolean[N+1];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int front=Integer.parseInt(st.nextToken());
            int behind=Integer.parseInt(st.nextToken());
            graph.get(front).add(behind);
        }
        //탐색
        for(int i=1; i<=N; i++){
            Arrays.fill(visited,false);
            search(i,1,i);
            System.out.print(answer[i]);
            if(i!=N) System.out.print(" ");
        }
    }
}
