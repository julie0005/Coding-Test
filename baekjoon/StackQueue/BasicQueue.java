//10845 큐
package baekjoon.StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BasicQueue {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q=new LinkedList<Integer>();
        int back=0;
        int num=Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    int currentNum=Integer.parseInt(st.nextToken());
                    q.add(currentNum);
                    back=currentNum;
                    break;
                case "pop":
                    System.out.println(q.isEmpty() ? -1 : q.poll());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    System.out.println(q.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(q.isEmpty() ? -1 : q.peek());
                    break;
                case "back":
                    System.out.println(q.isEmpty() ? -1 : back);
                    break;
            }

        }
    }
}
