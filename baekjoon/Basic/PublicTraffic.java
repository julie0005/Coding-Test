package baekjoon.Basic;

import java.util.*;
public class PublicTraffic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subwayWalk = sc.nextInt();
        int busWait = sc.nextInt();
        int subwayWait = sc.nextInt();
    

        if (subwayWalk > subwayWait || busWait < subwayWait) System.out.println("Bus");
        else if (busWait > subwayWait) System.out.println("Subway");
        else if (busWait == subwayWait) System.out.println("Anything");
    }
}
