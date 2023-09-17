import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] num, cal;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //수의 개수
        num = new int[N]; //식의 개수
        cal = new int[4];  // +,-,*,/ 연산의 개수


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i ++){
            num[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            cal[i] = Integer.parseInt(st.nextToken());
        }


       dfs(num[0],1);

       System.out.println(max);
       System.out.println(min);



    }
    private static void dfs(int n, int idx){
        if(idx == N){
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }

        for(int i = 0; i < 4; i++){

            if(cal[i] > 0){ //연산자가 존재하면
                cal[i]--; //연산자 개수 감소

                switch(i){
                    case 0:
                        dfs(n + num[idx], idx+1);
                        break;
                    case 1:
                        dfs(n - num[idx], idx+1);
                        break;
                    case 2:

                        dfs(n * num[idx], idx+1);
                        break;
                    case 3:
                        dfs(n / num[idx], idx+1);
                        break;
                }

                cal[i]++; //연산 끝나면 연산자 수 복구
            }
        }


    }
}
