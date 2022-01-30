class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2){
            int spaceIndex1 = log1.indexOf(" ");
            int spaceIndex2 = log2.indexOf(" ");
            char log1Char = log1.charAt(spaceIndex1 + 1);
            char log2Char = log2.charAt(spaceIndex2 + 1);
            boolean isDigit1 = Character.isDigit(log1Char);
            boolean isDigit2 = Character.isDigit(log2Char);
            
            if(!isDigit1 && !isDigit2){
                int preCompute = log1.substring(spaceIndex1).compareTo(log2.substring(spaceIndex2));
                if(preCompute == 0)
                    preCompute = log1.substring(0, spaceIndex1).compareTo(log2.substring(0,  spaceIndex2));
                return preCompute;
            } else if((!isDigit1 && isDigit2) || (isDigit1 && !isDigit2)){
                if(isDigit1)
                    return 1;
                else
                    return -1;
            } else
                return 0;
            
        }};
            Arrays.sort(logs, comp);
            return logs;
    }
}