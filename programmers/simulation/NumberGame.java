/* 숫자 게임*/
package programmers.simulation;
import java.util.*;
public class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int aP=A.length-1; //A Pointer
        int bP=B.length-1; //B Pointer
        while(aP>=0 && bP>=0){
            if(B[bP]>A[aP]){
                answer++;
                bP--;
                aP--;
            }
            else{
                aP--;
            }
        }
        return answer;
    }
}
