import java.io.*;
import java.util.*;
public class BJ4659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String password = br.readLine().trim();

            if(password.equals("end"))break;

            String[] p = password.split("");

            List<String> str = new ArrayList<>(Arrays.asList(p));
            int vowel = 0; //연속 모음 개수
            int consonant = 0; //연속 자음 개수
            if(str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u")){
                boolean flag = true;
                for(int i = 0; i < p.length; i++){
                    if(p[i].equals("a") || p[i].equals("e") || p[i].equals("i") || p[i].equals("o") || p[i].equals("u")){ //모음일 때
                        consonant = 0; //자음 카운트 초기화
                        vowel += 1; //모음 카운트 +1

                        if(vowel == 3){ //모음 카운트 3이상 이면 불가
                            System.out.println("<"+password+"> " + "is " + "not " + "acceptable." );
                            flag = false; // flag 불가능하다 표시
                            break;
                        }

                        if(i > 0 && !p[i].equals("e") && !p[i].equals("o") && p[i].equals(p[i-1])){ //e와 o를 제외한 다른 글자가 2개 연속 불가
                            System.out.println("<"+password+"> " + "is " + "not " + "acceptable." );
                            flag = false; //flag 불가능하다 표시
                            break;
                        }
                    }else{ //자음일 때
                        vowel = 0; //모음 카운트 초기화
                        consonant += 1; // 자음 카운트 +1

                        if(consonant == 3){ 자음 카운트 3 이상이면 불가 
                            System.out.println("<"+password+"> " + "is " + "not " + "acceptable." );
                            flag = false;// flag 불가능하다 표시
                            break;
                        }

                        if(i > 0 && !p[i].equals("e") && !p[i].equals("o") && p[i].equals(p[i-1])){ //e와 o를 제외한 다른 글자가 2개 연속 불가
                            System.out.println("<"+password+"> " + "is " + "not " + "acceptable." );
                            flag = false;// flag 불가능하다 표시
                            break;
                        }
                    }

                }

                if(flag){ //불가능 표시가 아니라면 가능
                    System.out.println("<"+password+"> " + "is " + "acceptable." );
                }

            }else{ //모음이 없다
                System.out.println("<"+password+"> " + "is " + "not " + "acceptable." );
            }
        }

    }
}
