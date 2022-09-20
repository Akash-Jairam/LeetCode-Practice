class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        int[] inDegree = new int[recipes.length];
        
        for(int i = 0; i < ingredients.size(); ++i){
            for(String ing : ingredients.get(i)){
                if(!map.containsKey(ing)) map.put(ing, new ArrayList<>());
                
                map.get(ing).add(i);
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
                        queue.add(recipes[i]);
                    }
                }
            }
        }
        
        return res;
    }
}