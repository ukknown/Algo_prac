import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int[] price;
	static int[] exer;
	static int T,min;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {		
			exer = new int[13];
			price = new int[4];
			//회원권 가격 입력
			st = new StringTokenizer(bf.readLine());
			for(int i = 0; i < price.length; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			//운동가는 날 입력
			st = new StringTokenizer(bf.readLine());
			for(int i = 1; i < 13; i++) {
				exer[i]= Integer.parseInt(st.nextToken());
			}
			//1년치=12개월 비용을 기본으로 가져간다(최솟값을 구하는 문제이기때문)
			min = price[3];
			
			check(1,0);
			
			System.out.print("#"+ tc +" ");
			System.out.println(min);
			
			
		}

	}

	private static void check(int month, int money) {
		
    //12개의 달을 모두 탐색했다면
		if(month>12) {
			min = Math.min(min, money);
			return;
		}
		
		
		if(exer[month] == 0) {
			check(month+1, money);
		}
		else {
      //일일권
			check(month + 1, money + exer[month] * price[0]);
			//1달권
			check(month + 1, money + price[1]);
			//3달권
			check(month + 3, money + price[2]);
		}
		
	}

}
