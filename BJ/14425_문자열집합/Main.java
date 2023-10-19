import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        List<String> str = new ArrayList<>();

        for(int i = 0; i < N; i++){
            str.add(br.readLine());
        }

        int count = 0;
        for(int i = 0 ; i < M; i++){
            String s = br.readLine();
            if(str.contains(s)){
                count++;
            }

        }

        System.out.println(count);

    }
}
