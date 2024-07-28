package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class AssignClass {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int classNum = Integer.parseInt(st.nextToken());
        List<Class> classList = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i=0; i<classNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classList.add(new Class(start, end));
        }
        Collections.sort(classList, (c1, c2) -> c1.start - c2.start);
        
        for(Class aClass : classList) {
            if (queue.isEmpty()) {
                queue.add(aClass.end);
                continue;
            }
            int end = queue.peek();
            if (aClass.start < end) {
                queue.add(aClass.end);
            }
            else {
                queue.poll();
                queue.add(aClass.end);
            }
        }

        System.out.println(queue.size());

    }
    
}

class Class {
    int start;
    int end;
    public Class (int start, int end) {
        this.start = start;
        this.end = end;
    }
}
