class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
         Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxVerticalLength = horizontalCuts[0]; //originally named maxH (hence the confusion). this value is initialized to horizontalCuts[0] since the current vertical length is the distance to the first horizontal cut
        int maxHorizontalLength = verticalCuts[0]; //originally named maxV (hence the confusion). this value is initialized to verticalCuts[0] since the current horizontal length is the distance to the first vertical cut
        
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxVerticalLength = Math.max(maxVerticalLength, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        maxVerticalLength = Math.max(maxVerticalLength, h - horizontalCuts[horizontalCuts.length - 1]);

        for (int i = 1; i < verticalCuts.length; i++) {
            maxHorizontalLength = Math.max(maxHorizontalLength, verticalCuts[i] - verticalCuts[i - 1]);
        }

        maxHorizontalLength = Math.max(maxHorizontalLength, w - verticalCuts[verticalCuts.length - 1]);
        return (int)((long) maxVerticalLength * maxHorizontalLength % 1000000007 );
    }
}