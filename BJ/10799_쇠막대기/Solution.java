import java.io.*;
public class BJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");

        int steel = 0; //추가할 절단한 철 갯수
        int result = 0; // 현재 절단한 철 갯수

        for(int i = 0; i< str.length; i++){
            if(i < str.length-1 && str[i].equals("(") && str[i+1].equals(")")){ // () = 레이저 부분 잘라진 철(steel)을 현재 절단한 철(result)에 추가
                result += steel;
                i += 1;
            }else if( str[i].equals("(") ){ // 자를 철의 시작 부분(추가할 철의 갯수) 
                steel += 1;
            }else if( str[i].equals(")") ){ // 철의 끝(철 하나 생성)
                steel -= 1;
                result += 1;
            }
        }

        System.out.print(result);

    }
}
