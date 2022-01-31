class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<>(){
            @Override
            public int compare(String log1, String log2){
                int spacePos1 = log1.indexOf(" ");
                int spacePos2 = log2.indexOf(" ");
                boolean isDigit1 = Character.isDigit(log1.charAt(spacePos1+1));
                boolean isDigit2 = Character.isDigit(log2.charAt(spacePos2+1));
                
                if(!isDigit1 && !isDigit2){
                    int compare = log1.substring(spacePos1 + 1).compareTo(log2.substring(spacePos2 + 1));
                    if(compare != 0)
                        return compare;
                    return log1.substring(0, spacePos1).compareTo(log2.substring(0, spacePos2));
                } else if(isDigit1 && !isDigit2){
                    return 1;
                } else if(!isDigit1 && isDigit2){
                    return -1;
                } else
                    return 0;
            }
        };
        
        Arrays.sort(logs, comp);
        return logs;
    }
}