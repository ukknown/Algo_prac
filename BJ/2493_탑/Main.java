
import java.io.*;
import java.util.*;
class info{
    int loc;
    int height;
    public info(int loc, int height){
        this.loc = loc;
        this.height = height;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack<info> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int h = Integer.parseInt(st.nextToken());
            if(stack.empty()){ //스택이 비어있으면 레이저 받을 곳 없음 = 0
                sb.append(0 + " ");
                stack.push(new info(i, h)); //현재 레이저 위치와 높이 stack 저장
            }else{
                while(true){
                    if(stack.empty()){ //스택이 비어있으면 레이저 받을 곳 없음 = 0
                        sb.append(0 + " ");
                        stack.push(new info(i, h)); //현재 레이저 위치와 높이 stack 저장
                        break;
                    }

                    info in = stack.peek(); //스택 가장 윗 값 확인

                    if(in.height > h){ //윗 값이 현재 레이저 높이 높으면 레이저 닿는 곳
                        sb.append(in.loc + " "); //레이저 위치 추가
                        stack.push(new info(i, h)); //현재 레이저 위치 추가
                        break;
                    }else{ //윗 값이 현재 레이저 높이보다 낮으면 레이저 안닿는 곳
                        stack.pop(); // 윗 값 레이저 정보 제거
                    }
                }
            }
        }

        System.out.println(sb);


    }
}
