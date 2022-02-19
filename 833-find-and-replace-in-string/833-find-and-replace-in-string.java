class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        char[] sChars = s.toCharArray();
        StringBuilder sb = new StringBuilder(s.length());
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for(int i = 0; i < indices.length; ++i){
                map2.put(indices[i], sources[i]);
                if(s.substring(indices[i], indices[i] + sources[i].length()).equals(sources[i]))
                    map.put(indices[i], targets[i]);
        }
        
        
        
        for(int i = 0; i < sChars.length; ++i){
            if(map.containsKey(i)){
                sb.append(map.get(i));
                i += map2.get(i).length()-1;
            }else{
                sb.append(sChars[i]);
            }
        }
        
        return sb.toString();
    }
}