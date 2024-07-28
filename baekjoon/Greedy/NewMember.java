package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NewMember {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0 ; i < t ; i++) {
            List<Member> members = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                members.add(new Member(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(members,(m1, m2) -> m1.resume - m2.resume);
            int max = members.get(0).interview;
            int answer = 1;
            for (int j = 1; j < members.size(); j++) {
                if (members.get(j).interview < max) {
                    answer++;
                    max = members.get(j).interview;
                }
            }
            System.out.println(answer);
        }
    }
    
}

class Member {
    int resume;
    int interview;
    Member(int resume, int interview) {
        this.resume = resume;
        this.interview = interview;
    }
}
