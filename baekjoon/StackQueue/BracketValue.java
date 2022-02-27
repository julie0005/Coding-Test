package baekjoon.StackQueue;
import java.io.*;
import java.util.*;
public class BracketValue {
    public static boolean isPossible(String curStr){
        if(curStr.equals("(")||curStr.equals(")")||curStr.equals("[")||curStr.equals("]")) return true;
        return false;
    }
    public static int strToVal(String bracket){
        if(bracket.equals("(") || bracket.equals(")")) return 2;
        else if(bracket.equals("[") || bracket.equals("]")) return 3;
        return -1;
    }

    public static boolean isCorrect(String cur, String prev){
        if(prev.equals("(") && cur.equals(")")) return true;
        if(prev.equals("[") && cur.equals("]")) return true;
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String seq=br.readLine();
        Stack<String> st=new Stack<String>();
        int curStatus=-1;
        int prevStatus=-1;
        int addVal=0;
        int curVal=0;
        // 0 : close
        // 1 : open
        for(int i=0; i<seq.length(); i++){
            prevStatus=curStatus;
            String curStr=seq.substring(i, i+1);
            if(!isPossible(curStr)){
                System.out.println(0);
                return;
            }
            if(curStr.equals("(")||curStr.equals("[")) curStatus=1;
            else curStatus=0;
            
            // open
            if(curStatus==1){
                st.push(curStr);
                if(prevStatus==0) addVal+=curVal;
                continue;
            }
            
            // close
            if(!st.isEmpty()){
                String prevStr=st.pop();
                if(prevStatus==1){
                    if(!isCorrect(curStr, prevStr)){
                        System.out.println(0);
                        return;
                    }
                    curVal=strToVal(curStr)+addVal;
                    addVal=0;
                }
                else if(prevStatus==0){
                    curVal=curVal*strToVal(curStr)+addVal;
                    addVal=0;
                }
            }
            else{
                System.out.println(0);
                return;
            }
            
        }

        if(!st.isEmpty()){
            System.out.println(0);
            return;
        }

        System.out.println(curVal+addVal);

    }
}
