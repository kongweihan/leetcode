public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            hash.put(target - numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (hash.containsKey(numbers[i]) && i != hash.get(numbers[i])) {
                int[] result = new int[2];
                result[0] = Math.min(i, hash.get(numbers[i])) + 1;
                result[1] = Math.max(i, hash.get(numbers[i])) + 1;
                return result;
            }
        }
        return null; // never happen
    }
}
