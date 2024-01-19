
import java.io.*;
import java.util.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        int day = 0;

        stack.add(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            day = Math.max(day, stack.size());

            if(stack.isEmpty()){
                stack.add(s.charAt(i));
            }else if(stack.peek() == s.charAt(i)){
                stack.add(s.charAt(i));
            }else{
                stack.pop();
            }

        }

        if(!stack.isEmpty()){
            day = -1;
        }

        System.out.println(day);


    }

}
