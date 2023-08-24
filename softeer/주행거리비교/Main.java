import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());


        int result = A-B;
        if(result > 0){
            System.out.println("A");
        }else if(result == 0){
            System.out.println("same");
        }else{
            System.out.println("B");
        }



        
    }
}
