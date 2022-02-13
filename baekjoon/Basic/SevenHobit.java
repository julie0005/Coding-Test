package baekjoon.Basic;
/*2309 일곱 난쟁이*/
import java.io.*;
import java.util.*;

public class SevenHobit {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> height=new ArrayList<Integer>();
        int total=0;
        for(int i=0; i<9; i++){
            height.add(Integer.parseInt(br.readLine()));
            total+=height.get(i);
        }
        int diff=total-100;
        boolean find=false;
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(height.get(i)+height.get(j)==diff){
                    height.remove(j);
                    height.remove(i);
                    //뒤에서부터 제거해야 앞 인덱스 영향 받지 않아.
                    find=true;
                    break;
                }
            }
            if(find) break;
        }
        Collections.sort(height);
        for(int i=0; i<7; i++){
            System.out.println(height.get(i));
        }
    }
}
