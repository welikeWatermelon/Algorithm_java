import java.util.*;

class Node implements Comparable<Node>{
    int idx;
    int cost;
    public Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}
class Solution {
    public int solution(int N, int[][] road, int K) {
        // 데이터 전처리
        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++){
            graph[road[i][0]].add(new Node(road[i][1],road[i][2]));
            graph[road[i][1]].add(new Node(road[i][0],road[i][2]));
        }
        
        int answer = 0;
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curIdx = cur.idx;
            int curCost = cur.cost;
            
            if(dist[curIdx]<curCost) continue; // 이 부분 정확히 이해가 안감. 
            // -> curIdx까지 가는 기존에 있던 거리 보다 curCost가 더 클 경우 무시하라는 것
            // 이러면 curCost는 절대로 최신화가 될 수 없으니까. 
            // 근데 이해가 안가는데 curIdx까지 가는 최소 비용과, 전의 노드에서 curIdx까지 가는 비용 사이의 관계를 묻고있는거?
            // 그러면 curCost가 dist[curIdx]보다 크다면 당연히 이건 넣어서도 안되겠네. 당연히 다른것들이 추가될거고, dist[curIdx]를 넘을거니까
            
            for(Node nextNode : graph[curIdx]){
                // nextIdx까지 가는데 지금까지 구한 최소 비용(dist[nextIdx]) 과 전 노드부터 curIdx 까지가는 비용 curCost와 curIdx에서 nextIdx 까지 가는 비용 을 더한다고? -> 이게 아니지? dist[curIdx] + nextCost를 구해야하지?
                // 즉, curIdx까지 오는데 걸린 최소 비용 + curIdx -> nextIdx 까지 가는데 걸리는 비용 을 합친게 nextIdx까지 가는데 걸리는 최소 비용보다 작다면 데이터 교체하라는거지?
                // if(dist[nextIdx] > curCost + road[curIdx][nextIdx]){}
                int nextIdx = nextNode.idx;
                int nextCost = nextNode.cost;
                if(dist[nextIdx] > dist[curIdx] + nextCost){
                    dist[nextIdx] = dist[curIdx] + nextCost;
                    pq.add(new Node(nextIdx,dist[nextIdx]));
                }
                
            }            
        }
        for(int i=1; i<=N; i++){
            if(dist[i]<=K) answer++;
        }
        
    
        return answer;
    }
    
    public static void dijk(int N, int[][] road, int k){}
}