class SnakeGame {
    Deque<Pair<Integer, Integer>> bodyQueue;
    HashSet<Pair<Integer, Integer>> body;
    Queue<Pair<Integer, Integer>> foodQueue;
    int foodEaten;
    int width;
    int height;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width - 1;
        this.height = height - 1;
        foodEaten = 0;
        
        bodyQueue = new LinkedList<>();
        bodyQueue.offer(new Pair<>(0,0));
        body = new HashSet();
        body.add(new Pair<>(0,0));
        
        foodQueue = new LinkedList<>();
        for(int[] f : food)
            foodQueue.offer(new Pair<>(f[0], f[1]));
    }
    
    public int move(String direction) {
        // Find where the head would be if moved in that direction
        // Check to see if the snake would die
        // Check to see if there is food at that part
        // Return food eaten 
        Pair<Integer, Integer> nextDirection = move(direction, bodyQueue.peekFirst());
        if(snakeDies(nextDirection))
            return -1;
        
        if(!foodQueue.isEmpty() && !body.contains(foodQueue.peek()) && nextDirection.equals(foodQueue.peek())){
            body.add(nextDirection);
            bodyQueue.addFirst(nextDirection);
            foodQueue.poll();
            ++foodEaten;
            return foodEaten;
        }
        
        body.remove(bodyQueue.pollLast());
        body.add(nextDirection);
        bodyQueue.addFirst(nextDirection);
        return foodEaten;
    }
    
    public Pair<Integer, Integer> move(String direction, Pair<Integer, Integer> curr){
        if(direction.equals("L")){
            return new Pair<>(curr.getKey(), curr.getValue() - 1);
        } else if(direction.equals("R")){
            return new Pair<>(curr.getKey(), curr.getValue() + 1);
        } else if(direction.equals("U")){
            return new Pair<>(curr.getKey() - 1 , curr.getValue());
        } else{
            return new Pair<>(curr.getKey() + 1, curr.getValue());
        }
    }
    
    public boolean snakeDies(Pair<Integer, Integer> nextDirection){
        int row = nextDirection.getKey();
        int col = nextDirection.getValue();
        
        if(row < 0 || row > height || col < 0 || col > width)
            return true;
        
        return !nextDirection.equals(bodyQueue.peekLast()) && body.contains(nextDirection);
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */