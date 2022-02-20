package programmers.sort;

import java.util.*;
class BigNum {
    public String solution(int[] numbers) {
        String[] strs=new String[numbers.length];
        String answer = "";
        for(int i=0; i<numbers.length; i++){
            strs[i]=Integer.toString(numbers[i]);
        }
        Arrays.sort(strs,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String s1s2=s1+s2;
                String s2s1=s2+s1;
                int diff=Integer.parseInt(s1s2)-Integer.parseInt(s2s1);
                if(diff>0) return -1;
                else if(diff<0) return 1;
                return 0;
            }
        });
        for(int i=0; i<strs.length; i++){
            answer+=strs[i];
        }
        return answer;
    }
}