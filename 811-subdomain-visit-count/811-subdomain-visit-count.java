class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        if(cpdomains == null || cpdomains.length == 0)
            return res;
        
        Trie root = new Trie("/");
        root.fullName = "";
        
        for(String domain : cpdomains){
            int spaceIndex = domain.indexOf(" ");
            int visits = Integer.parseInt(domain.substring(0, spaceIndex));
            domain = domain.substring(spaceIndex+1);
            String[] split = domain.split("\\.");
            Trie it = root;
            for(int i = split.length - 1; i >= 0; --i){
                String name = it.fullName;
                it.children.putIfAbsent(split[i], new Trie(split[i]));
                it = it.children.get(split[i]);
                it.visits += visits;
                it.fullName = name.equals("") ? it.name : it.name + "." + name;
            }
        }
        
        traverse(res, root);
        
        return res;
        // Create com domain
        // Iterate through cp domains
        // Break them down and add them to tree making sure to update visits
        // iterate through the trie until it's empty and add each domain to list
    }
    
    public void traverse(List<String> res, Trie root){
        Queue<Trie> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                Trie curr = queue.poll();
                if(!curr.fullName.equals(""))
                    res.add(curr.visits + " " + curr.fullName);

                for(Trie child : curr.children.values())
                    queue.offer(child);
            }
        }
    }
}

class Trie{
    String name;
    String fullName;
    HashMap<String, Trie> children;
    int visits;
    
    public Trie(String name){
        this.name = name;
        this.children = new HashMap<>();
        this.visits = 0;
    }
}