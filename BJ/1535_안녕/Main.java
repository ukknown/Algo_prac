
import java.util.*;
public class Main {
    static int N,hp,result;
    static int[] DOWN, GOOD;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        hp = 100;
        result = 0;
        DOWN = new int[N];
        GOOD = new int[N];

        for(int i = 0; i < N; i++){
            DOWN[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++){
            GOOD[i] = sc.nextInt();
        }


        dfs(0,0,0);
        System.out.println(result);

    }
    private static void dfs(int cur, int dep, int sum){
        if(dep >= hp){
            sum -= GOOD[cur-1];
            result = Math.max(result, sum);
            return;
        }

        if(cur >= N){
            result = Math.max(result, sum);
            return;
        }

        for(int i = cur; i < N; i++){
            dfs(i+1, dep+DOWN[i], sum+GOOD[i]);
        }
    }
}
