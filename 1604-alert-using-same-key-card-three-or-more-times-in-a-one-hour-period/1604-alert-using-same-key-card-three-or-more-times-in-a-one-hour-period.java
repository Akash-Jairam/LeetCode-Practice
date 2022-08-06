class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < keyName.length; ++i){
            String[] currTime = keyTime[i].split(":");
            map.putIfAbsent(keyName[i], new ArrayList<>());
            map.get(keyName[i]).add((Integer.parseInt(currTime[0]) * 60) + Integer.parseInt(currTime[1]));
        }
        
        for(String name : map.keySet()){
            List<Integer> times = map.get(name);
            Collections.sort(times);
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
}