class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length-1; i++){
            int num = 0;
            for(int j = i + 1; j < prices.length; j++){
                if(prices[i] > prices[j] || j == prices.length-1 ){
                    num++;
                    answer[i] = num;                
                    break;
                }else{
                    num++;
                }
            }
        }
        answer[prices.length-1] = 0;
        return answer;
    }
}
