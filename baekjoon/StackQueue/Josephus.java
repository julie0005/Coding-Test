//1158 요세푸스

package baekjoon.StackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
public class Josephus {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st=new StringTokenizer(br.readLine());

        // int num=Integer.parseInt(st.nextToken());
        // int targetIdx=Integer.parseInt(st.nextToken());

        String[] str=br.readLine().split(" ");
        int num=Integer.parseInt(str[0]);
        int target=Integer.parseInt(str[1]);
        ArrayList<String> output=new ArrayList<String>();

        Queue<String> q=new LinkedList<String>();
        for(int i=0 ; i<num; i++){
            q.add(Integer.toString(i+1));
        }
        while(!q.isEmpty()){
            for(int i=0; i<target-1; i++){
                q.add(q.poll());
            }
            output.add(q.poll());
        }

        StringBuilder outputStr=new StringBuilder("<");
        for(int i=0; i<output.size(); i++){
            String addStr=(i==0) ? output.get(i) : ", "+output.get(i);
            outputStr.append(addStr);
        }
        outputStr.append(">");
        System.out.println(outputStr);
    }
}
