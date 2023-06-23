import java.util.*;

class Solution {
    class info{
        int x;
        int count;
        public info(int x, int count){
            this.x = x;
            this.count = count;
        }
    }
    static int answer;
    public int solution(int x, int y, int n) {
        answer = 0;
        
        BFS(x,y,n);
        
        return answer;
    }
    
    public void BFS(int x, int y, int n){
        Queue<info> que = new LinkedList<>();
        
        que.add(new info(x,0));
        int flag = 0;
        int c = 0;
        while(!que.isEmpty()){
            info r = que.poll();
//System.out.println(r.x + " ");
            
            if(flag != r.count){
                flag = r.count;
                c = 0;
            }            
            c += 1;
            if(r.x == y){
                answer = r.count;
                break;
            }
            
            if(r.x > y){               
                if(c == 4){
                    answer = -1;
                    break;
                }                             
            }
            
            que.add(new info(r.x + n, r.count + 1));
            que.add(new info(r.x * 2, r.count + 1));
            que.add(new info(r.x * 3, r.count + 1));
            
        }
    }
}
