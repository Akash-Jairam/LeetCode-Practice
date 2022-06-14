class SnakeGame {
    int height;
    int width;
    int foodEaten;
    
    HashSet<Pair<Integer, Integer>> body;
    Deque<Pair<Integer, Integer>> bodyQueue;
    Queue<Pair<Integer, Integer>> foodQueue;
    public SnakeGame(int width, int height, int[][] food) {
        this.height = height-1;
        this.width = width - 1;
        foodEaten = 0;
        
        body = new HashSet();
        body.add(new Pair<>(0, 0));
        bodyQueue = new LinkedList<>();
        bodyQueue.offer(new Pair<>(0,0));
        
        foodQueue = new LinkedList<>();
        for(int[] f : food){
            foodQueue.offer(new Pair<>(f[0], f[1]));
        }
    }
    
    public int move(String direction) {
        Pair<Integer, Integer> nextDirection = move(bodyQueue.peekFirst(), direction);
        if(snakeDie(nextDirection))
            return -1;
        
        if(!foodQueue.isEmpty() && !body.contains(foodQueue.peek()) && nextDirection.equals(foodQueue.peek())){
            ++foodEaten;
            body.add(nextDirection);
            bodyQueue.addFirst(nextDirection);
            foodQueue.poll();
            return foodEaten;
        }
         body.remove(bodyQueue.pollLast());
        body.add(nextDirection);
        bodyQueue.addFirst(nextDirection);
       
        return foodEaten;
    }
    
    public Pair<Integer, Integer> move(Pair<Integer, Integer> currentPos, String direction){
        if(direction.equals("L")){
            return new Pair<>(currentPos.getKey(), currentPos.getValue() - 1);
        } else if(direction.equals("R")){
            return new Pair<>(currentPos.getKey(), currentPos.getValue() + 1);
        } else if(direction.equals("U")){
            return new Pair<>(currentPos.getKey() - 1,currentPos.getValue());
        } else {
            return new Pair<>(currentPos.getKey() + 1, currentPos.getValue());
        }
    }
    
    public boolean snakeDie(Pair<Integer, Integer> curr){
        int row = curr.getKey();
        int col = curr.getValue();
        
        if(row < 0 || row > height || col < 0 || col > width)
            return true;
        
        return !curr.equals(bodyQueue.peekLast()) && body.contains(curr);
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */