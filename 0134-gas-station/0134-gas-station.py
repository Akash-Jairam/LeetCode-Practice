class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        totalGas = 0
        remGas = 0
        startIdx = 0
        
        for i in range(len(gas)):
            totalGas += gas[i] - cost[i]
            remGas += gas[i] - cost[i]
            
            if remGas < 0:
                remGas = 0
                startIdx =  i + 1
            
        
        return startIdx if totalGas >= 0 else -1