import java.util.*;
// 공통 부분 -> 이 부분이 많아야 하고
// A 부분 -> 이 부분이 적어야함
// B 부분 -> 이 부분이 적어야함
class Node implements Comparable<Node>{
    int idx;
    int cost;
    Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        ArrayList<Node>[] newFares = new ArrayList[n+1];
        
        for(int i=0; i<=n ;i++){
            newFares[i] = new ArrayList<Node>();
        }
        
        for(int[] tmpFare: fares){
            newFares[tmpFare[0]].add(new Node(tmpFare[1],tmpFare[2]));
            newFares[tmpFare[1]].add(new Node(tmpFare[0],tmpFare[2]));
        }
        
        int[] togetherDist = dijk(s,n,newFares); // 공통 부분의 다익스트라
        int[] aDist = dijk(a,n,newFares); // A 부분의 다익스트라
        int[] bDist = dijk(b,n,newFares); // B 부분의 다익스트라
        
        for(int i=1; i<=n; i++){
            int tmpAnswer = 0;
            tmpAnswer += togetherDist[i];
            // System.out.println(tmpAnswer);
            tmpAnswer += aDist[i];
            tmpAnswer += bDist[i];
            answer = Math.min(answer,tmpAnswer);
        }
        
        return answer;
    }
    
    public int[] dijk(int start, int n, ArrayList<Node>[] newFares ){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];
        

        Arrays.fill(dist,200000000);
        dist[start] = 0;
        
        pq.add(new Node(start,0));
        
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIdx = curNode.idx;           
            int curCost = curNode.cost;           
            
            if(dist[curIdx]<curCost) continue;
            
            for(Node nextNode : newFares[curIdx]){
                int nextIdx = nextNode.idx;
                int nextCost = nextNode.cost;
                
                if(dist[nextIdx]>dist[curIdx] + nextCost){
                    dist[nextIdx]=dist[curIdx] + nextCost;
                    pq.add(new Node(nextIdx, dist[nextIdx]));
                }
            }
        }
        return dist;
    }
}
// n : 지점의 개수 <200
// s : 출발지점
// a : A도착지점
// b : B도착지점
// fares : 지점 사이의 예상 택시요금 [2차원 정수 배열] <n^2/2
// 각 행은 [c,d,f] -> c지점과 d지점 사이의 비용 f < 100,000
// 합승을 안하는 요금이 더 낮으면 안해도됨

// 이거는 다익스트라임
// 플로이드 워셜인가? n^3 -> 8,000,000 -> 충분히 가능
// 1600,000,000 -> 불가
// S에서 특정지점P 까지 가는 경우 -> n^2 * log n -> 가능
// P에서 각자 집에 가는 경우 -> n^2 * log n  => n^4 log n
