class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0,0); //dfs진행하면서 값 계산 (number배열, target값, 현재 계산 갯수, 총합)
             
        return answer;
    }
    public void dfs(int[] numbers, int target, int idx, int sum){
        
        if(idx == numbers.length){ //numbers[] 의 모든 값을 계산했을 경우
            if(target == sum) answer++; //계산 완료 값과 target값이 동일할 경우 answer +1
        }else{
            dfs(numbers, target, idx+1, sum + numbers[idx]); // +number[idx] 일 때
            dfs(numbers, target, idx+1, sum - numbers[idx]); // - number[ids] 일 때
        }
                  
    }
}
