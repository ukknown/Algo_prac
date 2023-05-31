//마지막 테스트케이스에서 시간 초과 발생
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int[] c1 = new int[cards1.length];
        int[] c2 = new int[cards2.length];
        
        boolean flag = true;
        
        //cards1 단어 위치
        for(int i = 0; i < cards1.length; i++){
            for(int j = 0; j < goal.length; j++){
                if(cards1[i].equals(goal[j])){
                    if(i > 0 && j < c1[i-1]){
                        flag = false;
                        break;
                    }
                    c1[i] = j;
                }
            }
            if(!flag)break;
        }
        
        if(flag){
            //cards2단어 위치
            for(int i = 0; i < cards2.length; i++){
                for(int j = 0; j < goal.length; j++){
                    if(cards2[i].equals(goal[j])){
                        if(i > 0 && j < c2[i-1]){
                            flag = false;
                            break;
                        }
                        c2[i] = j;
                    }                  
                }
                if(!flag)break;            
            }
        }
        
        
        String answer = "";
        
        if(flag){
            answer = "Yes";
        }else{
            answer = "No";
        }
        return answer;
    }
}

//정답코드
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int c1 = 0; //goal과 비교할 cards1단어 위치
        int c2 = 0; //goal과 비교할 cards2단어 위치
        
        for(int i = 0; i < goal.length; i++){
            //c1이 cards1크기를 넘지않고 goal[i]와 값이 같다면 cards1의 다음 단어 비교로
            if(c1 < cards1.length && goal[i].equals(cards1[c1])){
                c1++;
                continue;
            }
            //c2이 cards1크기를 넘지않고 goal[i]와 값이 같다면 cards2의 다음 단어 비교로
            if(c2 < cards2.length && goal[i].equals(cards2[c2])){
                c2++;
                continue;
            }
            //cards1 or cards2에서 비교해야할 단어위치 와 gaol[i]와 일치하지않으면 단어 순서가 다르다
            answer = "No";
        }
        
        return answer;
    }
}
