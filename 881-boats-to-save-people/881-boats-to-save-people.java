class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int numBoats = 0;
        if(people == null || people.length == 0)
            return numBoats;
        
        int start = 0;
        int end = people.length - 1;
        Arrays.sort(people);
        while(start <= end){
            int weight = start == end ? people[start] : people[start] + people[end];
            if(weight <= limit){
                ++start;
                --end;
            } else {
                --end;
            }
            ++numBoats;
        }
        
        return numBoats;
        
    }
}