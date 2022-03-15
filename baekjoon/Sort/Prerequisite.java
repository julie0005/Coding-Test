package baekjoon.Sort;
/*
14567 선수과목
1. 인접리스트로 그래프 표현
2. 인접리스트 탐색
3. 위상정렬 이용
- 진입차수 배열 이용하여 진입차수 0인 것 매번 탐색하지 않게 하기.
- 큐가 빌 때까지 간선제거를 반복함으로써 단계 값 조절.
- 인접리스트를 탐색하는 것은 비효율적. 인덱스와 연결된 값만 찾는 것으로 활용.
*/
import java.util.*;
import java.io.*;
public class Prerequisite {
    static ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
    static int[] degree_in;

    static String topologicalSort(int N){
        Queue<Integer> q=new LinkedList<>();
        int answer[]=new int[N];
        int depth=0;
        boolean visited[]=new boolean[N];
        while(true){
            if(q.isEmpty()){
                depth++;
                for(int i=0; i<N; i++){
                    if(!visited[i] && degree_in[i]==0){
                        q.offer(i);
                        answer[i]=depth;
                        visited[i]=true;
                    }
                }
                if(q.isEmpty()) break;
            }
            int front=q.poll();
            for(int behind : graph.get(front)) degree_in[behind]--;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(answer[i]+" ");
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }
        degree_in=new int[N];
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int front=Integer.parseInt(st.nextToken())-1;
            int behind=Integer.parseInt(st.nextToken())-1;
            graph.get(front).add(behind);
            degree_in[behind]++;
        }
        System.out.println(topologicalSort(N));
    }
}
