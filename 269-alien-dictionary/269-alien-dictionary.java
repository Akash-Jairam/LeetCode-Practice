class Solution {
    public String alienOrder(String[] words) {
        // Create a hashmap with character as the key and a hashset of characters as the value
        // Crease a hashmap to track the occurrences of each character
        // Make a call to our buildgraph function which will create our graph
        // Make a call to our dfs function which will perform the topological sorting
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        buildGraph(graph, inDegree, words);
        return dfs(graph, inDegree, words);
    }
    
    public void buildGraph(HashMap<Character, HashSet<Character>> graph, HashMap<Character, Integer> inDegree, String[] words){
        // First we will initialize our graph. For each unique character in words, we will add that as a key and an empty hashset as the value
        // We will compare two words at a time from the array and find the first unique characters
        // We will take the unique character from the first word (whic is the lexigraph.. smaller and add the character from the second word to the hashset corresponding to the unique character from the first word
        // We will take the larger character and add it to our indegree map
        for(String word : words){
            for(Character c : word.toCharArray()){
                graph.putIfAbsent(c, new HashSet());
            }
        }
        
        for(int i = 1; i < words.length; ++i){
            String prev = words[i-1];
            String curr = words[i];
            int len = Math.min(prev.length(), curr.length());
            for(int j = 0; j < len; ++j){
                if(prev.charAt(j) != curr.charAt(j)){
                    char outer = prev.charAt(j);
                    char inner = curr.charAt(j);
                    if(graph.get(outer) != null && !graph.get(outer).contains(inner))                     {
                    graph.get(outer).add(inner);
                    inDegree.put(inner, inDegree.getOrDefault(inner, 0) + 1);
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
    
    public String dfs(HashMap<Character, HashSet<Character>> graph, HashMap<Character, Integer> inDegree, String[] words){
        // Get the size of our graph
        // Create a string builder to hold our result
        // Iterate through each key in the graph
        // Add that key to our set. if the corresponding hashset is not null and append the character to our stringbuilder
        // Iterate through each character in the hashset
        // Use that character to iterate through the hashset value that corresponds to that key
        // Decrement the count of each of those characters in our indegree. If the count reaches 0, append that character to our string  and add it to our hashset
        // Check to see if the stringbuilder size == the size of graph, if true, convert the sb to a string and return it, else return false
        int size = graph.size();
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        
        for(Character c : graph.keySet()){
            if(inDegree.getOrDefault(c, 0) == 0)
                queue.offer(c);
        }
        
        while(!queue.isEmpty()){
            Character curr = queue.poll();
            sb.append(curr);
            if(graph.containsKey(curr)){
                for(Character c : graph.get(curr)){
                    inDegree.put(c, inDegree.getOrDefault(c, 0) -1);
                    if(inDegree.getOrDefault(c, 0) == 0)
                        queue.offer(c);
                }
            }
        }
        
        return sb.length() == size ? sb.toString() : "";
    }
}