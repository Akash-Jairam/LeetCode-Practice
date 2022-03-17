class Solution {
    public String convert(String s, int numRows) {
        HashMap<Integer, StringBuilder> map = new HashMap<>();
        if(numRows == 1)
            return s;
        for(int i = 1; i <= numRows; ++i){
            map.put(i, new StringBuilder());
        }
        
        int iterator = 1;
        boolean goUp = false;
        for(char c : s.toCharArray()){
            map.get(iterator).append(c);
            if(goUp)
                --iterator;
            else
                ++iterator;
            if(iterator == 1)
                goUp = false;
            else if(iterator == numRows)
                goUp = true;
            
        }
        
        StringBuilder res = new StringBuilder();
        
        for(Map.Entry<Integer, StringBuilder> entry : map.entrySet()){
            res.append(entry.getValue().toString());
        }
        
        return res.toString();
    }
}