import java.util.*;

class Solution {
    public List<String> list = new ArrayList<>();
    public String[] alphabet = {"A","E","I","O","U"};
    public int solution(String word) {
        int answer = 0;
        dfs("");
        
        return list.indexOf(word)+1;
    }
    
    public void dfs(String str){
        
        if(!str.equals("")){
            list.add(str);
        }
        
        if(str.length()==5){
            return;
        }
        
        for(int i=0; i<5; i++){
            dfs(str+alphabet[i]);
        }
    }
}