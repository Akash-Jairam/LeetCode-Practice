class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(cpdomains == null || cpdomains.length == 0)
            return res;
        
        for(String domain : cpdomains){
            String[] separated = domain.split(" ");
            String[] split = separated[1].split("\\.");
            String prev = "";
            
            for(int i = split.length - 1; i >= 0; --i){
                if(prev.equals("")){
                    prev = split[i];
                } else {
                    prev = split[i] + "." + prev;
                }
                map.put(prev, map.getOrDefault(prev, 0) + Integer.parseInt(separated[0]));                
            }
        }
        
        for(String key : map.keySet()){
            res.add(map.get(key) + " " + key);
        }
        
        return res;
    }
}
