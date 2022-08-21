import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int w,b,r;
	static int[][] arr;
	static void division(int x, int y, int size) {
		if(check(x, y, size)) {
			if(arr[x][y] == -1) {
				w +=1;
			}
			else if(arr[x][y] == 0) {
				b += 1;
			}
			else{
				r += 1;
			}			
			return;
		}
		
		division(x, y, size/3);
		division(x, y + size/3, size/3);
		division(x, y + ((size/3) *2), size/3);
		
		division(x + size/3, y, size/3);
		division(x + size/3, y + size/3, size/3);
		division(x + size/3, y + ((size/3) *2), size/3);
		
		division(x + ((size/3)*2), y, size/3);
		division(x + ((size/3)*2), y + size/3, size/3);
		division(x + ((size/3)*2), y + ((size/3)*2), size/3);
		
	}
	static boolean check(int x, int y, int size) {
		
		int color = arr[x][y];
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(arr[i][j] != color){
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
		

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		division(0,0,N);
		System.out.println(w);
		System.out.println(b);
		System.out.println(r);
		
		

	}

}
