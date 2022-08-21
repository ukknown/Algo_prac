import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int w ,b;
	static int[][] arr;
	static void division(int x , int y, int size) {
		if(check(x, y, size)) {
			if(arr[x][y] == 0) {
				w += 1;
			}else {
				b += 1;
			}
			return;
		}
		
		division(x, y, size/2);
		division(x, y + size/2, size/2);
		division(x + size/2, y , size/2);
		division(x + size/2, y + size/2, size/2);
		
		
		
	}
	static boolean check(int x, int y, int size) {
		int color = arr[x][y];
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j <y +  size; j++) {
				if(arr[i][j] != color) {
					return false;
				}
			}
		}
		
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		w = 0;
		b = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		division(0,0,N);
		System.out.println(w);
		System.out.println(b);

	}

}
