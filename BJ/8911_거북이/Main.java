import java.io.*;
public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        for(int tc = 0; tc < T; tc++){
            String[] s = br.readLine().split("");
            char[] c = new char[s.length];
            for(int i = 0; i < s.length; i++){
                c[i] = s[i].charAt(0);
            }

            int Xmax = 0;
            int Xmin = 0;
            int Ymax = 0;
            int Ymin = 0;
            int Xnow = 0;
            int Ynow = 0;
            int dr = 0;

            for(int i = 0; i < c.length; i++){
                switch(c[i]){
                    case 'F':
                        Xnow += dx[dr];
                        Ynow += dy[dr];
                        break;
                    case 'B':
                        Xnow -= dx[dr];
                        Ynow -= dy[dr];
                        break;
                    case 'L':
                        if(dr == 0){
                            dr = 3;
                        }else{
                            dr -= 1;
                        }
                        break;
                    case 'R':
                        if(dr == 3){
                            dr = 0;
                        }else{
                            dr += 1;
                        }
                        break;
                }

                Xmax = Math.max(Xmax, Xnow);
                Xmin = Math.min(Xmin, Xnow);
                Ymax = Math.max(Ymax, Ynow);
                Ymin = Math.min(Ymin, Ynow);
                
            }
            int result = (Math.abs(Xmax)+ Math.abs(Xmin)) * (Math.abs(Ymax)+ Math.abs(Ymin));

            System.out.println(result);

        }
    }
}
