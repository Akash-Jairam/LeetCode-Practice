class Solution {
    public String similarRGB(String color) {
        // Shorthand distances are 0x00, 0x11 ... 0xee, 0xff
        // Take two elements at a time from the string and convert them to int
        // Subtract by a shorthand distance and we add by a shorthand distance and store both of these in variables
        // Find the difference between the converted value and our subtracted distance and do the same for our converted value and our added distance
        // We compare the mod of these differences and go with the shorthand distance with the smallest difference
        // We then convert that shorthand distance back to hex and append it to our string
        // Return our string
        StringBuilder result = new StringBuilder(color.length());
        result.append("#");
        
        for(int i = 1; i < color.length()-1; i+=2){
            int hexToInt = Integer.parseInt(color.charAt(i) + "" + color.charAt(i+1), 16);
            
            int lowerCandidate = hexToInt - (hexToInt % 17);
            int higherCandidate = (hexToInt - (hexToInt % 17)) + 17;
            int lowerShortHand = Math.abs(hexToInt - lowerCandidate) < Math.abs(hexToInt - higherCandidate) ? lowerCandidate : higherCandidate;
            
            result.append(lowerShortHand == 0 ? "00" : Integer.toHexString(lowerShortHand));
        }
        
        return result.toString();
    }
}