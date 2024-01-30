class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        String[] str = s.split("");
        
        int[] answer = new int[s.length()];
        int idx = 0;
        for(int i = str.length-1; i >= 0; i--){
            answer[idx] = Integer.parseInt(str[i]);
            idx++;
        }
        return answer;
    }
}
