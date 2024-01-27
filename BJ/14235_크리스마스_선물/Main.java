import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int n = Integer.parseInt(br.readLine());

       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int tc = 0; tc < n; tc++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());

           if(a == 0){
               if(pq.isEmpty()){
                   System.out.println(-1);
               }else{
                   System.out.println(pq.poll());
               }
           }else{
               for(int i = 0; i < a; i++){
                   pq.add(Integer.parseInt(st.nextToken()));
               }
           }
           
       }

    }




}
