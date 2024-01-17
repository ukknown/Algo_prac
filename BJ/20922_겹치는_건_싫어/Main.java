
import java.io.*;
import java.util.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] check = new int[100001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int result = 0;

        while(end < N){
            while(end < N && check[arr[end]]+ 1 <= K){
                check[arr[end++]]++;
            }
            int len = end - start;
            result = Math.max(result, len);

            check[arr[start++]]--;
        }

        System.out.println(result);




    }

}
