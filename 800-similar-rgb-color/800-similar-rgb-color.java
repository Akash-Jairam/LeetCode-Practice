class Solution {
    public String similarRGB(String color) {
        StringBuilder result = new StringBuilder(color.length());
        result.append('#');
        
        for(int i = 1; i < color.length()-1; i+=2){
            // Convert string that is a hex number to a decimal integer
            int currHex = Integer.parseInt(color.charAt(i) + "" + color.charAt(i+1), 16);
            
            // Note that 0x11 is 17, we convert the hex to decimal to do the comp then we convert the closest shorthand back to hex and append to result
            int below = (currHex - (currHex % 17));
            int above = (currHex - (currHex % 17)) + 17;
            int closestShortHand = Math.abs(currHex - below) < Math.abs(currHex - above) ? below : above;
            // Convert the closest shorthand from decimal to hex
            // If it's a 0, we return "00" instead of just "0"
            result.append(closestShortHand == 0 ? "00" : Integer.toHexString(closestShortHand));
            
        }
        
        return result.toString();
    }
}