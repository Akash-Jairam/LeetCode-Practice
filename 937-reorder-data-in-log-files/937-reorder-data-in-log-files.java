class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>(){
            @Override public int compare(String log1, String log2){
                int log1SpaceIndex = log1.indexOf(" ");
                int log2SpaceIndex = log2.indexOf(" ");
                char log1Char = log1.charAt(log1SpaceIndex+1);
                char log2Char = log2.charAt(log2SpaceIndex+1);
                boolean isDigit1 = Character.isDigit(log1Char);
                boolean isDigit2 = Character.isDigit(log2Char);
                
                if(!isDigit1 && !isDigit2){
                    int comparer = log1.substring(log1SpaceIndex+1).compareTo(log2.substring(log2SpaceIndex+1));
                    if(comparer != 0)
                        return comparer;
                    return log1.substring(0, log1SpaceIndex).compareTo(log2.substring(0, log2SpaceIndex));
                } else if(isDigit1 && !isDigit2){
                    return 1;
                } else if(!isDigit1 && isDigit2){
                    return -1;
                } else{
                    // Both characters are digit logs and maintain relative ordering
                    return 0;
                }
            }
        };
        
        Arrays.sort(logs, comp);
        return logs;
    }
}