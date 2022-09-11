class ATM {
    
    long[] amounts = new long[5];
    int[] denoms = new int[] {20, 50, 100, 200, 500};
    public ATM() {
        
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < amounts.length; ++i){
            amounts[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] res = new int[5];
        
        for(int i = 4; i >= 0; --i){
            int currBills = (int) Math.min(amounts[i], amount / denoms[i]);
            amount -= currBills * denoms[i];
            res[i] += currBills;
        }
        
        if(amount != 0)
            return new int[]{-1};
        
        for(int i = 0; i < 5; ++i){
            amounts[i] -= res[i];
        }
        
        return res;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */