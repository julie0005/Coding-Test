package baekjoon.Basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * 28114 팀명정하기
 * nextInt 후에 nextLine이 위험함. 정수
 */
public class TeamName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Member> members = new ArrayList<>();
        String name1 = "";
        String name2 = "";

        for(int i=0; i<3; i++) {
            int problemCount = scanner.nextInt();
            int year = scanner.nextInt();
            String firstName = scanner.nextLine().trim();
            members.add(new Member(problemCount, year, firstName));
        }

        Collections.sort(members, (o1, o2) ->{return o1.remainder - o2.remainder;});

        for (int i=0; i<3; i++) {
            name1 += Integer.toString(members.get(i).remainder);
        }

        System.out.println(name1);

        Collections.sort(members, (m1, m2) -> {
            return m2.problemCount - m1.problemCount;
        });

        for (int i=0; i<3; i++) {
            name2 += members.get(i).firstName.substring(0, 1);
        }

        System.out.println(name2);

    }
}

class Member {
    int problemCount;
    int year;
    String firstName;
    int remainder;
    Member(int problemCount, int year, String firstName) {
        this.problemCount = problemCount;
        this.year = year;
        this.firstName = firstName;
        this.remainder = year % 100;
    }
}
