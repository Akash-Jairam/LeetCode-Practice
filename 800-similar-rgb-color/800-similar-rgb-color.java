class Solution {
    public String similarRGB(String color) {
        // Valid shorthands are 0x00, 0x11, 0x22, 0x33... 0xee, 0xff
        // First we will create our stringbuilder to return
        // We will assign the # to that stringbuilder since the first character is always a #
        // Iterate through our given string starting from position 1 and incrementing our iterator by 2 at the end of every loop
        // Construct our hex character using the value at the current index plus the value at the next index and convert it to an int
        // Find the upper and lower value by adding and subtracting a shorthand respectively
        // To subtract by a shorthand, we just substract the int value by the int value mod 17
        // To add by a shorthand, we add the int value minus the int value mod 17 plus 17
        // We determine the closest shorthand by finding the difference between the int value and the upper value as well as the difference between the int value and the lower value and going with the lower or higher depending on which difference was lower
        // We convert the closestshorthand to an int and we append it to our string
        StringBuilder result = new StringBuilder(color.length());
        result.append("#");
        
        for(int i = 1; i < color.length()-1; i+=2){
            int hexToInt = Integer.parseInt(color.charAt(i) + "" + color.charAt(i+1), 16);
            
            int lower = hexToInt - (hexToInt % 17);
            int upper = (hexToInt - (hexToInt % 17)) + 17;
            int closestShortHand = Math.abs(hexToInt - lower) < Math.abs(hexToInt - upper) ? lower : upper;
            
            result.append(closestShortHand == 0 ? "00" : Integer.toHexString(closestShortHand));
        }
        
        return result.toString();
    }
}