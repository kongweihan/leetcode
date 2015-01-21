public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        // first pass
        // if we start at i, and end up using up all gas at j, then i~j are all rulded out
        // reason: at i we start with 0 gas, between i and j-1 we always have 0 or more gas left
        // so it's like we have tested whether we can success if we start with 0 or more gas between i and j-1, and we fail
        // so if we start with exactly 0 gas anywhere between i and j, we must fail, too
        // we can't start at j because at j we using up all gas, so j must have cost[j] > gas[j]
        int rest = 0;
        for (int i = 0; i < gas.length; i++) {
            rest = rest + gas[i] - cost[i];
            if (rest < 0) {
                start = i+1;
                rest = 0;
            }
        }
        if (start == gas.length) return -1;
        // second pass
        for (int i = 0; i < gas.length; i++) {
            if (i == start) return i;
            rest = rest + gas[i] - cost[i];
            if (rest < 0) return -1;
        }
        return -1; // never happen
    }
}
