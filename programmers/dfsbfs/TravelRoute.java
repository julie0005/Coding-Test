package programmers.dfsbfs;
import java.util.*;
// Boolean[] 으로 하니 null pointer exception..
class TravelRoute {
    String[][] tickets;
    String[] answer={};
    boolean[] used;
    boolean dfs(Stack<String> st, int usedTickets){
        if(usedTickets==tickets.length){
            answer=new String[st.size()];
            int i=0;
            for(String str : st){
                answer[i++]=str;
            }
            
            return true;
        }
        String curLocation=st.peek();
        ArrayList<Ticket> candidate=new ArrayList<Ticket>();
        for(int i=0; i<tickets.length; i++){
            
            if(!used[i] && tickets[i][0].equals(curLocation)){
                candidate.add(new Ticket(tickets[i][0], tickets[i][1], i));
            }
            
        }
        
        Collections.sort(candidate, new Comparator<Ticket>(){
            @Override
            public int compare(Ticket t1, Ticket t2){
                return t1.end.compareTo(t2.end);
            }
        });
       
        for(Ticket t : candidate){
            st.push(t.end);
            used[t.ticketIdx]=true;
            
            if(dfs(st, usedTickets+1)) return true;
            
            st.pop();
            used[t.ticketIdx]=false;
        }
        
        return false;
        
    }
    
    public String[] solution(String[][] tickets) {
        this.tickets=tickets;
        used=new boolean[tickets.length];
        Stack<String> route=new Stack<String>();
        route.push("ICN");
        dfs(route,0);
        return answer;
    }
    
    class Ticket{
        String start;
        String end;
        int ticketIdx;
        Ticket(String start, String end, int ticketIdx){
            this.start=start;
            this.end=end;
            this.ticketIdx=ticketIdx;
        }
    }
}