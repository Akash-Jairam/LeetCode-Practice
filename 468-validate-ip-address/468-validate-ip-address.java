class Solution {
    public String validIPAddress(String queryIP) {
         // Use two different functions to check to see if queryIp is ipv4 or ipv6
        if(isIPv4(queryIP)){
            return "IPv4";
        } else if(isIPv6(queryIP)){
            return "IPv6";
        } else
            return "Neither";
    }
    
    public boolean isIPv4(String queryIP){
        // Split query ip by the "."
        // If the size of our array is not equal to 4, return false
        // Check to see if each element is between 0 and 255, else return false
        // 
        String[] split = queryIP.split("\\.", -1);
        for(String s : split){
            if(s.length() > 1 && s.charAt(0) == '0')
                return false;
            try{
                int num = Integer.parseInt(s);
                if(num < 0 || num > 255)
                    return false;
            } catch(NumberFormatException e){
                return false;
            }
        }
        
        return split.length == 4;
    }
    
    public boolean isIPv6(String queryIP){
        // Split the string according to the :
        // Iterate through our splitarray
        // Try to convert the string to a hex number and catch any numberformat exception before returning false
        // Check to see if the int value of the string is less than FFFF converted to int
        // If not, return false
        // Return the bool result of split array size = 8
        int max = Integer.parseInt("FFFF", 16);
        String[] split = queryIP.split(":", -1);
        for(String s : split){
            try{
                if(s.length() > 4)
                    return false;
                int num = Integer.parseInt(s, 16);
                if( num > max)
                    return false;
            } catch(NumberFormatException e){
                return false;
            }
        }
        
        return split.length == 8;
    }
}