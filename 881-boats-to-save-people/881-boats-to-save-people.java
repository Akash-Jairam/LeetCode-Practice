class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //Sort the array
        if(people == null || people.length == 0)
            return 0;
        
        Arrays.sort(people);
        // Set the start to index 0 and end to last index
        // While start <= end
        // If the sum is <= the limit, we increment the boat count
        // If it is greater, we increment the boat count and decrement the end index
        int start = 0;
        int end = people.length - 1;
        int numBoats = 0;
        while(start <= end){
            int sum = people[start] + people[end];
            if(sum <= limit){
                ++numBoats;
                ++start;
                --end;
            } else {
                ++numBoats;
                --end;
            }
        }
        
        return numBoats;
    }
}