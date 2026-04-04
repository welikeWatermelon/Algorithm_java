// n 개의 섬 사이에 다리를 건설하는 비용이 주어질 때, 
// 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return

import java.util.*;
class Node implements Comparable<Node>{
    int x;
    int y;
    int cost;
    
    public Node(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

class Solution {
    public static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i=0;i <costs.length; i++){
            pq.add(new Node(costs[i][0],costs[i][1], costs[i][2]));
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curCost = cur.cost;
            if(find(curX) != find(curY)){
                answer+=curCost;
                union(curX,curY);
            }
        }
        
        return answer;
    }
    
    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[x] = y;
        }
    }
}