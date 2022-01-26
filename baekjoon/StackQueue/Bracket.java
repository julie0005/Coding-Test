// 9012 괄호
package baekjoon.StackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Bracket {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            System.out.println(isVPS(br.readLine()));
        }
    }

    private static String isVPS(String str){
        Stack<Character> stack=new Stack<Character>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(') stack.push(str.charAt(i));
            else{
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
}
