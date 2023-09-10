import java.util.*;

class Solution {
    public int solution(String dirs) {
        String[] str = dirs.split("");
        Set<String> set = new HashSet<>(); //중복된 경로 제거를 위해 set사용
        int x = 0;
        int y = 0;
        
       
        for(int i = 0; i < str.length; i++){  
            int nx = x;
            int ny = y;
            String road = "";
               switch(str[i]){
                    case "U":  //up : y+1 
                            ny++;
                           road += x; //시작점 -> 도착점
                           road += y;
                           road += nx;
                           road += ny;
                        break;
                    case "D": //down : y-1
                            ny--; 
                            road += nx; //도착점 - > 시작점 =같은 경로 인지 확인을 위해 up down의 경로를 반대로
                           road += ny;
                           road += x;
                           road += y;
                        break;
                    case "R": //right : x + 1;
                            nx++;     
                           road += x; //시작점 -> 도착점
                           road += y;
                           road += nx;
                           road += ny;
                        break;
                    case "L": //left : x - 1;
                            nx--;    
                            road += nx; //도착점 - > 시작점 =같은 경로 인지 확인을 위해 up down의 경로를 반대로
                           road += ny;
                           road += x;
                           road += y;
                        break;
                }
                     
            if(nx <= 5 && nx >= -5 && ny <= 5 && ny >= -5){ //범위 안인지 확인
                System.out.println(road);
                set.add(road);
                x = nx;
                y = ny;
            }
                 
            }
                 
        
        int answer = set.size();
        return answer;
    }
}
