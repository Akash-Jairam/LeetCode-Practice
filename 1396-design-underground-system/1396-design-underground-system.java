class UndergroundSystem {
    HashMap<Integer, Trip> currentTrips;
    HashMap<String, List<Trip>> completedTrips;
    
    
    public UndergroundSystem() {
        this.currentTrips = new HashMap<>();
        this.completedTrips = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if(this.currentTrips.containsKey(id))
            return;
        
        this.currentTrips.put(id, new Trip(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(!this.currentTrips.containsKey(id))
            return;
        
        Trip curr = currentTrips.get(id);
        currentTrips.remove(id);
        curr.end = stationName;
        curr.endTime = t;
        
        completedTrips.putIfAbsent(curr.start, new ArrayList<>());
        completedTrips.get(curr.start).add(curr);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<Trip> trips = completedTrips.get(startStation);
        if(trips == null || trips.size() == 0)
            return 0;
        
        int count = 0;
        int total = 0;
        
        for(Trip trip : trips){
            if(trip.end.equals(endStation)){
                total += (trip.endTime - trip.startTime);
                ++count;
            }
        }
        
        return total / (double) count;
    }
}

class Trip {
    int id;
    String start;
    int startTime;
    String end;
    int endTime;
    
    public Trip(int id, String stationName, int t){
        this.id = id;
        this.start = stationName;
        this.startTime = t;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */