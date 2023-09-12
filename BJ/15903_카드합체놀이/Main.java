import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] card = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            card[i] = Long.parseLong(st.nextToken());
        }


        for(int i = 0; i < m; i++){
            Arrays.sort(card);
            long sum = card[0] + card[1];
            card[0] = card[1] = sum;
        }

        long result = 0;
        for(int i = 0; i < n; i++){
            result += card[i];
        }

        System.out.println(result);
    }
}
