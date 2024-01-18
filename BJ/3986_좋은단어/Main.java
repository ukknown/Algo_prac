
import java.io.*;
import java.util.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for(int tc = 0; tc < N; tc++){
            String s = br.readLine();

            if(s.length()%2 == 1){
                continue;
            }

            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(0));
            for(int i = 1; i < s.length(); i++){
                if(stack.size() > 0 && stack.peek() == s.charAt(i)){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
            if(stack.isEmpty()){
                count++;
            }
        }

        System.out.println(count);



    }

}
