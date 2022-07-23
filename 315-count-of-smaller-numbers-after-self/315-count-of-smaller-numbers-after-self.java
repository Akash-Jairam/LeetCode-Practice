class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) == 0) {
            return new ArrayList<>();
        }
        
        // Merge sort indices instead of values
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        int[] tmpIndices = new int[n];
        int[] counts = new int[n];
        mergeSort(nums, indices, tmpIndices, counts, 0, n - 1);
        
        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(counts[i]);
        }
        return result;
    }
    
    private void mergeSort(int[] nums, int[] indices, int[] tmpIndices, int[] counts, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, indices, tmpIndices, counts, left, mid);
        mergeSort(nums, indices, tmpIndices, counts, mid + 1, right);
        merge(nums, indices, tmpIndices, counts, left, mid, right);
    }
    
    private void merge(int[] nums, int[] indices, int[] tmpIndices, int[] counts, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int rightCount = 0;
        int sortedIndex = left;
        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[indices[leftIndex]] > nums[indices[rightIndex]]) {
                tmpIndices[sortedIndex] = indices[rightIndex];
                // Increase rightCount if left value is bigger than right value
                rightCount++;
                rightIndex++;
            } else {
                tmpIndices[sortedIndex] = indices[leftIndex];
                // If left value is smaller, increase the counts by rightCount found so far
                counts[indices[leftIndex]] += rightCount;
                leftIndex++;
            }
            sortedIndex++;
        }
        while (leftIndex <= mid) {
            // If there are remaining left values, increase their counts by adding rightCount
            tmpIndices[sortedIndex] = indices[leftIndex];
            counts[indices[leftIndex]] += rightCount;
            leftIndex++;
            sortedIndex++;
        }
        if (rightIndex <= right) {
            System.arraycopy(indices, rightIndex, tmpIndices, sortedIndex, right - rightIndex + 1);
        }
        System.arraycopy(tmpIndices, left, indices, left, right - left + 1);
    }
}