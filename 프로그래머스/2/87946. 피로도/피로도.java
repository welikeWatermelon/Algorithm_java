// 유저 현재 피로도 k
// dungeons[던전의 개수][최소 필요 피로도, 소모 피로도]
// 피로도는 1,000 이하
// 각 던전은 한 번만 도전 가능
class Solution {
    public int finalCnt = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k,dungeons,0,visited);
        return finalCnt;
    }
    
    public void dfs(int k, int[][] dungeons, int cnt, boolean[] visited){
        finalCnt = Math.max(finalCnt,cnt);

        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k>= dungeons[i][0]){
                
                // 방문 처리
                visited[i] = true;
                
                // 다음 던전으로
                dfs(k-dungeons[i][1], dungeons, cnt+1, visited);
                
                // 복귀
                visited[i] = false;
            }
        }
    }
}