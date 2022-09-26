class Solution {
    public boolean equationsPossible(String[] equations) {
       int[] uf = new int[26];
       for(int i = 0; i < 26; ++i) uf[i] = i;
        
        for(String e : equations){
            if(e.charAt(1) == '='){
                uf[find(e.charAt(0) - 'a', uf)] = find(e.charAt(3) - 'a', uf);
            }
        }
        
        for(String e : equations){
            if(e.charAt(1) == '!'){
                if(uf[find(e.charAt(0) - 'a', uf)] == find(e.charAt(3) - 'a', uf))
                    return false;
            }
        }
        
        return true;
    }
    
    public int find(int x, int[] uf){
        if(x != uf[x]) uf[x] = find(uf[x], uf);
        return uf[x];
    }
}