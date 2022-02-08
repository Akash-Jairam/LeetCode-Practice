class Solution {
    public int oddEvenJumps(int[] arr) {
        // Create our good starting index count and set it to 1 since every array that is not null will have at least one good starting index
        // Create two boolean arrays to track our odd (higher) jumps and our even(lower) jumps
        // Set the last value of these arrays to true since the last element is always a good starting index
        // Create a tree map and add the last element as the key and the last index as the value
        // We use a tree map because the order is maintained when we add new elements to it
        // Iterate through the array starting from the second to last element
        // Find the entryset for the value that is greater than equal to the value of the element at the current index
        // Do the same for the entryset for the value that is less than or equal to the value at the current index
        // If the higher entry set is not null, assign the higher array of i to the value stored in lower array at the value/index of the entryset. Since the higher entryset will have to go lower and we already have that stored so we just get that value
        // If the lower entry set is not null, assign the lower array of i to the value stored in the higher array at the value/index of the entryset. Since the lower entryset will have to go higher and we already have that stored so we just get that value.
        // If higher[i] is true, we increment our good starting index count since we know that the first step is always odd/higher so that means we have a valid starting point
        int good_starting_index = 1;
        boolean [] lower = new boolean[arr.length];
        boolean [] higher = new boolean[arr.length];
        int last = arr.length-1;
        lower[last] = true;
        higher[last] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[last], last);
        
        for(int i = last-1; i >= 0; --i){
            Map.Entry higher_entry = map.ceilingEntry(arr[i]);
            Map.Entry lower_entry = map.floorEntry(arr[i]);
            
            if(higher_entry != null){
                higher[i] = lower[(int) higher_entry.getValue()];
            }
            
            if(lower_entry != null){
                lower[i] = higher[(int) lower_entry.getValue()];
            }
            
            if(higher[i] == true)
                good_starting_index++;
            
            map.put(arr[i], i);
        }
        
        return good_starting_index;
    }
}