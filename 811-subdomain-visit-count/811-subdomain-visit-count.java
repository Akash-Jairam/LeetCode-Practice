class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        if(cpdomains == null || cpdomains.length == 0)
            return res;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String domain : cpdomains){
            int spacePos = domain.indexOf(" ");
            int visits = Integer.parseInt(domain.substring(0, spacePos));
            String d = domain.substring(spacePos+1);
            
            for(int i = 0; i < d.length(); ++i){
                if(d.charAt(i) == '.'){
                    String name = d.substring(i+1);
                    map.put(name, map.getOrDefault(name, 0) + visits);
                }
               
            }
             map.put(d, map.getOrDefault(d,0) + visits);
        }
        
        for(String d : map.keySet()){
            res.add(map.get(d) + " " + d);
        }
        
        return res;
    }
}