class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        else if (strs.length == 1)
            return strs[0];
        
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        if(strs[0].length() == 0)
            return "";
        else{
            String s = "";
            for(int i = 0; i < strs[0].length(); i++ ){
                s += strs[0].charAt(i);
                map.put(s, 1);
            }
        }
        
        
        for(int i = 1; i < strs.length; i++){
            if(strs[i].length() == 0)
                return "";
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(strs[i].indexOf(entry.getKey()) == 0){
                    map.put(entry.getKey(), entry.getValue() +1);
                }
            }
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == strs.length && entry.getKey().length() > answer.length())
                answer = entry.getKey();
        }
        
        return answer;
        
    }
}