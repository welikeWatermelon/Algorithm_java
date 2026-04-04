import java.util.*;
// 퀸은 가로 세로 대각으로 움직일 수 있음

class Solution {
    public int[] board;
    public int answerCount = 0;
    public int solution(int n) {
        int answer = 0;
        board = new int[n];
        dfs(n,0);
        return answerCount;
    }
    
    public void dfs(int n, int cnt){
        // 기저 조건
        if(cnt==n){
            answerCount++;
            return;
        }
        
        // DEPTH+1 진입
        // 행은 cnt (0~n-1)
        // 열은 i (1~n)
        for(int i=1; i<=n; i++){
            boolean flag = false;
            // 조건 만족해야함
            // i에 놓을 때 위쪽 대각에 있으면 안됨 (즉 모든 배열에 i+1, i-1이 있어선 안됨)
            // 좌측 아래 대각
            for(int j=0; j<cnt; j++){
                int tmpX = j;
                int tmpY = board[j];
                if(cnt+i == tmpX + tmpY) flag = true;
                if(tmpX-tmpY == cnt-i) flag = true;
            }
            
            // i에 놓을 때 바로 위에 있으면 안됨(즉 모든 배열에 i와 같은게 있어선 안됨)
            // 행검사 (행마다 같은 숫자가 있는지 검사)
            for(int j=0; j<cnt; j++){
                if(board[j]==i){flag =true;}
            }
            if(flag) continue;
                
            // 조건 만족 하는 경우 아래로 진입
            board[cnt]=i;
            dfs(n,cnt+1);
        }
    }
}