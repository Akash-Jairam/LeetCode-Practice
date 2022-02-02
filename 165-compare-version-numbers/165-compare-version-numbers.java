class Solution {
    public int compareVersion(String version1, String version2) {
        // Iterate through both strings, 
        // Advance counters until you meet a decimal point while constructing the number from that point
        // Compare numbers
        // Return result if numbers are not equal
        // Return 0
           int v1Pointer = 0; int v2Pointer = 0;
           int v1Length = version1.length() ;
           int v2Length = version2.length();
           int v1Num = 0, v2Num = 0;
           while(v1Pointer < v1Length || v2Pointer < v2Length){
               // Find v1 num
               while(v1Pointer < v1Length && version1.charAt(v1Pointer) != '.'){
                   v1Num = v1Num * 10 + Character.getNumericValue(version1.charAt(v1Pointer));
                   v1Pointer++;
               }
               while(v2Pointer < v2Length && version2.charAt(v2Pointer) != '.'){
                   v2Num = v2Num * 10 + Character.getNumericValue(version2.charAt(v2Pointer));
                   v2Pointer++;
               }
               int result = Integer.compare(v1Num, v2Num);
               if(result != 0)
                   return result;
               v1Pointer++;
               v2Pointer++;
               v1Num = 0;
               v2Num = 0;
           }
        
        return 0;
    }
}