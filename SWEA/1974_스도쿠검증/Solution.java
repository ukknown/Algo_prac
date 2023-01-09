import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();//테스트케이스 입력		
		
		for(int tc =1; tc<=T; tc++) {
			int[][] arr = new int[9][9];//배열 크기 지정
			boolean check = true;
			
			for(int i = 0; i < arr.length; i++) {//스도쿠 값 입력
				for(int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < arr.length; i++) {//배열 행 열 값 스도쿠 조건 검증
				int row = 0;
				int column = 0;
				for(int j = 0; j < arr.length; j++) {
					row += arr[i][j];
					column += arr[j][i];
				}
				if(row != 45 || column != 45) {
					check = false;
					break;
					}
				System.out.println(" row,colum " + check);
					
				}
			
			for(int i = 0; i < arr.length; i += 3) {//3x3스도쿠 검증
				for(int j = 0; j < arr.length; j += 3) {
					int square = 0;
					for(int r = 0; r < 3; r++) {
						for(int c = 0; c < 3; c++) {
							square += arr[i+r][j+c];
						}
						
					}
					if(square != 45) {
						check = false;
						break;
					}
					System.out.println(" square " + check);
					
					
				}
			}
			if(check == true) {
				System.out.println("#"+ tc + " " + "1");
			}
			else {
				System.out.println("#"+ tc + " "+ "0");
			}
			
			
													
		}
	}
}

	


