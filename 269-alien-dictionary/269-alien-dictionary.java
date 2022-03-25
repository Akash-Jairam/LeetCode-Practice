class Solution {
    public String alienOrder(String[] words) {
        int[] inDegree = new int[26];
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        buildGraph(graph, words, inDegree);
        return dfs(graph, words, inDegree);
    }
    
    public String dfs(HashMap<Character, HashSet<Character>> graph, String[] words, int[] inDegree){
        StringBuilder sb = new StringBuilder(graph.size());
        Queue<Character> queue = new LinkedList<>();
        int size = graph.size();
        
        for(char c : graph.keySet()){
            if(inDegree[c - 'a'] == 0){
                queue.offer(c);
                sb.append(String.valueOf(c));
            }
        }
        
        while(!queue.isEmpty()){
            char curr = queue.poll();
            if(graph.get(curr) == null || graph.get(curr).size() == 0) continue;
            for(char inner : graph.get(curr)){
                inDegree[inner - 'a']--;
                if(inDegree[inner - 'a'] == 0){
                    sb.append(String.valueOf(inner));
                    queue.offer(inner);
                }
            }
        }
        
        return sb.length() == size ? sb.toString() : "";
    }
    
    public void buildGraph(HashMap<Character, HashSet<Character>> graph, String[] words, int[] inDegree){
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new HashSet());
            }
        }
        
        for(int i = 1; i < words.length; ++i){
            String first = words[i-1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());
            
            for(int j = 0; j < len; ++j){
                if(first.charAt(j) != second.charAt(j)){
                    char outer = first.charAt(j);
                    char inner = second.charAt(j);
                    if(!graph.get(outer).contains(inner)){
                        graph.get(outer).add(inner);
                        inDegree[inner - 'a']++;
                    }
                    
                    break;
                }
                if (j + 1 == len && first.length() > second.length()) {
                    graph.clear();
                    return;
                }
            }
        }
    }
}