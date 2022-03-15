class Solution {
    public String validIPAddress(String queryIP) {
        // Create methods to validate IPv4 and IPv6 respectively
        // If a method is not IPv4,
        // Chec to see if it is IPv6
        // Return "Neither"
        if(isIPv4(queryIP)){
            return "IPv4";
        } else if(isIPv6(queryIP)){
            return "IPv6";
        } else {
            return "Neither";
        }
    }
    
    public boolean isIPv4(String queryIP){
        String[] split = queryIP.split("\\.", -1);
        
        for(String num : split){
            try{
                if(num.isEmpty() || num.isBlank())
                    return false;
                if(num.charAt(0) == '0' && num.length() > 1)
                    return false;
                int toCheck = Integer.parseInt(num);
                if(toCheck < 0 || toCheck > 255)
                    return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        
        return split.length == 4;
    }
    
    public boolean isIPv6(String queryIP){
        String[] split = queryIP.split(":", -1);
        
        for(String num : split){
            if(num.length() < 1 || num.length() > 4)
                return false;
            try{
                int toCheck = Integer.parseInt(num, 16);
                if(toCheck > Integer.parseInt("FFFF", 16))
                    return false;
            } catch(NumberFormatException e){
                return false;
            }
        }
        
        return split.length == 8;
    }
}