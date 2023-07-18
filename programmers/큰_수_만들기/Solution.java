class Solution {
    public String solution(String number, int k) {
        int l = number.length() - k;
        StringBuilder sb = new StringBuilder();
        
        int start = 0;
        String answer = "";
        for(int i = 0; i < l; i++){
            char max = 0;
            for(int j = start; j <= i+k; j++){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    start = j + 1;
                }                
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}
