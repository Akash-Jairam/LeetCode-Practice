class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> set = new HashSet<>();
        set.add(findDistance(p1, p2));
        set.add(findDistance(p1, p3));
        set.add(findDistance(p1, p4));
        set.add(findDistance(p2, p3));
        set.add(findDistance(p2, p4));
        set.add(findDistance(p3, p4));
        return !set.contains(0) && set.size() == 2;
    }
    
    public int findDistance(int[] p1, int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}