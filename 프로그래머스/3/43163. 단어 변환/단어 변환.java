import java.util.*;

class Node{
    String str;
    int cnt;
    public Node(String str, int cnt){
        this.str = str;
        this.cnt = cnt;
    }
}
class Solution {
    public int finalCnt = 0;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        bfs(begin, target, words, visited);
        return finalCnt;
    }
    
    public void bfs(String begin, String target, String[] words, boolean[] visited){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(begin,0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            String str = cur.str;
            int curCnt = cur.cnt;
            
            boolean flag = true;
            for(int j=0; j<str.length(); j++){
                // 나온 str이 tartget과 다르다면 flag로 처리
                if(str.charAt(j)!=target.charAt(j)){
                    flag = false;
                    continue;
                }
            }
            // 여전히 true면
            if(flag) {
                finalCnt=curCnt;
                return;
            }
            
            // 단어장에서 검사
            for(int i=0; i<words.length; i++){
                
                if(visited[i]) continue;
                
                int cnt = 0;
                
                for(int j=0; j<str.length(); j++){
                    // 현 단어와 단어장 내의 단어의 한 글자가 같으면 cnt++
                    if(str.charAt(j)==words[i].charAt(j)) cnt++;    
                }
                // 한 글자만 다르면 그걸 q에 넣어줌
                if(cnt==str.length()-1) {
                    q.add(new Node(words[i],curCnt+1));
                    visited[i] = true;
                }
            }
        }
    }
}