class Solution {
    public int totalFruit(int[] fruits) {
        // Create a variable to track the current total number of fruits and the max
        // Create a linked map
        // Iterate through array
        // If a tree is not in the map and the size of the map is equal to 2, remove the first item in the map and subtract its count from your current total
        // Return the max total
        // Create a variable to track the current total number of fruits and the max
        // Create a linked map
        // Iterate through array
        // If a tree is not in the map and the size of the map is equal to 2, remove the first item in the map and subtract its count from your current total
        // Return the max total
        int left = 0;
        int[] map = new int[fruits.length];
        int runningTotal = 0;
        int max = 0;
        int basketCount = 0;

        for (int right = 0; right < fruits.length; ++right) {
            if (map[fruits[right]] == 0 && basketCount == 2) {
                max = Math.max(runningTotal, max);
                int lastIndexOfCharToRemove = -1;
                int count = 0;
                for(int i = left; i < right-1; ++i){
                    if(fruits[i] != fruits[right-1]) {
                        map[fruits[i]]--;
                        lastIndexOfCharToRemove = i;
                        map[fruits[right-1]] -= count;
                        count = 0;
                    } else
                        count++;
                }
                left = lastIndexOfCharToRemove +1;
                runningTotal = right-left;

            } else if (map[fruits[right]] == 0) {
                basketCount++;
            }
            map[fruits[right]]++;
            runningTotal++;
        }

        return Math.max(max, runningTotal);
    }
}