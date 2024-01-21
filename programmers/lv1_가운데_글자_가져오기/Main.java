class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        int start = 0;
        int end = 0;
        
        if(s.length()%2 == 1){
            start = s.length()/2;
            end = start;
        }else{
            start = s.length()/2 - 1;
            end = start+1;
        }
        
        for(int i = start; i <= end; i++){
            answer += str[i];
        }
        
        return answer;
    }
}
