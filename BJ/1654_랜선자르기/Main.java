
import java.io.*;
import java.util.*;
public class Main {
    static int K, N;
    static long max;
    static long[] line;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        line = new long[K];

        for(int i = 0; i < K; i++){
            line[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(line);

        long result = search(line[K-1]);

        System.out.println(result);


    }
    private static long search(long num){
        long left = 1;
        long right = num;

        while(left <= right){
            long mid = (left+right)/2;
            long sum = 0;

            for(int i = 0; i < K; i++){
                sum += line[i]/mid;
            }

            if(sum < N){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }


        return (right+left)/2;
    }
}
