
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 1;

        while(true){
            String str = br.readLine();
            if(str.contains("-"))break;

            String[] s = str.split("");
            int count = 0;

            Stack<String> stack = new Stack<>();

            for(int i = 0; i < s.length; i++){
                if(s[i].equals("{")){
                    stack.push("{");
                }else{
                    if(!stack.empty()){
                        stack.pop();
                    }else{
                        stack.push("{");
                        count++;
                    }
                }
            }

            count += stack.size()/2;

            System.out.println(tc + "."+ " " + count);
            tc++;
        }


    }
}
