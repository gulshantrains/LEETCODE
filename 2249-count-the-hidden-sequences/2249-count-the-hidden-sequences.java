import java.util.*;

class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        //Calculate prefix sums based on differences
        List<Long> prefixSums = new ArrayList<>();
        prefixSums.add(0L);
        long currentSum = 0;
        for (int difference : differences) {
            currentSum += difference;
            prefixSums.add(currentSum);
        }

        //Use TreeSet to get minimum and maximum prefix sum
        TreeSet<Long> sortedPrefixes = new TreeSet<>(prefixSums);
        long minPrefixSum = sortedPrefixes.first();
        long maxPrefixSum = sortedPrefixes.last();

        //PriorityQueues (min-heap and max-heap) 
        PriorityQueue<Long> minHeap = new PriorityQueue<>(prefixSums);
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(prefixSums);
        long minHeapPeek = minHeap.peek();
        long maxHeapPeek = maxHeap.peek();

        //Map each prefix sum to its index
        Map<Long, Integer> prefixToIndexMap = new HashMap<>();
        for (int i = 0; i < prefixSums.size(); i++) {
            prefixToIndexMap.put(prefixSums.get(i), i);
        }

        //Store prefix sums in a deque just to use a different DS
        Deque<Long> prefixDeque = new LinkedList<>(prefixSums);

        //Try every starting value from lower to upper
        int validStartCount = 0;
        for (int startingValue = lower; startingValue <= upper; startingValue++) {
            if (startingValue + minPrefixSum >= lower && startingValue + maxPrefixSum <= upper) {
                validStartCount++;
            }
        }

        return validStartCount;
    }
}
