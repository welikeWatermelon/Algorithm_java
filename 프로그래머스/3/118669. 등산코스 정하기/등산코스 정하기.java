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
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        
        ArrayList<Node>[] graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<paths.length; i++){
            graph[paths[i][0]].add(new Node(paths[i][1],paths[i][2]));
            graph[paths[i][1]].add(new Node(paths[i][0],paths[i][2]));
        }
        
        return dijk(n,graph,gates,summits);
    }
    
    public int[] dijk(int n, ArrayList<Node>[] paths, int[] gates, int[] summits){
        
        // pq
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        // 도착점 판별 위한 자료
        boolean[] isSummit = new boolean[n+1];
        for(int s : summits){
            isSummit[s] = true;
        }
        
        // dist : 해당 위치까지 최대의 intensity
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        // 시작점 넣기
        for(int i=0; i<gates.length; i++){
            pq.add(new Node(gates[i],0));
            dist[gates[i]]=0;
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curIdx = cur.idx;
            int curCost = cur.cost;
            
            // <1> dist[curIdx] -> 다른 경로를 통해 curIdx까지 온 최대 강도 중 최소 값을 고른 것
            // <2> curCost -> 해당 경로의 강도
            // 만약 <1>보다 <2>가 크다면 볼 필요도 없음
            if(dist[curIdx]<curCost) continue;
            
            // 도착점을 도착했다면 패스
            if(isSummit[curIdx]) continue;
            
            for(Node next : paths[curIdx]){
                int nextIdx = next.idx;
                int nextCost = next.cost;
                
                // 지금까지 최대 중 최소 강도 + 다음 강도 <1>
                int currentIntensity = Math.max(dist[curIdx], nextCost);
                
                // 다른 경로를 통해 온 최대 중 최소 강도 보다 <1>이 작다면 업데이트 시켜줘야함
                // 우리가 구하는 건 최대 중 최소 강도니까
                if(dist[nextIdx]>currentIntensity){
                    dist[nextIdx] = currentIntensity;
                    pq.add(new Node(nextIdx,dist[nextIdx]));
                }
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        int minIdx = -1;
       for(int i=1; i<=n; i++){
           if(isSummit[i] && minCost>dist[i]) {
               // 작을때만 업데이트 해줘야함.
               // min으로 할 경우, 인덱스까지 초기화되니 번거로움
               minCost = dist[i];
               minIdx = i;
           }
        }
        return new int[]{minIdx, minCost};
    }
}