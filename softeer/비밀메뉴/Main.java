import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      String menu = "";
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < M; i++){
        menu += st.nextToken();
      }

      String order = "";
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++){
        order += st.nextToken();
      }

      if(order.contains(menu)){
        System.out.println("secret");
      }else{
        System.out.println("normal");
      }
  
    }
}
