public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for(String s : strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int start = 0;
        List<String> res = new ArrayList<>();
        int pos = findDelimiter(s, start);
        while(pos != -1){
            int count = Integer.parseInt(s.substring(start, pos));
            ++pos;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < count; ++i){
                sb.append(s.charAt(pos));
                ++pos;
            }
            start = pos;
            pos = findDelimiter(s, pos);
            res.add(sb.toString());
        }
        
        return res;
    }
    
    public int findDelimiter(String s, int start){
        return s.indexOf("#", start);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));