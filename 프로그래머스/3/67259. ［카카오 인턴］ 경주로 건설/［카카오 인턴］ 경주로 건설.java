import java.util.*;

// 0 비어있음
// 1 벽
// 중간에 끊기지 않도록 경주로를 건설
// 직선도로 100
// 코너 500
// 
class Node implements Comparable<Node>{
    int x;
    int y;
    int cost;
    int dir;
    public Node(int x, int y, int cost, int dir){
        this.x = x; this. y = y; this.cost = cost; this.dir = dir;
    }
    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}
class Solution {
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    public int finalAnswer = 0;
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][] visited = new boolean[n][n][4];
        bfs(n,board, visited);
        return finalAnswer;
    }
    
    public void bfs(int n, int[][] board, boolean[][][] visited){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,0,-1));
        for(int i=0; i<4; i++){
            visited[0][0][i] = true;
        }
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curCost = cur.cost;
            int curDir = cur.dir;
            if(curDir!=-1){
                visited[curX][curY][curDir] = true;
            }
            
            // 기저조건
            if(curX==n-1 && curY==n-1){
                finalAnswer = curCost;
                return;
            }
            
            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                int nCost = curCost + 100;
                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                if(board[nx][ny]==1) continue;
                if(visited[nx][ny][i]) continue;
                
                if(curDir == -1 || curDir==i){ // 직진
                    pq.add(new Node(nx,ny,nCost,i));
                }else{ //방향 바꾸기 . 코너 생성
                    nCost += 500;
                    pq.add(new Node(nx,ny,nCost,i));
                }
            }
        }
    }
}