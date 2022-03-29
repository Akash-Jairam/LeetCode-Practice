class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(words, graph, inDegree);
        return dfs(graph, inDegree);
    }
    
    public String dfs(HashMap<Character, HashSet<Character>> graph, int[] inDegree){
        int size = graph.size();
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(Character c : graph.keySet()){
            if(inDegree[c - 'a'] == 0){
                queue.offer(c);
            }
        }
        
        while(!queue.isEmpty()){
            Character curr = queue.poll();
            sb.append(curr);
            
            for(Character c : graph.get(curr)){
                inDegree[c - 'a']--;
                if(inDegree[c - 'a'] == 0){
                   queue.offer(c);
                }
            }
        }
        
        return sb.length() == size ? sb.toString() : "";
    }
    
    public void buildGraph(String[] words, HashMap<Character, HashSet<Character>> graph, int[] inDegree){
        
        for(String word : words){
            for(Character c : word.toCharArray()){
                graph.putIfAbsent(c, new HashSet());
            }
        }
        
        for(int i = 1; i < words.length; ++i){
            String curr = words[i];
            String prev = words[i-1];
            
            int len = Math.min(curr.length(), prev.length());
            for(int j = 0; j < len; ++j){
                if(curr.charAt(j) != prev.charAt(j)){
                    Character outer = prev.charAt(j);
                    Character inner = curr.charAt(j);
                    if(graph.get(outer) != null && !graph.get(outer).contains(inner)){
                    graph.get(prev.charAt(j)).add(curr.charAt(j));
                    inDegree[curr.charAt(j) - 'a']++;
                    }
                    break;
                }
                 if (j + 1 == len && prev.length() > curr.length()) {
                    graph.clear();
                    return;
                }
            }
        }
    }
}