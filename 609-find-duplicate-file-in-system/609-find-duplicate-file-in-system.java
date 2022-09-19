class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String path : paths){
            String[] split = path.split(" ");
            
            for(int i = 1; i < split.length; ++i){
                int pos = split[i].indexOf("(");
                String fileName = split[i].substring(0, pos);
                String content = split[i].substring(pos + 1);

                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(split[0] + "/" + fileName);                
            }

        }
        
        for(List<String> list : map.values()){
            if(list.size() > 1 )
                res.add(list);
        }
        
        return res;
    }
}