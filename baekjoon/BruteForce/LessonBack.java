package baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LessonBack {
	static int n, k, k1;
	static int answer = Integer.MIN_VALUE;
	static boolean[] check;
	static String[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //단어 개수
		k = Integer.parseInt(st.nextToken()); //가르침 가능한 글자 수
		k1 = k-5; //a n t i c 를 제외하고 가르칠수 있는 글자 수
		arr = new String[n]; //"anta"와 "tica"를 제외하고 입력받은 단어들.
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			str = str.substring(4, str.length()-4);
			arr[i] = str;
		}
		
		if(k1<0) {
			System.out.println(0);
			System.exit(0);
		}else if(k1>=21) {
			System.out.println(n);
			System.exit(0);
		}
		
		initCheck(); //방문배열 초기값 설정, a n t i c 방문처리.
		backTracking(1,0);
		System.out.println(answer);
		
	}
	
	public static void backTracking(int idx, int depth) {
		if(depth == k1) {
			countWords();
			return;
		}
		
		for(int i=idx; i<check.length; i++) {
			if(check[i]) continue;
			check[i] = true;
			backTracking(i, depth+1);
			check[i] = false;
		}
	}
	
	public static void countWords() {
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			int w = 0;
			char[] word = arr[i].toCharArray();
			for(int j=0; j<word.length; j++) {
				if(!check[word[j]-96]) {
					w = -1;
					break;
				}
			}
			
			if(w!=-1) cnt++;
		}
		
		answer = Math.max(answer, cnt);
	}
	
	public static void initCheck() {
		check = new boolean[27];
		check['a'-96] = true;
		check['n'-96] = true;
		check['t'-96] = true;
		check['i'-96] = true;
		check['c'-96] = true;
	}
}