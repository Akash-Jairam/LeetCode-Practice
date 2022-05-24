class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<String>> users = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < keyName.length; ++i){
            users.putIfAbsent(keyName[i], new ArrayList<>());
            users.get(keyName[i]).add(keyTime[i]);
        }
        
        for(String user : users.keySet()){
            List<String> times = users.get(user);
            Collections.sort(times);
           
            for(int i = 0; i < times.size() - 2; ++i){
                String prev = times.get(i);
                String[] prevSplit = prev.split(":");
                int prevTime = Integer.parseInt(prevSplit[0]) * 60 + Integer.parseInt(prevSplit[1]);
                String curr = times.get(i+2);
                String[] currSplit = curr.split(":");
                int currTime = Integer.parseInt(currSplit[0]) * 60 + Integer.parseInt(currSplit[1]);
                if(currTime - prevTime <= 60){
                    res.add(user);
                    break;
                }
            }
        }
        
        Collections.sort(res);
        return res;
    }
}