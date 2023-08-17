import java.util.*;

class Solution {
    static List<String> list;
    static String[] alpha = {"A","E","I","O","U"};
    public int solution(String word) {
        list = new ArrayList<>();
        int answer = 0;
        recursion("", 0);
        
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    static void recursion(String str, int dep){
        list.add(str);
        
        if(dep == 5){
            return;
        }
        
        for(int i = 0; i < alpha.length; i++){
            recursion(str + alpha[i], dep+1);
        }
    }

}
