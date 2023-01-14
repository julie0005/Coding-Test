package baekjoon.Basic;

import java.util.*;

public class Statue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int statueCount = sc.nextInt();
        List<Integer> directionCounts = new ArrayList<>();

        int direction = -1;
        int count = 0;
        for (int i=0 ; i < statueCount ; i++) {
            int newDirection = sc.nextInt();
            if (newDirection == direction) {
                count++;
            }
            else {
                if(direction != -1) directionCounts.add(count);
                direction = newDirection;
                count = 1;
            }
        }
        directionCounts.add(count);
        int enlightment = 0;
        int max = 0;

        for (int i=0 ; i < directionCounts.size() ; i++) {
            for (int j=i; j < directionCounts.size() ; j++) {
                int leftCount = 0;
                int rightCount = 0;
                for (int idx = i ; idx <= j ; idx++) {
                    if (idx % 2 == 0) leftCount+= directionCounts.get(idx);
                    else rightCount += directionCounts.get(idx);
                }
                enlightment = Math.abs(leftCount - rightCount);
                max = Math.max(max, enlightment);
            }
        }
        System.out.println(max);
    }
}
