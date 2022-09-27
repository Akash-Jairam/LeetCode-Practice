class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        int[] inDegree = new int[recipes.length];
        HashMap<String, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < recipes.length; ++i){
            for(String in : ingredients.get(i)){
                if(!map.containsKey(in)) map.put(in, new ArrayList<>());
                
                map.get(in).add(i);
            }
            inDegree[i] = ingredients.get(i).size();
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(supplies));
        
        while(!queue.isEmpty()){
            String curr = queue.poll();
            if(map.containsKey(curr)){
                for(int i : map.get(curr)){
                    inDegree[i]--;
                    if(inDegree[i] == 0){
                        res.add(recipes[i]);
                        queue.offer(recipes[i]);
                    }
                }
            }
        }
        
        return res;
    }
}