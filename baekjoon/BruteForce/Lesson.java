package baekjoon.BruteForce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
/* 1062 가르침 */
/*
ArrayList 합집합 : 알파벳의 우선순위, 겹치는 정도가 작을수록 우선순위 높음
단어 개수의 최댓값 : 최대가 되는 경우를 내가 생각해야 하는걸까, k개 글자를 뽑는 경우를 완전탐색?
N개 중에 M개의 모든 조합을 찾는 알고리즘!
* 비트마스크
* m개 중에서 n개 완전탐색 하는 법 : 재귀함수로.
* for문과 재귀함수를 구성하는 방식에 따라 bruteforce가 될 수도 있고, backtracking이 될 수도 있다.
*/
public class Lesson {
    static String[] words;
    static int N,K;
    static ArrayList<AlphaInfo> alphaCnt=new ArrayList<AlphaInfo>();
    static int max=0;
    static void pick(int n, ArrayList<Integer> picked, int toPick){
        if(toPick==0){
            //판단
            String chars="antic";
            for(int i=0; i<picked.size(); i++){
                chars+=Character.toString(alphaCnt.get(picked.get(i)).alpha);
            }
            int readable=N;
            for(int i=0; i<N; i++){
                for(int j=4; j<words[i].length()-4; j++){
                    if(!chars.contains(words[i].substring(j, j+1))){
                        readable--;
                        break;
                    }
                }
            }            
            if(max<readable)  max=readable;
            return;
        }
        int smallest=picked.isEmpty() ? 5 : picked.get(picked.size()-1)+1;
        for(int next=smallest; next<n;next++){
            picked.add(next);
            pick(n,picked, toPick-1);
            picked.remove(picked.size()-1);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        words=new String[N];
        for(int i=0; i<N; i++){
            String word=br.readLine();
            words[i]=word;
        }
        for(char c='a'; c<='z'; c++){
            alphaCnt.add(new AlphaInfo(c,0));
        }
        if(K<5){
            System.out.println(0);
            return;
        }
        int num=0;
        boolean find;
        for(int i=0; i<26; i++){
            char c=(char)('a'+i);
            find=false;
            for(int j=0; j<N; j++){
                if(words[j].contains(Character.toString(c))){
                    alphaCnt.get(i).frequency++;
                    find=true;
                }
            }
            if(find) num++;
        }
        if(num<=K){
            System.out.println(N);
            return;
        }
        Collections.sort(alphaCnt);
        ArrayList<Integer> picked=new ArrayList<Integer>();
        pick(num, picked, K-5);
        System.out.println(max);
    }

    
}
class AlphaInfo implements Comparable<AlphaInfo>{
    char alpha;
    int frequency=0;
    AlphaInfo(char alpha, int freq){
        this.alpha=alpha;
        this.frequency=freq;
    }
    @Override
    public int compareTo(AlphaInfo a){
        return a.frequency-this.frequency;
    }
}