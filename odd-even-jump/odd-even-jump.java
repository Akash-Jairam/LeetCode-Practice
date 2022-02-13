class Solution {
    public int oddEvenJumps(int[] arr) {
        // We need two boolean arrays to track the results of jumping up or jumping down at each index
        // We will set the final index of each boolean array to true and we will deduce the result from these indices (bottom up)
        // We will use a treeMap which will store our elements in a sorted order
        // We will iterate through the array from right to left
        // Check to see if it is possible for us to go low or go high
        // We will then update our array if either is a possibility to pave the way for the other elements. This is done by setting the low of the current index to the high of the index of the value we found and doing the opposite for the high. (Only if we found values)
        // If the odd array (high array) of the current index is true, we will increment our count
        // Put the map with the key being the array value and the value being it's index
        // Return our count
        boolean[] high = new boolean[arr.length];
        boolean[] low = new boolean [arr.length];
        high[arr.length-1] = true;
        low[arr.length-1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[arr.length-1], arr.length-1);
        int count = 1;
        
        for(int i = arr.length-2; i >=0; --i){
            Map.Entry<Integer, Integer> oddJump = map.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> evenJump = map.floorEntry(arr[i]);
            
            if(oddJump != null){
                high[i] = low[oddJump.getValue()];
            }
            
            if(evenJump != null){
                low[i] = high[evenJump.getValue()];
            }
            
            if(high[i])
                count++;
            
            map.put(arr[i], i);
        }
        
        return count;
    }
}