class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();

        // If k is equal to or greater than the length of the number,
        // all digits will be removed, so the result is "0".
        if (k >= n) {
            return "0";
        }

        // Use Deque (ArrayDeque) as a stack for better performance than legacy Stack class.
      
        Deque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char currentChar = num.charAt(i);
            /* While the deque is not empty, k > 0, and the top of the deque (last element)
             is greater than the current character, pop from the deque.
             This ensures we build the smallest possible number sequence.
            */
            while (!dq.isEmpty() && k > 0 && dq.peekLast() > currentChar) {
                dq.pollLast(); // Pop from the "top" of the stack
                k--;
            }
            dq.offerLast(currentChar); // Push to the "top" of the stack
        }

        /* After iterating through all digits, if k is still greater than 0,
         it means the remaining digits in the deque are in increasing order (e.g., "12345").
         We need to remove the largest digits from the end of the deque.
        */
        while (k > 0 && !dq.isEmpty()) {
            dq.pollLast();
            k--;
        }

        // Handle leading zeros before constructing the string.
        // Remove from the front of the deque (bottom of the stack).
        while (!dq.isEmpty() && dq.peekFirst() == '0') {
            dq.pollFirst();
        }

        // If the deque is empty after all operations (e.g., num="123", k=3 or num="000", k=1),
        // the result is "0".
        if (dq.isEmpty()) {
            return "0";
        }

        // Build the final string from the characters in the deque.
        StringBuilder sb = new StringBuilder();
        for (char c : dq) { // Iterates from first (bottom) to last (top)
            sb.append(c);
        }

        return sb.toString();
    }
}