class Solution {
    public int oddEvenJumps(int[] arr) {
        // We need to employ a bottom up dynamic programming approach to solve this problem
        // We know that at the last index, if we make an odd jump or an even jump, it is a good starting index
        // We need to reverse engineer the other good starting indexes based on this
        // We will create our count variable and set it to 1 (the last index)
        // Create two boolean arrays to track the success of the lower and higher jumps at each index
        // Create a treemap and put the last element in there
        // Iterate through the array from right to left. 
        //Get the entry in the treemap that is lowest or equal to the value at the current index
        // Do the same to get the entry in the treemap that is highest or equal to the current index
        // If highest is not null, we assign the result of the high array at the current index to the low array of the index of the highest value we got
        // If the lowest is not null, we assign the result of the low array at the current index to the high array of the index of the lowest value we got
        // We do the above steps because you must alternate between odd and even
        // If highest is true, we increment our count
        // Return count at the end
        int count = 1;
        int last = arr.length-1;
        boolean[] low = new boolean[arr.length];
        boolean[] high = new boolean[arr.length];
        low[last] = true;
        high[last] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[last], last);
        
        for(int i = arr.length-2; i >=0; --i){
            Map.Entry<Integer, Integer> lower = map.floorEntry(arr[i]);
            Map.Entry<Integer,Integer> higher = map.ceilingEntry(arr[i]);
            
            if(lower != null){
                low[i] = high[lower.getValue()];
            }
            
            if(higher != null){
                high[i] = low[higher.getValue()];
            }
            
            if(high[i])
                count++;
            
            map.put(arr[i], i);
        }
        return count;
    }
}