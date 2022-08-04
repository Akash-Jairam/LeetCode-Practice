class Solution {
    public int mirrorReflection(int p, int q) {
        int m = q, n = p;
        
        while(m % 2 == 0 && n % 2 == 0){
            m /= 2;
            n /= 2;
        }
        
        if (m % 2 == 0 && n % 2 == 1) return 0; //downwards and right wall
        if (m % 2 == 1 && n % 2 == 1) return 1; // upwards and right wall
        if (m % 2 == 1 && n % 2 == 0) return 2; // upwards and left wall
        
        return -1;
    }
}