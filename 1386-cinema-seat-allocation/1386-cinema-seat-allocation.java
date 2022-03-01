class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Create a hashmap where the key is an integer which represents the current row and the value is a hashset which contains the positions of the reserved seats
        // Iterate through our given array and create entries where needed before using the row in the subarray to get the corresponding hashset to add the reserved seat
        // If the size of our map is not equal to n, that means that some rows have no reservation. We must increment our count by 2 for each row with no reservation
        // Now, we iterate through our keyset and each key's hashset to tell whether it is possible for a family(ies) to be seated in that row
        // We will do this by making a call to a function which accepts a hashset, a start position, and an end position before returning false if the hashset contains a value within that range or true if it doesn't
        // Finally, we return our count
        HashMap<Integer, HashSet<Integer>> reserved = new HashMap<>();
        int numFamilies = 0;
        for(int[] reservedRow : reservedSeats){
            reserved.putIfAbsent(reservedRow[0], new HashSet());
            reserved.get(reservedRow[0]).add(reservedRow[1]);
        }
        
        if(reserved.size() < n )
            numFamilies += (n - reserved.size()) * 2;
        
        for(int key : reserved.keySet()){
            if(isAvailable(reserved.get(key), 2, 9))
                numFamilies += 2;
            else if(isAvailable(reserved.get(key), 2, 5) || isAvailable(reserved.get(key), 6, 9) || isAvailable(reserved.get(key), 4,7))
                ++numFamilies;
        }
        
        return numFamilies;
            
    }
    
    public boolean isAvailable(HashSet<Integer> reservations, int start, int end){
        for(int i = start; i <= end; ++i){
            if(reservations.contains(i))
                return false;
        }
        
        return true;
    }
}