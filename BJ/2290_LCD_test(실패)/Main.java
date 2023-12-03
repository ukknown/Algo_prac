
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();
        String[] str = n.split("");
        StringBuffer[] sb = new StringBuffer[2*s+3];
        for(int i=0; i<2*s+3; i++) {
            sb[i] = new StringBuffer();
        }

        int x = (s*2)+3;//세로
        int y = (s+2)*str.length + str.length;//가로
        String[][] LCD = new String[x][y];

        int idx = 0;
        for(int i = 0; i < str.length; i++){
            switch(str[i]){
                case "1":
                    LCD[1][idx+4] = "|";
                    LCD[2][idx+4] = "|";
                    LCD[4][idx+4] = "|";
                    LCD[5][idx+4] = "|";
                    break;
                case "2":
                    LCD[0][idx+1] = "-";
                    LCD[0][idx+3] = "-";
                    LCD[1][idx+4] = "|";
                    LCD[2][idx+4] = "|";
                    LCD[3][idx+1] = "-";
                    LCD[3][idx+3] = "-";
                    LCD[4][idx+0] = "|";
                    LCD[5][idx+0] = "|";
                    LCD[6][idx+1] = "-";
                    LCD[6][idx+3] = "-";
                    break;
                case "3":
                    LCD[0][idx+1] = "-";
                    LCD[0][idx+3] = "-";
                    LCD[1][idx+4] = "|";
                    LCD[2][idx+4] = "|";
                    LCD[3][idx+1] = "-";
                    LCD[3][idx+3] = "-";
                    LCD[4][idx+3] = "|";
                    LCD[5][idx+3] = "|";
                    LCD[6][idx+1] = "-";
                    LCD[6][idx+3] = "-";
                    break;
                case "4":
                    LCD[1][idx+0] = "|";
                    LCD[2][idx+0] = "|";
                    LCD[1][idx+4] = "|";
                    LCD[2][idx+4] = "|";
                    LCD[3][idx+1] = "-";
                    LCD[3][idx+3] = "-";
                    LCD[4][idx+3] = "|";
                    LCD[5][idx+3] = "|";
                    break;
                case "5":
                    LCD[0][idx+1] = "-";
                    LCD[0][idx+3] = "-";
                    LCD[1][idx+0] = "|";
                    LCD[2][idx+0] = "|";
                    LCD[3][idx+1] = "-";
                    LCD[3][idx+3] = "-";
                    LCD[4][idx+3] = "|";
                    LCD[5][idx+3] = "|";
                    LCD[6][idx+1] = "-";
                    LCD[6][idx+3] = "-";
                    break;
                case "6":
                    LCD[0][idx+1] = "-";
                    LCD[0][idx+3] = "-";
                    LCD[1][idx+0] = "|";
                    LCD[2][idx+0] = "|";
                    LCD[3][idx+1] = "-";
                    LCD[3][idx+3] = "-";
                    LCD[4][idx+0] = "|";
                    LCD[5][idx+0] = "|";
                    LCD[4][idx+3] = "|";
                    LCD[5][idx+3] = "|";
                    LCD[6][idx+1] = "-";
                    LCD[6][idx+3] = "-";
                    break;
                case "7":
                    LCD[0][idx+1] = "-";
                    LCD[0][idx+3] = "-";
                    LCD[1][idx+4] = "|";
                    LCD[2][idx+4] = "|";
                    LCD[4][idx+3] = "|";
                    LCD[5][idx+3] = "|";
                    break;
                case "8":
                    LCD[0][idx+1] = "-";
                    LCD[0][idx+3] = "-";
                    LCD[1][idx+0] = "|";
                    LCD[2][idx+0] = "|";
                    LCD[1][idx+4] = "|";
                    LCD[2][idx+4] = "|";
                    LCD[3][idx+1] = "-";
                    LCD[3][idx+3] = "-";
                    LCD[4][idx+0] = "|";
                    LCD[5][idx+0] = "|";
                    LCD[4][idx+3] = "|";
                    LCD[5][idx+3] = "|";
                    LCD[6][idx+1] = "-";
                    LCD[6][idx+3] = "-";
                    break;
                case "9":
                    LCD[0][idx+1] = "-";
                    LCD[0][idx+3] = "-";
                    LCD[1][idx+0] = "|";
                    LCD[2][idx+0] = "|";
                    LCD[1][idx+4] = "|";
                    LCD[2][idx+4] = "|";
                    LCD[3][idx+1] = "-";
                    LCD[3][idx+3] = "-";
                    LCD[4][idx+3] = "|";
                    LCD[5][idx+3] = "|";
                    LCD[6][idx+1] = "-";
                    LCD[6][idx+3] = "-";
                    break;
                case "0":
                    LCD[0][idx+1] = "-";
                    LCD[0][idx+3] = "-";
                    LCD[1][idx+0] = "|";
                    LCD[2][idx+0] = "|";
                    LCD[1][idx+4] = "|";
                    LCD[2][idx+4] = "|";
                    LCD[4][idx+0] = "|";
                    LCD[5][idx+0] = "|";
                    LCD[4][idx+3] = "|";
                    LCD[5][idx+3] = "|";
                    LCD[6][idx+1] = "-";
                    LCD[6][idx+3] = "-";
                    break;
            }
            idx+=5;

        }

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){

                if(LCD[i][j].equals("-") || LCD[i][j].equals("|")){  //nullpointerException
                    sb[i].append(LCD[i][j]);
                }else{
                    sb[i].append(" ");
                }
            }sb[i].append("\n");
        }








    }



}
