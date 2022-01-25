// 10866 덱
/*
ArrayDeque vs LinkedList
https://chucoding.tistory.com/52
*/
package baekjoon.StackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayDeque;
import java.util.Deque;
//import java.util.LinkedList;
import java.util.StringTokenizer;

public class BasicDeque {
    public static void main(String[] args) throws IOException{
        //Deque<Integer> dq=new LinkedList<>();
        Deque<Integer> dq=new ArrayDeque<Integer>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    System.out.println(dq.isEmpty() ? -1 : dq.pollFirst());
                    //dq.pop()
                    break;
                case "pop_back":
                    System.out.println(dq.isEmpty() ? -1 : dq.pollLast());
                    //dq.removeLast()
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    System.out.println(dq.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(dq.isEmpty() ? -1 : dq.peekFirst());
                    //dq.peek()
                    break;
                case "back":
                    System.out.println(dq.isEmpty() ? -1 : dq.peekLast());
                    break;
            }
        }
    }
}
