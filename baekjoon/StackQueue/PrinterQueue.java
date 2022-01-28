package baekjoon.StackQueue;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PrinterQueue {
    static class Document{
        int priority;
        int location;

        public Document(int priority, int location){
            this.priority=priority;
            this.location=location;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            String[] str=br.readLine().split(" ");
            int docNum=Integer.parseInt(str[0]);
            int location=Integer.parseInt(str[1]);

            String[] elemStr=br.readLine().split(" ");
            
            Queue<Document> waitQ=new LinkedList<Document>();
            int idx=0;
            int order=0;
            for(String elem : elemStr){
                waitQ.offer(new Document(Integer.parseInt(elem),idx++));
            }

            while(!waitQ.isEmpty()){
                Document top=waitQ.poll();
                boolean mostImportant=true;
                for(Document elem : waitQ){
                    if(top.priority<elem.priority){
                        waitQ.offer(top);
                        mostImportant=false;
                        break;
                    }
                }
                if(mostImportant){
                    order++;
                    if(top.location==location) {System.out.println(order); break;}
                }
            }
        }    
    }
}
