
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i); //String s의 i위치 값을 char타입으로 저장
            for(int j = 0; j < index; j++){ //index 크기만큼 1씩 더함
                c += 1; //영단어 하나씩 이동
                
                if(c > 'z'){ //z를 넘어가면 a로 돌아감
                    c = 'a';
                }
                if(skip.contains(String.valueOf(c))){ //skip에 있는 단어는 넘어감 이동한 index값을 1빼줌
                    j--;
                }
            }
            answer += c;
        }
        return answer;
    }
}
