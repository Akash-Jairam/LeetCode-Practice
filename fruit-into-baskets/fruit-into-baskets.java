class Solution {
    public int totalFruit(int[] fruits) {
       // Create our max variable
       // Create a map to store the last index of each type of fruit tree encountered
       // Create two pointers and set them both to the first index of the array
       // If the size of our map is less than or equal to 2, we put the current type of fruit tree and its index into our map and we increment our right pointer
        // If the size of our map is greater than 2, we iterate through all the values in our map to get the lowest one and we remove that type of tree from our map
        // Before our loop ends, we subtract the right and left pointers to get our max variable
        int max = 0, left = 0, right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(right < fruits.length){
            if(map.size() <= 2){
                map.put(fruits[right], right);
                right++;
            }
            
            if(map.size() > 2){
                int min = fruits.length;
                for(int tree : map.values()){
                    min = Math.min(min, tree);
                }
                left = min + 1;
                map.remove(fruits[min]);
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}