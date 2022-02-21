class Solution {
    public int oddEvenJumps(int[] arr) {
        // Since we know that, if we are at the last element, the jump is complete regardless of whether the jump is odd or even, we can use a bottom up approach starting from the last element
        // We will need two arrays to track the possibility to the a jump at each index being successful, one for odd jumps and one for even jumps
        // We will initialize these arrays with the true values for the positions at the last index given what we said before/
        // We will then create a tree map and add the value at the end as a key and the index as a value
        // We will then iterate through the array from right to left starting from the second to last index
        // We will get try to get the entry from our map with the lowest value greater than the current element and the entry with the highest value less than the current element
        // If those entries exist, we will assign the current index in our boolean arrays to the entry's value / index of the opposite array (we go high after going low for example)
        // Now, we check to see if the odd jump at the current index is true, if it is, then we increment our count because odd jumps at 1 will successfuly make it to the end
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        boolean[] high = new boolean[arr.length];
        boolean[] low = new boolean[arr.length];
        int count = 1;
        high[arr.length-1] = true;
        low[arr.length-1] = true;
        tree.put(arr[arr.length-1], arr.length-1);
        
        for(int i = arr.length-2; i >= 0; --i){
            Map.Entry<Integer,Integer> oddEntry = tree.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> evenEntry = tree.floorEntry(arr[i]);
            
            if(oddEntry != null){
                high[i] = low[oddEntry.getValue()];
            }
            
            if(evenEntry != null){
                low[i] = high[evenEntry.getValue()];
            }
            
            if(high[i])
                ++count;
            
            tree.put(arr[i], i);
        }
        
        return count;
    }
}