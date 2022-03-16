package baekjoon.Sort;
import java.util.*;
import java.io.*;
public class Line {
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] degree_in;
    public static ArrayList<Integer> answers=new ArrayList<Integer>();
    public static boolean[] selected;
    public static void topologicalSort(){
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<degree_in.length; i++){
            if(degree_in[i]==0){
                q.offer(i);
                selected[i]=true;
            }
        }
        while(!q.isEmpty()){
            int student=q.poll();
            //System.out.println("selected student : "+student);
            answers.add(student);
            for(int out : graph.get(student)){
                //System.out.println(out);
                degree_in[out]--;
            }
            for(int i=0; i<degree_in.length; i++){
                if(!selected[i] && degree_in[i]==0){
                    q.offer(i);
                    selected[i]=true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        degree_in=new int[N];
        selected=new boolean[N];
        graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken())-1;
            int sec=Integer.parseInt(st.nextToken())-1;
            graph.get(first).add(sec);
            degree_in[sec]++;
        }
        topologicalSort();
        int[] answerArr=answers.stream().mapToInt(i->i+1).toArray();
        for(int i=0; i<answerArr.length; i++){
            if(i!=0) System.out.print(" ");
            System.out.print(answerArr[i]);
        }

    }
}
