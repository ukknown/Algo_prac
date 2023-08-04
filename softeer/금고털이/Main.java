import java.util.*;
import java.io.*;


public class Main
{
    static class info implements Comparable<info>{
        int x;
        int y;

        public info(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(info o){
            return o.y - this.y;

        }
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<info> arr = new ArrayList<>();


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            
            int K = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            arr.add(new info(K,P));            
        }

        Collections.sort(arr);

        int price = 0;
        for(int i = 0; i < N; i++){
            if(W == 0){
                break;
            }else if(W >= arr.get(i).x){             
                W -= arr.get(i).x;
                price += (arr.get(i).x * arr.get(i).y);
            }else if(W < arr.get(i).x){
                price += (W * arr.get(i).y);
                W = 0;
            }          
        }

        System.out.println(price);       
    }
}
