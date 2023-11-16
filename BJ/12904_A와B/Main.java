import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st =  new StringTokenizer(br.readLine());

        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());


        int flag = 0;
      //t의 글자를 제거해나가면서 s가 되는 지 확인
        while(t.length() > s.length()){
            if(t.charAt(t.length()-1) == 'A'){ 
                t.delete(t.length()-1, t.length());
            }else{
                t.delete(t.length()-1, t.length());
                t.reverse();
            }

            if(t.length() == s.length()){
                if(t.toString().equals(s.toString())){
                    flag = 1;
                    break;
                }
            }

        }
        System.out.println(flag);
    }
}
