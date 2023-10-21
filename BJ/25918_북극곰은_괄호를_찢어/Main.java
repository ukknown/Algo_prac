
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split("");

        int day = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < str.length; i++){
            if(str[i].equals("(")){
                day++;
            }else{
                day--;
            }
            result = Math.max(result, Math.abs(day));
        }

        if(day == 0){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }

    }
}
