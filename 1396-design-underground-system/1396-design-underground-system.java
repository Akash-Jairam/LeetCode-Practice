class UndergroundSystem {
    HashMap<Integer, Trip> curr;
    HashMap<String, List<Trip>> completed;
    public UndergroundSystem() {
        this.curr = new HashMap<>();
        this.completed = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Trip trip = new Trip(id, stationName, t);
        curr.put(id, trip);
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(curr.containsKey(id)){
            Trip trip = curr.get(id);
            trip.destination = stationName;
            trip.end = t;
            if(!completed.containsKey(trip.startPoint)){
                completed.put(trip.startPoint, new ArrayList<>());
            }
            completed.get(trip.startPoint).add(trip);
            curr.remove(id);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<Trip> trips = completed.get(startStation);
        int size = 0;
        int totalTime = 0;
        for(Trip trip : trips){
            if(trip.destination.equals(endStation)){
                totalTime += (trip.end - trip.start);
                ++size;
            }
        }
        
        return totalTime / (double) size;
    }
}

class Trip {
    int id;
    int start;
    String startPoint;
    String destination;
    int end;
    
    public Trip(int id, String startPoint, int start){
        this.id = id;
        this.startPoint = startPoint;
        this.start = start;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */