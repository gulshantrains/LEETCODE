class Solution {
    class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] maxSubsequence(int[] nums, int k) {
        // Step 1: Use a min-heap to find the k largest values along with their indices.
        // This min-heap will store 'Pair' objects. The comparison (a.val - b.val)
        // ensures that the smallest 'val' will be at the top of the heap.
        // When the heap size exceeds k, we remove the smallest element.
        PriorityQueue<Pair> minHeapForLargestVals = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < nums.length; i++) {
            if (minHeapForLargestVals.size() < k) {
                // If the heap has less than k elements, just add the current pair.
                minHeapForLargestVals.offer(new Pair(nums[i], i));
            } else if (nums[i] > minHeapForLargestVals.peek().val) {
                // If the heap is full (size k) and the current number is larger
                // than the smallest element in the heap, remove the smallest
                // and add the current one.
                minHeapForLargestVals.poll();
                minHeapForLargestVals.offer(new Pair(nums[i], i));
            }
        }

        // Step 2: Now, minHeapForLargestVals contains the k largest elements.
        // We need to retrieve them in their original order.
        // Use a min-heap sorted by index to preserve the original order.
        PriorityQueue<Pair> sortedByIndexHeap = new PriorityQueue<>((a, b) -> a.idx - b.idx);

        // Move all elements from the value-sorted heap to the index-sorted heap.
        while (!minHeapForLargestVals.isEmpty()) {
            sortedByIndexHeap.offer(minHeapForLargestVals.poll());
        }

        // Step 3: Extract the values in sorted index order to form the subsequence.
        int[] result = new int[k];
        int i = 0;
        while (!sortedByIndexHeap.isEmpty()) {
            result[i++] = sortedByIndexHeap.poll().val;
        }

        return result;
    }
}