import java.io.*;
import java.util.*;

public class Main {
    static int N,A,B,Ai,Bi,An,Bn, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Ai = Integer.parseInt(st.nextToken());
        Bi = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        An = Integer.parseInt(st.nextToken());
        Bn = Integer.parseInt(st.nextToken());

        int[] dpA = new int[N+1];
        int[] dpB = new int[N+1];

        dpA[1] = A;
        dpB[1] = B;

        for(int i = 2; i<= N; i++){
            if(i == N){
                dpA[i] = Math.min(dpA[i-1]+An, dpB[i-1]+Bi+An);
                dpB[i] = Math.min(dpB[i-1]+Bn, dpA[i-1]+Ai+Bn); 
            }else{
                dpA[i] = Math.min(dpA[i-1]+A, dpB[i-1]+Bi+A);
                dpB[i] = Math.min(dpB[i-1]+B, dpA[i-1]+Ai+B); 
            }
            
        }


        System.out.println(Math.min(dpA[N],dpB[N]));
        
        
    }

}
