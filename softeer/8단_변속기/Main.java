import java.util.*;
import java.io.*;


public class Main
{
    static int[] gear;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        gear = new int[8];

        for(int i = 0; i < 8; i++){
            gear[i] = Integer.parseInt(st.nextToken());
        }


        if(check1()){
            System.out.println("ascending");
        }else if(check2()){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
       
    }
    public static boolean check1(){
        for(int i = 0; i < 7; i++){
            if(gear[i] > gear[i+1])return false;
        }
        return true;
    }
    public static boolean check2(){
        for(int i = 0; i < 7; i++){
            if(gear[i] < gear[i+1])return false;
        }
        return true;
    }
}
