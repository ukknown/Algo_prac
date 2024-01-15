
import java.io.*;
import java.util.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N; i++){
            int input = Integer.parseInt(st.nextToken());

            if(map.get(input) == null){
                map.put(input,1);
            }else{
                map.put(input, map.get(input) + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < M; i++){
            int input = Integer.parseInt(st.nextToken());

            if(map.get(input) == null){
                sb.append(0).append(" ");
            }else{
                sb.append(map.get(input)).append(" ");
            }
        }

        System.out.println(sb);

    }

}
