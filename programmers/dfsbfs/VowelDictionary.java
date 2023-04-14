package programmers.dfsbfs;
/*
 * 프로그래머스 모음 사전
 */
import java.util.*;
class VowelDictionary {
    static List<String> list = new ArrayList<>();
    static String[] alphabets = {"A", "E", "I", "O", "U"};
    
    public void dfs(int depth, String str) {
        if (!str.equals("")) list.add(str);
        if (depth == 5) return;
        for (int i=0; i<alphabets.length; i++) {
            dfs(depth+1, str+alphabets[i]);
        }
    }
    public int solution(String word) {
        dfs(0, "");
        return list.indexOf(word)+1;
    }
}
