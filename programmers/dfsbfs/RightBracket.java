package programmers.dfsbfs;
import java.util.*;
class RightBracket{
    class P{
        int open, close;
        P(int open, int close){
            this.open=open;
            this.close=close;
        }
    }

    public int solution(int n){
        int answer=0;
        Stack<P> st=new Stack<>();
        st.push(new P(0,0));
        while(!st.isEmpty()){
            P p=st.pop();
            if(p.open>n) continue;
            if(p.open<p.close) continue;
            if(p.open+p.close==2*n){
                answer++;
                continue;
            }
            st.push(new P(p.open+1, p.close));
            st.push(new P(p.open, p.close+1));
        }
        return answer;
    }
}