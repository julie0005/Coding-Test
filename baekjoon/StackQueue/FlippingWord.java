/*
9093 단어뒤집기
1. 출력문자열을 만들어서 한꺼번에 출력하려 하면 메모리 초과. 출력 문자열 메모리 추가적으로 필요하기 때문.
2. character 단위로 뒤집어서 하는 것보다 stringBuffer reverse 쓰는게 메모리 두배 차이났음.
- 추측하건대, character는 추가적으로 string을 선언하기 때문. sb는 자체적으로 delete해서 삭제함.
*/

package baekjoon.StackQueue;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FlippingWord {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<testCase; i++){
            String[] str=br.readLine().split(" ");
            for(int j=0; j<str.length; j++){
                sb.delete(0, sb.length());
                sb.append(str[j]);
                if(j==0) System.out.print(sb.reverse().toString());
                else System.out.print(" "+sb.reverse().toString());
            }
            System.out.print("\n");
        }
    }
}

// for(int i=0; i<testCase; i++){
//     String[] str=br.readLine().split(" ");
//     for(int j=0; j<str.length; j++){
//         String reverse="";
//         for(int k=str[j].length()-1; k>=0; k--){
//             reverse+=str[j].charAt(k);
//         }
//         if(j==0) System.out.print(reverse);
//         else System.out.print(" "+reverse);
//     }
//     System.out.print("\n");
// }
