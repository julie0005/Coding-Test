package baekjoon.StackQueue;
import java.util.*;
import java.io.*;
/*
2540 괄호의 값
아이디어
1.괄호를 열 때 연산하기 / 괄호를 닫을 때 연산하기
2. 스택에 숫자와 문자 같이 둘 수 있다는 발상
3. 어느 지점까지는 연산, 어느 지점에서는 멈춰보기
*/

public class BracketValue{
    public static boolean isVPS(String c, String target){
        if(c.equals(target)) return true;
        return false;
    }
    public static boolean isNumber(String str){
        if(str.equals(")") || str.equals("]")) return false;
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        Stack<String> stack=new Stack<String>();
        boolean isAble=true;

        for(int i=0; i<str.length();i++){
            String c=str.substring(i,i+1);
            if("(".equals(c)){
                stack.push(")");
                continue;
            }
            if("[".equals(c)){
                stack.push("]");
                continue;
            }
            int num=0;
            while(true){
                if(stack.isEmpty()){
                    isAble=false;
                    break;
                }
                if(isNumber(stack.peek())){
                    num+=Integer.parseInt(stack.pop());
                }
                else{
                    if(isVPS(c, stack.peek())){
                        stack.pop();
                        int t=(")".equals(c)) ? 2 : 3;
                        if(num==0) stack.push(String.valueOf(t));
                        else stack.push(String.valueOf(t*num));
                        break;
                    }
                    else isAble=false;
                    break;
                }
            }
            if(!isAble) break;
        }
        int result=0;
            while(!stack.isEmpty()){
                if(isNumber(stack.peek())){
                    result+=Integer.parseInt(stack.pop());
                }else{
                    isAble=false;
                    break;
                }
            }
            if(isAble) System.out.println(result);
            else System.out.println(0);
    } 

}