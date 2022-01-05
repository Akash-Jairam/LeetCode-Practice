class Solution {
    public int romanToInt(String s) {
        if(s.length() == 0)
            return -1;
        else if(s.length() < 1 || s.length() > 15)
            return -1;
        s = s.toUpperCase();
        int runningTotal = 0;
        if(s.contains("IV")){
            int removeLocation = s.indexOf("IV");
            String s1 = s.substring(0, removeLocation);
            String s2 = s.substring(removeLocation+2);
            s =  s1+ s2;
            runningTotal += 4;
        }
        
        if(s.contains("CM")){
            int removeLocation = s.indexOf("CM");
            s = s.substring(0, removeLocation) + s.substring(removeLocation+2);
            runningTotal += 900;
        }
        
        if(s.contains("XC")){
            int removeLocation = s.indexOf("XC");
            s = s.substring(0, removeLocation) + s.substring(removeLocation+2);
            runningTotal += 90;
        }
        
        if(s.contains("XL")){
            int removeLocation = s.indexOf("XL");
            s = s.substring(0, removeLocation) + s.substring(removeLocation+2);
            runningTotal += 40;
        }
        
        if(s.contains("IX")){
            int removeLocation = s.indexOf("IX");
            s = s.substring(0, removeLocation) + s.substring(removeLocation+2);
            runningTotal += 9;
        }
        
        if(s.contains("CD")){
            int removeLocation = s.indexOf("CD");
            s = s.substring(0, removeLocation) + s.substring(removeLocation+2);
            runningTotal += 400;
        }
        
        
        
        for(int i = 0; i < s.length(); i++){
            int currentVal = romanNumeralConvert(s.charAt(i));
            if(currentVal == -1)
                return -1;
            else{
                runningTotal += currentVal;
            }
        }
        return runningTotal;
    }
    
    public int romanNumeralConvert(char c){
        if(c == 'I')
            return 1;
        else if(c == 'V')
            return 5;
        else if(c == 'X')
            return 10;
        else if(c == 'L')
            return 50;
        else if(c == 'C')
            return 100;
        else if(c == 'D')
            return 500;
        else if(c == 'M')
            return 1000;
        else return -1;
    }
}