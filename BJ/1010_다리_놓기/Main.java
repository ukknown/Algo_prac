
import java.util.*;
public class BJ1010 {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dp = new int[31][31];
        int T = sc.nextInt();

        for(int tc = 0; tc < T; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();


            int answer = comb(M,N);

            System.out.println(answer);

        }
    }
    private static int comb(int m,int n){ //조합
        if(dp[m][n]>0){ //계산된 값이 있으면 - 메모이제이션- 계산 속도 올리기 위해
            return dp[m][n];
        }else if(m == n || n == 0){ // nCn or nC0 = 1
            return dp[m][n] = 1;
        }else{
            return dp[m][n] = comb(m-1,n-1) + comb(m-1,n);
        }
    }
}
