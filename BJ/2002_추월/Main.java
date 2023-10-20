
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<String> in = new Stack<>();
        Stack<String> out = new Stack<>();

        for(int i = 0; i < (N*2); i++){
            if(i < N){
                in.add(br.readLine());
            }else{
                out.add(br.readLine());
            }
        }



        int result = 0;
        while(!in.isEmpty()){
            if(!in.get(0).equals(out.get(0)) ){ //stack[0]의 값 비교해서 다르면 추월
                result++;
            }
            in.remove(in.indexOf(out.get(0))); //터널 나온 차량 번호 in에서 제거
            out.remove(0);

        }


        System.out.println(result);
        
    }
}
