class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            if(i != 0){
                int num = s.substring(0, i).lastIndexOf(s.charAt(i));
                if(num == -1){
                    answer[i] = num;
                }else{
                    answer[i] = i - num;
                }
            }else{
                answer[i] = -1;
            }
        }
        return answer;
    }
}
