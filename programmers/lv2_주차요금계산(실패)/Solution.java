import java.util.*;
public class info implements Comparable<info>{
    int carN;
    int fee;
    public info(int carN, int fee){
        this.carN = carN;
        this.fee = fee;
    }
    @Override
    public int compareTo(info o){
        return this.carN - o.carN;
    }
}
class Solution {
    static int[] fee;
    static HashMap<Integer, String> in;
    static HashMap<Integer, Integer> Cartime;
    static List<info> num;
    public int[] solution(int[] fees, String[] records) {
        
        fee = fees;
        in = new HashMap<>(); //입차
        Cartime = new HashMap<>(); //차량 번호, 시간
        num = new ArrayList<info>();
        
        for(int i = 0; i < records.length; i++){
            String[] str = records[i].split(" ");
            int carNum = Integer.parseInt(str[1]); //자동차 번호
            if(str[2].equals("IN")){ //입차
                in.put(carNum, str[0]); // 입차 정보
            }else{ //출차
                int t = Tcal(carNum, str[0]); //출차 정보 넣고 주차 시간
                in.remove(carNum); //입차 정보 제거
                
                if(Cartime.get(carNum) != null){ //이미 계산된 주차 시간이 있다면
                    t = t+Cartime.get(carNum); // 그 시간에 새로운 시간 추가
                    Cartime.put(carNum, t);
                }else{
                    Cartime.put(carNum, t);
                }
            }
        }
        //정상
        
         if(!in.isEmpty()){
            Set<Integer> Ckey = in.keySet();
             for(int key : Ckey){
                int t = Tcal(key, "23:59"); //출차 정보 넣고 주차 시간
                in.remove(key); //입차 정보 제거
                
                if(Cartime.get(key) != null){ //이미 계산된 주차 시간이 있다면
                    t = t+ Cartime.get(key); // 그 시간에 새로운 시간 추가
                    Cartime.put(key, t);
                }else{
                    Cartime.put(key, t);
                }
             }
         }
        
         Set<Integer> Ckey = Cartime.keySet();
        
        for(int key : Ckey){
            if(Cartime.get(key) > fee[0]){ //기본 시간 초과면
                int n = Cartime.get(key) - fee[0];
                if(n%fee[2] != 0){
                    n = n/fee[2] + 1;
                }else{
                    n = n/fee[2];
                }
                n = fee[1] + (n*fee[3]);
                num.add(new info(key,n)); //요금 부과
            }else{//기본 시간 이하이면
                num.add(new info(key,fee[1])); //기본요금 부과
            }
        }
        Collections.sort(num);
        int[] answer = new int[num.size()];
        for(int i = 0; i < num.size(); i++){
            answer[i] = num.get(i).fee;
        }
        
        return answer;
    }
    private static int Tcal(int CarNumber, String time){ //시간 계산
        
        String[] Otime = time.split(":");
        String[] Itime = in.get(CarNumber).split(":");
                
        int hour = ((Integer.parseInt(Otime[0])-1) - Integer.parseInt(Itime[0]))*60;
        int minu = (Integer.parseInt(Otime[1])+60) - Integer.parseInt(Itime[1]);
                  
        return hour+minu;
    }

}
