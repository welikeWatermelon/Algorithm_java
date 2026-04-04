import java.util.*;

// n명의 카카오톡 사용자들에게 이모티콘 m개를 할인하여 판매합니다
// 이모티콘 마다 할인율이 있음 10 20 30 40
// 
// <카카오톡 목적>
// - 이모티콘 플러스 서비스 가입자 늘리기 (1순위)
// - 이모티콘 판매액 늘리기 (2순위)
//
// <사용자 구매 기준>
// - 일정 비율 이상 할인하는 이모티콘을 모두 구매함
// - 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면 구매하지 않고 이모티콘 플러스 서비스에 가입함

// 이모티콘1의 a할인율 적용(할인율만 써주기) -> 이모티콘2의 a,b,c,d할인율 적용 -> 이모티콘3...
// 마지막까지 할인율을 적용하였을 때, 할인율이 적용된 가격 표가 있어야함.
// 이걸 바탕으로 (할인율을 리스트로.) 
// users들을 판단.각 유저들마다 구매 금액을 적고, 플러스 가입여부를 적음
// 플러스 가입여부가 true -> 구매 금액 안더함
// false -> 구매 금액 더함

// 출력 : {서비스 가입자 수, 매출액}

class Solution {
    public int[] finalAnswer = {0,0};
    public int[] salePercent = {10,20,30,40};
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        int[] fixSale = new int[emoticons.length];
        dfs(users,emoticons, 0, fixSale);
        return finalAnswer;
    }
    
    public void dfs(int[][] users, int[] emoticons, int cnt, int[] fixSale){
        int plusCnt = 0;
        int finalMoney = 0;
        
        // 끝가지 돌면 결과 보고 (종료 조건임)
        if(cnt==emoticons.length){
            // users들 반영
            for(int i=0; i<users.length; i++){
                int money = 0;
                for(int j=0; j<emoticons.length; j++){
                    if(users[i][0]<=fixSale[j]){
                        money+=emoticons[j]*(100-fixSale[j])/100;
                    }
                }
                if(money>=users[i][1]){
                    plusCnt++;
                }else{
                    finalMoney += money;
                }
                
            }
            // 결과
            if(finalAnswer[0]<plusCnt){
                finalAnswer[0] = plusCnt;
                finalAnswer[1] = finalMoney;
            }else if(finalAnswer[0]==plusCnt){
                finalAnswer[1] = Math.max(finalAnswer[1],finalMoney);
            }
            
            return;
        }
        
        // 재귀 부분 1번 이모티콘부터 차례대로 돌건데, 할인율은 다르게 돌거임
        for(int i=0; i<4; i++){        
            fixSale[cnt]=salePercent[i];
            dfs(users, emoticons, cnt+1, fixSale);
        }
        
    }
}