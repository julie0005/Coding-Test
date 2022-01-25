//10828 스택
package baekjoon.StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class BasicStack {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack=new Stack<Integer>();
        int orderNumber=Integer.parseInt(br.readLine());
        StringTokenizer st=null;

        for(int i=0; i<orderNumber;i++){
            st=new StringTokenizer(br.readLine()," ");
            switch(st.nextToken()){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(!stack.isEmpty()?stack.pop():-1);
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(!stack.isEmpty()?0:1);
                    break;
                case "top":
                    System.out.println(!stack.isEmpty()?stack.peek():-1);
                    break;
                default:
                    System.out.println("유효하지 않은 입력입니다.");
            }
        }
    }
}