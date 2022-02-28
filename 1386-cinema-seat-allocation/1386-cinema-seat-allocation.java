class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Create a map with key of integer (row) and HashSet as a value (to store reserved seats)
        // If the size of the map < n, that means there are some rows with no reserved seats
        // Therefore, our count will be at least (size - map) * 2
        // Iterate through each row in the map and use its hashset to see if it is possible to have an optimal allocation, if it is increase our count
        // Return count
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] reservation : reservedSeats){
            map.putIfAbsent(reservation[0], new HashSet());
            map.get(reservation[0]).add(reservation[1]);
        }
        int count = (n - map.size()) * 2;
        for(int key : map.keySet()){
            if(isAvailable(map.get(key), 2, 9))
                count += 2;
            else if(isAvailable(map.get(key),2,5) || isAvailable(map.get(key), 6,9) || isAvailable(map.get(key), 4, 7))
                ++count;
        }
        
        return count;
    }
    
    public boolean isAvailable(HashSet<Integer> set, int start, int end){
        for(int i = start; i <= end; ++i){
            if(set.contains(i))
                return false;
        }
        
        return true;
    }
}