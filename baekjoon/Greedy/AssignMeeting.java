package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class AssignMeeting {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int meetingNum = Integer.parseInt(st.nextToken());
        List<Meeting> meetingList = new ArrayList<>();

        for (int i=0; i<meetingNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetingList.add(new Meeting(start, end));
        }

        Collections.sort(meetingList, (m1, m2) -> {
            return m1.end != m2.end ? m1.end - m2.end : m1.start - m2.start;
        });

        int num = 1;
        Meeting peek = meetingList.get(0);
        for (int i=1; i<meetingList.size(); i++) {
            Meeting current = meetingList.get(i);
            if (current.start < peek.end) continue;
            else {
                peek = current;
                num ++;
            }
        }
        System.out.println(num);
    }
    
}

class Meeting {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
