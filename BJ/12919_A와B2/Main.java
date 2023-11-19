
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer s = new StringBuffer(br.readLine());
        StringBuffer t = new StringBuffer(br.readLine());

        Queue<StringBuffer> que = new LinkedList<>();
        que.add(t);
        int flag = 0;

        while(!que.isEmpty()){
            StringBuffer q = que.poll();

            if(s.toString().equals(q.toString())){
                flag = 1;
                break;
            }

            if(q.length() > s.length()){
                StringBuffer t2 = new StringBuffer(q);
                if(q.toString().charAt(q.length()-1) == 'A'){
                    StringBuffer s2 = new StringBuffer(q.delete(q.length()-1,q.length()));
                    que.add(s2);
                }

                if(t2.reverse().toString().charAt(t2.length()-1) == 'B'){
                    que.add(t2.delete(t2.length()-1,t2.length()));
                }


            }


        }

        System.out.println(flag);




    }

}
