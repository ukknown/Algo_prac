import java.io.*;
import java.util.*;
//실패
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] home = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            home[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(home);


        int result = 0;

        for(int i = 0; i < N; i++){
            int count = 0;
            if(home[i] > 1){
                for(int j = i; j < N; j++){
                    if(home[j]%home[i] == 0){
                        count++;
                    }
                }
                result = Math.max(result, count);
            }
            
        }
        
        System.out.println(result);
        
    }
}
