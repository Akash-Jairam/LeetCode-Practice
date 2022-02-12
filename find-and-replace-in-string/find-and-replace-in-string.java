class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int[] map = new int[s.length()];
        Arrays.fill(map, -1);
        
        for(int i = 0; i < indices.length; ++i){
            int index = indices[i];
            if(s.substring(index, index+ sources[i].length()).equals(sources[i])){
                map[index] = i;
            }
        }
        
        int l = 0;
        StringBuilder sb = new StringBuilder();
        while(l < s.length()){
            if(map[l] >= 0){
                sb.append(targets[map[l]]);
                l += sources[map[l]].length();
            } else{
                sb.append(s.charAt(l));
                l++;
            }
        }
        
        return sb.toString();
    }
}