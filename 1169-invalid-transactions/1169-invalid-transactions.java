class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalid = new ArrayList<>();
        HashMap<String, List<Transaction>> map = new HashMap<>();
        
        for( String transaction : transactions){
            Transaction t = new Transaction(transaction);
            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);
        }
        
        for(String transaction : transactions){
            Transaction t = new Transaction(transaction);
            if(!isValid(map.get(t.name), t)){
                invalid.add(transaction);
            }
        }
        return invalid;
    }
    
    public boolean isValid(List<Transaction> transactions, Transaction transaction){
        if(transactions.size() <= 1 && transaction.amount < 1000)
            return true;
        
        for(Transaction t : transactions){
            if(transaction.inValidTransaction(t.city, t.time)){
                return false;
            }
        }
        
        return true;
    }
}

class Transaction{
    String name;
    int id;
    int time;
    int amount;
    String city;
    
    
    public Transaction(String t){
        String[] info = t.split(",");
        this.name = info[0];
        this.time = Integer.parseInt(info[1]);
        this.amount = Integer.parseInt(info[2]);
        this.city = info[3]; 
    }
    
    public boolean inValidTransaction(String city, int time){
        return invalidAmount() || differentCity(city, time);
    }
    
    public boolean invalidAmount(){
        return this.amount > 1000;
    }
    
    public boolean differentCity(String city, int time){
        return !this.city.equals(city) && Math.abs(this.time - time) <= 60;
    }
}