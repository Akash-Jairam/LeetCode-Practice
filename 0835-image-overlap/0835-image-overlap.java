class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0)
            return 0;
        int n = A.length;
        List<int[]> p1 = new ArrayList<int[]>();
        List<int[]> p2 = new ArrayList<int[]>();
        for (int i = 0; i < n*n; i++) {
            if (A[i/n][i%n] == 1)
                p1.add(new int[]{i/n, i%n});
            if (B[i/n][i%n] == 1)
                p2.add(new int[]{i/n, i%n});
        }
        Map<String, Integer> diffMap = new HashMap<String, Integer>();
        int ret = 0;
        for (int[] a : p1) {
            for (int[] b : p2) {
                String diff = ""+(a[0]-b[0])+" "+(a[1]-b[1]);
                if (diffMap.containsKey(diff))
                    diffMap.put(diff, diffMap.get(diff)+1);
                else
                    diffMap.put(diff, 1);
                ret = Math.max(ret, diffMap.get(diff));
            }
        }
        return ret;
    }
}