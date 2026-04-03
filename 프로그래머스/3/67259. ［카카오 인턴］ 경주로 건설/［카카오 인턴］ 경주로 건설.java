import java.util.*;

class Node implements Comparable<Node>{
    int x;
    int y;
    int cost;
    int dir;
    public Node(int x, int y, int cost, int dir){
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
    
    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

class Solution {
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int[][][] dist;
    
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        bfs(0,0,board,n);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=4; i++){
            min = Math.min(dist[n-1][n-1][i], min);
        }
        
        return min;
    }
    
    public void bfs(int startX, int startY, int[][] board, int n){
        dist = new int[n][n][5];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n ;j++){
                for(int k=0; k<5; k++){
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        dist[startX][startY][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startX, startY, 0, 0));
        
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int x = curNode.x;
            int y = curNode.y;
            int cost = curNode.cost;
            int dir = curNode.dir;
            
            if(dist[x][y][dir] < cost) continue;
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx>=n || ny>=n) continue;
                
                if(board[nx][ny]==1) continue;
                
                int nextDir = i+1; // 1,2,3,4 -> 상,하,좌,우
                int nextCost = 100; // 일단 한번은 가니 100원을 더해줌
                
                if(dir!=0 && dir!=nextDir) nextCost += 500;
                
                if(dist[nx][ny][nextDir]>dist[x][y][dir] + nextCost){
                    dist[nx][ny][nextDir]=dist[x][y][dir] + nextCost;
                    pq.add(new Node(nx,ny,dist[nx][ny][nextDir],nextDir));
                }
            }
        }
        
        
    }
}