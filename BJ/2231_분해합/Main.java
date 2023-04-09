
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			int num = i;
			int sum = 0;
			
			while(num != 0) { //각자리 수 합
				sum += num % 10;
				num /= 10;
			}
			
			if(sum + i == N) { //분해합 값이 
				result = i;
				break;
			}
			
		}
		
		System.out.println(result);

	}

}
