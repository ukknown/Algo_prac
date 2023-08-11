import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //회원 수
        int M = Integer.parseInt(st.nextToken()); //지인 관계 

        int[] Member = new int[N+1];
        int[] check = new int[N+1];

        for(int i = 1; i <= N; i++){
            check[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            Member[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(Member[A] < Member[B]){
                check[A] = 0;
            }else if(Member[A] == Member[B]){
                check[A] = 0;
                check[B] = 0;
            }else{
                check[B] = 0;
            }
        }

        int count = 0;

        for(int i = 1; i <= N; i++){
            if(check[i] != 0){
                count++;
            }
        }

        System.out.println(count);




        
    }
}
