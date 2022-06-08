class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> res = new ArrayList<>();
        HashMap<String, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < keyName.length; ++i){
            map.putIfAbsent(keyName[i], new ArrayList<>());
            map.get(keyName[i]).add(convertToMins(keyTime[i]));
        }
        
        for(String name: map.keySet()){
            List<Integer> times = map.get(name);
            Collections.sort(times);
            int count = 1;
            for(int i = 0; i < times.size() - 2; ++i){
                if(Math.abs(times.get(i) - times.get(i+2)) <= 60){
                    res.add(name);
                    break;
                }
            }
            
        }
        
        Collections.sort(res);
        return res;
    }
    
    public int convertToMins(String keyTime){
        int colon = keyTime.indexOf(":");
        
        return Integer.parseInt(keyTime.substring(0, colon)) * 60 + Integer.parseInt(keyTime.substring(colon + 1));
    }
}