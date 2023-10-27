
import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] card;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        int  M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());

            if(search(num)){
                sb.append(1+" ");
            }else{
                sb.append(0+" ");
            }
        }

        System.out.println(sb);

    }
    private static boolean search(int num){
        int left = 0;
        int right = N-1;

        while(left <= right){
            int midIdx = (left+right)/2;
            int mid = card[midIdx];

            if(num < mid){
                right = midIdx-1;
            }else if(num > mid){
                left = midIdx+1;
            }else{
                return true;
            }
        }
        return false;
    }
}
