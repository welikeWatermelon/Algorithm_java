import java.util.*;

// 곡괭이 : 다이아, 철, 돌 각각 0~5개까지 가지고 있음
// 광물을 캘 땐 피로도가 소모됨
// 각 곡괭이는 종류에 상관없이 광물 5개를 캔 후에는 더 이상 사용 불가
// 
// 사용할 수 있는 곡괭이중 아무거나 하나를 선택해서 광물을 캠
// 한 번 사용하기 시작한 곡괭이는 사용할 수 없을때까지 사용
// 광물은 주어진 순서대로만 캘 수 있음 
// 광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을 때까지 광물을 캠 (조건 2개임)

// 곡괭이를 하나 선택해서 광물 5개를 얻고, 다음 곡괭이를 선택해서 5개를 얻고 ... 곡괭이가 없거나 광물을 다 캐면 종료

// 곡괭이의 개수를 나타내는 배열 : picks = [dia,iron,stone] 
// 광물들의 순서 : minerals

// <설계>
// 1. 곡괭이들을 하나씩 선택해가며 dfs로 내려가야함
// 1-1. diaCnt, ironCnt, stoneCnt 를 넣자 -> 지금까지 사용한 횟수 -> 복잡하니 int[] picksNum 로 한번에 다루자
// 1-2. 하나씩 증가해가며 picks[0] == diaCnt와 같아진다면 나오도록 (나오는게 아니라 선택을 안하는 것)
// 1-3. 이 때는 해당 곡괭이로 해당 광물(minerals[mineralsCnt])을 캤을떄의 피로도를 누적시켜줘야함
//       -> tired 를 인자에 넣자. 

// 2. 최종 조건은 광산 광물이 모두 없어지거나 곡괭이가 없을떄까지임
// 2-1. mineralsCnt == minerals.length 일 때나
// 2-2. picks[0] == diaCnt && 나머지 두개 이하 동일 일 떄.

// 3. 최종 최소 피로도를 갱신해줌

class Solution {
    public int[][] tiredTable = {{1,1,1},{5,1,1},{25,5,1}};
    public int finalTired = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        // int mineralsCnt = minerals.length;
        int[] picksNum = {0,0,0}; // 곡괭이 사용 수
        int answer = 0;
        dfs(picks, minerals, 0, picksNum, 0);
        return finalTired;
    }
    
    public void dfs(int[] picks, String[] minerals, int mineralsCnt, int[] picksNum, int tired){
        // 기저 조건
        // 1. 광산 광물이 모두 없어질 떄  / 2. 곡괭이를 모두 사용했을 때
        if(mineralsCnt == minerals.length || (picksNum[0]==picks[0] && picksNum[1]==picks[1] && picksNum[2]==picks[2])){
            finalTired = Math.min(finalTired,tired);
            return;
        }
        
        // 반복 (곡괭이 선택)
        for(int i=0; i<3; i++){
            // 해당 곡괭이가 여유로울 때
            if(picks[i]>picksNum[i]){
                picksNum[i]++;
                int tmpTired = 0;
               
                // 곡괭이 하나당 광물 5개 조건이 있음
                if(minerals.length-mineralsCnt>=5){
                    for(int j=0; j<5; j++){
                        // 광물 선택
                        if(minerals[mineralsCnt+j].equals("diamond")){
                            tmpTired += tiredTable[i][0];
                        }else if(minerals[mineralsCnt+j].equals("iron")){
                            tmpTired += tiredTable[i][1];
                        }else{
                            tmpTired += tiredTable[i][2];
                        }
                    }
                    dfs(picks,minerals,mineralsCnt+5,picksNum,tired+tmpTired);
                }else{
                    int last = minerals.length-mineralsCnt;
                    for(int j=0; j<last; j++){
                        // 광물 선택
                        if(minerals[mineralsCnt+j].equals("diamond")){
                            tmpTired += tiredTable[i][0];
                        }else if(minerals[mineralsCnt+j].equals("iron")){
                            tmpTired += tiredTable[i][1];
                        }else{
                            tmpTired += tiredTable[i][2];
                        }
                    }
                    dfs(picks,minerals,mineralsCnt+last,picksNum,tired+tmpTired);
                }
                picksNum[i]--;
            }
        }
    }
}