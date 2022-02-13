class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        // Create a treemap of integer keys and arraylist values which will hold our values and the labels they correspond to
        // Create a map to track our labels and their uses which we will compare against our uselimit
        // Iterate throught the values and add them to the map if they aren't already there
        // Add the label to the arraylist of the value
        // Create variables for our sum and our count
        // Iterate through the keys of the treemap,  making sure that the count does not surpass numwanted
        // Iterate through the labels for the corresponding key and use the map to check the uselimit of the label while also keeping numwanted in consideration
        // If the label is within the numlimit, we add the value to our sum and update the usecount for the label
        // Return our sum
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Comparator.reverseOrder());
        Map<Integer, Integer> labelTracker = new HashMap<>();
        int sum = 0;
        int count = 0;
        for(int i = 0; i < values.length; ++i){
            treeMap.putIfAbsent(values[i], new ArrayList<>());
            treeMap.get(values[i]).add(labels[i]);
        }
        
        for(int key : treeMap.keySet()){
            if(count == numWanted)
                break;
            
            for(int label : treeMap.get(key)){
                if(count == numWanted)
                    break;
                if(labelTracker.getOrDefault(label, 0) < useLimit){
                    sum += key;
                    ++count;
                    labelTracker.put(label,labelTracker.getOrDefault(label, 0)+1);
                }
            }
        }
        return sum;
    }
}