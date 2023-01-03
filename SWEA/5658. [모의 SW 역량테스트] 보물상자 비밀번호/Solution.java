import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	static StringTokenizer st;
	static int N,K,turn, numberlength,password;
	static String[] number;
	static ArrayList<String> arr;
	static HashSet<String> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
					
			numberlength = N/4;
			number = new String[4]; 
			arr = new ArrayList<String>();
			set = new HashSet<String>();
			
			
			String str = bf.readLine();
			String[] s = str.split("");
			
			int index = 0;
			
			for(int i = 0; i < str.length(); i += numberlength) { //생성비밀번호들
				number[index++] = str.substring(i, i + numberlength);
			}
			
			for(int i = 0 ; i < N; i++) {//회전용
				arr.add(s[i]);
			}
			
			for(int i = 0 ; i < number.length; i++) {
				set.add(number[i]);
			}
			turn = 0;
			turning();
			
			cal();
	
			System.out.println("#"+ tc + " " +password);
		}
	}

	private static void cal() {
		ArrayList<String> list = new ArrayList<String>(set);
		
		Collections.sort(list);
		
		String result = list.get(list.size()-K);
		
		String[] re = result.split("");
		
		password = Integer.parseInt(result, 16);
		
		return;
		
	}

	private static void turning() {

		while(turn < 4) {

			String a = arr.get(arr.size()-1);
			arr.add(0, a);
			arr.remove(arr.size()-1);
			
			String sums = String.join("", arr);
		
			int index = 0;			
			for(int i = 0; i < sums.length(); i += numberlength) { //생성비밀번호들
				number[index++] = sums.substring(i, i + numberlength);
			}
			
			for(int i = 0; i < number.length; i++) {
				if( set.contains(number[i]) ) {
					turn += 1;
				}else {
					set.add(number[i]);
				}
			}			
		}
		return;
		
	}

}
