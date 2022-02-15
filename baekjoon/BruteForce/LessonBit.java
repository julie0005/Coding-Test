package baekjoon.BruteForce;

import java.util.*;
import java.io.*;

public class LessonBit {
    static FastScanner fs = new FastScanner();
    static PrintWriter pw = new PrintWriter(System.out);
    static int n, k, ans = 0;
    static int[] strs;
    // 각 단어에 a~z 포함 여부를 비트마스킹된 int로 저장
    static int check = 0;
    // 가르친 문자에 대해 비트마스킹

    public static void main(String[] args) {
        n = fs.nextInt();
        k = fs.nextInt();
        strs = new int[n];

        for (int i=0;i<n;i++){
            String str = fs.next();
            for (char c : str.toCharArray()){
                strs[i] |= (1 << (c - 'a'));
            }
        }

        if (k < 5) pw.println(0);
        else if (k >= 26) pw.println(n);
        else{
            check |= (1 << ('a' - 'a'));
            check |= (1 << ('n' - 'a'));
            check |= (1 << ('t' - 'a'));
            check |= (1 << ('i' - 'a'));
            check |= (1 << ('c' - 'a'));

            solve(0, 5);
            pw.println(ans);
        }
        pw.close();
    }

    static void solve(int ptr, int cnt){
        if (cnt == k){
            int temp = 0;
            for (int str : strs) if ((str & check) == str) temp++;
            ans = Math.max(ans, temp);
            return;
        }

        if (ptr >= 26) return;
        if ((check & (1 << ptr)) == 0){
            check |= (1 << ptr);
            solve(ptr + 1, cnt + 1);
            check &= ~(1 << ptr);
        }
        solve(ptr + 1, cnt);
    }

    // ----------input function----------

    static void sort(int[] a) {
        ArrayList<Integer> L = new ArrayList<>();
        for (int i : a)
            L.add(i);
        Collections.sort(L);
        for (int i = 0; i < a.length; i++)
            a[i] = L.get(i);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
