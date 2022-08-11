class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        
        int start = 0;
        int end = 0;
        
        while(start < words.length){
            end = findWordIndex(words, start, maxWidth);
            res.add(justify(words, start, end, maxWidth));
            start = end + 1;
        }
        
        return res;
    }
    
    public int findWordIndex(String[] words, int start, int maxWidth){
        int i = start;
        
        int currWidth = words[i].length();
        ++i;
        while(i < words.length && (currWidth + 1 + words[i].length()) <= maxWidth){
            currWidth = currWidth + 1 + words[i].length();
            ++i;
        }
        
        // i will be invalid so we need to return i - 1
        return i - 1;
    }
    
    public String justify(String[] words, int start, int end, int maxWidth){
        if(end - start == 0) return padResult(words[start], maxWidth);
        
        boolean isLastLine = end == words.length - 1;
        
        int l = 0;
        for(int k = start; k <= end; ++k){
            l += words[k].length();
        }
        
        int numSpaces = maxWidth - l;
        int numWordsToPad = end - start;
        
        StringBuilder sb = new StringBuilder(maxWidth);
        String spaceStr = isLastLine ? " " : blank(numSpaces / numWordsToPad);
        int remainderSpaceCount = isLastLine ? 0 : numSpaces % numWordsToPad;
        
        int usedTotal = 0;
        
        for(int k = start; k <= end; ++k){
            sb.append(words[k]).append(spaceStr);
            
            if(remainderSpaceCount > 0){
                sb.append(" ");
                --remainderSpaceCount;
            }
        }
        
        String line = sb.toString().trim();
        return padResult(line, maxWidth);
    }
    
    private String padResult(String result, int maxWidth){
        return result + blank(maxWidth - result.length());
    }
    
    private String blank(int count){
        StringBuilder sb = new StringBuilder();
        while(count > 0){
            sb.append(" ");
            --count;
        }
        return sb.toString();
    }
}