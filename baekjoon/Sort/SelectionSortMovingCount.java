package baekjoon.Sort;
import java.text.SimpleDateFormat;
import java.util.*;
/*
 * 28116 선택정렬 이동거리
 */ 
public class SelectionSortMovingCount {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        // Scanner sc = new Scanner(System.in);
        // int N = sc.nextInt();
        // int[] sequence = new int[N];
        // int[] movingSequence = new int[N];
        // for (int i=0; i<N; i++) {
        //     sequence[i] = sc.nextInt();
        // }
        // selectionSort(sequence, movingSequence);
        // for (int i=0; i<N; i++) {
        //     if (i==N-1) System.out.println(movingSequence[i]);
        //     else System.out.print(movingSequence[i]+" ");
        // }
    }

    static void selectionSort(int[] sequence, int[] movingSequence) {

        for(int i=0; i<sequence.length - 1; i++) {
            int min = sequence[i];
            int minIdx = i;
            for (int j = i; j < sequence.length; j++) {
               if (min > sequence[j]) {
                min = sequence[j];
                minIdx = j;
               }
            }
            if (sequence[i] != min) {
                movingSequence[i] += minIdx-i;
                movingSequence[sequence[i]-1] += minIdx-i;
                int temp = min;
                sequence[minIdx] = sequence[i];
                sequence[i] = temp;
            }
        }
    }
}
