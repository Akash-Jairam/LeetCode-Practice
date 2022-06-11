class SnakeGame {

    private int height;
    private int width;
    private Set<Pair<Integer, Integer>> body;
    private Deque<Pair<Integer, Integer>> bodyQueue;
    private Queue<Pair<Integer, Integer>> foodQueue;
    private int foodEat;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width - 1;
        this.height = height - 1;
        foodEat = 0;
        
        body = new HashSet();
        bodyQueue = new LinkedList<>();
        body.add(new Pair<>(0, 0));
        bodyQueue.add(new Pair<>(0,0));
        
        foodQueue = new LinkedList<>();
        for(int[] f : food){
            foodQueue.offer(new Pair<> (f[0], f[1]));
        }
        
    }
    
    private Pair<Integer, Integer> move(Pair<Integer, Integer> currentPos, String dir){
        if(dir.equals("L")){
            return new Pair<>(currentPos.getKey() , currentPos.getValue()  -1 );
        } else if(dir.equals("R")){
            return new Pair<>(currentPos.getKey() , currentPos.getValue() + 1);
        }  else if(dir.equals("U")){
            return new Pair<>(currentPos.getKey() - 1 , currentPos.getValue());
        }  else {
            return new Pair<>(currentPos.getKey() + 1 , currentPos.getValue()  );
        }
    }
    
    private boolean snakeDie(Pair<Integer, Integer> nextPosition){
        int row = nextPosition.getKey();
        int col = nextPosition.getValue();
        
        if(row < 0 || row > height || col < 0 || col > width)
            return true;
        
        // Ensure snake didn't bite its tail or its body
        return (!nextPosition.equals(bodyQueue.peekFirst()) && body.contains(nextPosition));
    }
    
    public int move(String direction){
        Pair<Integer, Integer> currentPosition = bodyQueue.peekLast();
        Pair<Integer, Integer> nextPosition = move(currentPosition, direction);
        if(snakeDie(nextPosition))
            return -1;
        
        if(!foodQueue.isEmpty() && !body.contains(foodQueue.peek()) && nextPosition.equals(foodQueue.peek())){
            foodQueue.poll();
            body.add(nextPosition);
            bodyQueue.addLast(nextPosition);
            ++foodEat;
            return foodEat;
        }
        
        body.remove(bodyQueue.pollFirst());
        body.add(nextPosition);
        bodyQueue.addLast(nextPosition);
        return foodEat;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */