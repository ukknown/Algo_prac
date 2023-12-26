
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // st = new StringTokenizer(br.readLine());
        String s = br.readLine();


        Stack<Character> stack = new Stack<>();

        boolean flag = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '<'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                flag = true;
            }
            else if(s.charAt(i) == '>'){
                flag = false;
                sb.append(s.charAt(i));
                continue;
            }

            if(flag == true){
                sb.append(s.charAt(i));
            }else if(flag == false){
                if(s.charAt(i) == ' '){
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                }else{
                    stack.push(s.charAt(i));
                }
            }
            if(i == s.length() - 1){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }

            }


        System.out.println(sb);






    }


}
