// https://leetcode.com/problems/gas-station/
// Medium


//This solution will throw TLE.
// Here basically i was thinking of checking currentGas at each station.
// and at the station that has enough gas to start, i was using another loop to check if it'll be able to complete the whole journey.
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        loop: for(int i = 0; i < gas.length; i++){
            int currentGas = 0;
            currentGas += (gas[i] - cost[i]);
            if(currentGas >= 0){
                int j = (i+1)%gas.length;
                while(j%gas.length != i){
                    currentGas += (gas[j%gas.length] - cost[j%gas.length]);
                    if(currentGas < 0) continue loop;
                    j++;
                }
                return i;
            }
        }
        return -1;
    }
}

// The Right Solution!!
// Here we used a totalGasLeft variable, that'll store all the gas - cost calculation for the whole trip
// so that we don't have to check if the whole trip is possible in a separate loop, here we can just do that with a single variable.

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGas = 0, totalGasLeft = 0, startPrev = 0;
        for(int i = 0; i < gas.length; i++){
            int diff = (gas[i] - cost[i]);
            currentGas += diff;
            totalGasLeft += diff;
            if(currentGas < 0){
                currentGas = 0;
                startPrev = (i+1)%gas.length; // this is to ensure that it doesn't go out of bound.
            }
        }
        if(totalGasLeft >= 0) return startPrev + 1;
        return -1;
    }
}
