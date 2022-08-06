class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        if(cpdomains == null || cpdomains.length == 0)
            return res;
        HashMap<String, Integer> map = new HashMap<>();
        for(String domain : cpdomains){
            parse(domain, map);
        }
        
        
        for(String key: map.keySet()){
            res.add(String.valueOf(map.get(key)) + " " + key);
        }
        return res;
    }
    
    
    public void parse(String s, HashMap<String, Integer> map){
        String[] split = s.split(" ");
        int visits = Integer.parseInt(split[0]);
        split = split[1].split("\\.");
        LinkedList<String> res = new LinkedList<>();
        String curr = "";
        for(int i = split.length-1; i >=0; --i){
            if(!curr.equals("")){
                curr = split[i] + "." + curr;
            } else {
                curr = split[i];
            }
            map.put(curr, map.getOrDefault(curr, 0) + visits);
        }
        
    }
}